package concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

interface Foo {
    
    void first(Runnable printFirst) throws InterruptedException;
    
    void second(Runnable printSecond) throws InterruptedException;
    
    void third(Runnable printThird) throws InterruptedException;
}

// method 1 count down latch 倒计时门闩
class FooByCountDownLatch implements Foo {
    
    private final CountDownLatch firstLatch = new CountDownLatch(1);
    private final CountDownLatch secoundLatch = new CountDownLatch(1);
    
    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstLatch.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        // 该线程在开始运行前等待 n 个线程执行完毕
        firstLatch.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        secoundLatch.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        // 该线程在开始运行前等待 n 个线程执行完毕
        secoundLatch.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

}

// method 2 volatile fastest
// 可见性 + 禁止指令重排
class FooByVolatile implements Foo {
    
    private volatile boolean second = false;
    private volatile boolean third = false;
    
    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        second = true;
    }
    
    public void second(Runnable printSecond) throws InterruptedException {
        while (!second) {} // 自旋锁
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        third = true;
    }
    
    public void third(Runnable printThird) throws InterruptedException {
        while (!third) {} // 自旋锁
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

}

// method 3 atomic
class FooByAtomic implements Foo {
    
    private volatile AtomicBoolean secondAtomicBoolean = new AtomicBoolean(false);
    private volatile AtomicBoolean thirdAtomicBoolean = new AtomicBoolean(false);
    
    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        secondAtomicBoolean.set(true);
    }
    
    public void second(Runnable printSecond) throws InterruptedException {
        while (!secondAtomicBoolean.get()) {} // 自旋锁
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        thirdAtomicBoolean.set(true);
    }
    
    public void third(Runnable printThird) throws InterruptedException {
        while (!thirdAtomicBoolean.get()) {} // 自旋锁
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

}

// method 4 synchronized 同步
class FooBySynchronized implements Foo {
    
    private int lock = 0;
    
    // synchronized关键字可以声明方法也可以在方法体内
    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        synchronized (this) {
            lock++;
            // 调用 notify() 会随机通知，此处如果通知到 t3 线程会死锁，所以全部通知
            notifyAll();
        }
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        if (lock < 1) wait();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        lock++;
        // 只剩 t3 线程需要通知，不用全部通知
        notify();
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (this) {
            while (lock < 2) wait(); // 自旋锁
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }

}

// method 5 semaphore 信号旗
class FooBySemaphore implements Foo {
    
    private Semaphore semaphore = new Semaphore(0); // 0 个许可
    
    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        semaphore.release(); // 发 1 个许可
    }

    public void second(Runnable printSecond) throws InterruptedException {
        semaphore.acquire(); // 消耗 1 个许可才能往下执行
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        semaphore.release(2); // 发 2 个许可
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (!semaphore.tryAcquire(2)) {} // 尝试消耗 2 个许可才能，成功则往下执行，否则循环
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

}

// method 6 lock 重入锁
class FooByLock implements Foo {
    
    private int flag = 0;
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void first(Runnable printFirst) throws InterruptedException {
        // 如果锁被另一个线程持有，则当前线程出于线程调度目的而被禁用，并处于休眠状态，直到获取锁
        // 本质是 acquire
        lock.lock();
        try {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            flag++;
            // 将所有线程从该条件的等待队列移至拥有锁的等待队列
            // 调用 signal() 会随机通知，此处如果通知到 t3 线程会死锁，因为 flag 无法变成 2，所以全部通知
            condition.signalAll();
        } finally {
            // 本质是 release
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try {
            if (flag != 1)
                // 与此相关的锁被释放，出于线程调度目的，当前线程被禁用并休眠直到被通知
                // 本质是 release 被通知后重新 acquire
                condition.await();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            flag++;
            // 将等待时间最长的线程（如果存在）从该条件的等待队列移至拥有锁的等待队列
            // 只剩 t3 线程需要通知，不用全部通知
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try {
            while (flag != 2) // 自旋锁
                condition.await();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        } finally {
            lock.unlock();
        }
    }
}

// method 7 blocking queue 阻塞队列
class FooByBlockingQueue implements Foo {
    
    // 类似 Semaphore
    private BlockingQueue<Integer> secondQueue = new ArrayBlockingQueue<>(1);
    private BlockingQueue<Integer> thirdQueue = new ArrayBlockingQueue<>(1);
    
    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        secondQueue.put(2);
    }
    
    public void second(Runnable printSecond) throws InterruptedException {
        secondQueue.take();
        // printFirst.run() outputs "first". Do not change or remove this line.
        printSecond.run();
        thirdQueue.put(3);
    }
    
    public void third(Runnable printThird) throws InterruptedException {
        thirdQueue.take();
        // printFirst.run() outputs "first". Do not change or remove this line.
        printThird.run();
    }
}

public class PrintInOrder {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        Foo foo = new FooByLock();
        // 三种不同的方式建立线程，推荐实现Runnable接口
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                    TimeUnit.MILLISECONDS.sleep(2000);
                    foo.first(new Runnable() {
                        public void run() {
                            System.out.print("first");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Runnable t2 = () -> {
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
                foo.second(() -> {
                    System.out.print("second");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread t3 = new Thread(() -> {
            try {
                foo.third(() -> {
                    System.out.print("third");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        exec.execute(t1);
        exec.execute(t2);
        exec.execute(t3);
        exec.shutdown();
    }
}

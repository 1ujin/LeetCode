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

// method 1 count down latch
class FooByCountDownLatch {
    
    private final CountDownLatch firstLatch = new CountDownLatch(1);
    private final CountDownLatch secoundLatch = new CountDownLatch(1);
    
    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstLatch.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        firstLatch.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        secoundLatch.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        secoundLatch.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

}

// method 2 volatile fastest
class FooByVolatile {
    
    private volatile boolean second = false;
    private volatile boolean third = false;
    
    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        second = true;
    }
    
    public void second(Runnable printSecond) throws InterruptedException {
        while (!second) {}
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        third = true;
    }
    
    public void third(Runnable printThird) throws InterruptedException {
        while (!third) {}
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

}

// method 3 atomic
class FooByAtomic {
    
    private volatile AtomicBoolean secondAtomicBoolean = new AtomicBoolean(false);
    private volatile AtomicBoolean thirdAtomicBoolean = new AtomicBoolean(false);
    
    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        secondAtomicBoolean.set(true);
    }
    
    public void second(Runnable printSecond) throws InterruptedException {
        while (!secondAtomicBoolean.get()) {}
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        thirdAtomicBoolean.set(true);
    }
    
    public void third(Runnable printThird) throws InterruptedException {
        while (!thirdAtomicBoolean.get()) {}
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

}

// method 4 synchronized
class FooBySynchronized {
    
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
        while (lock < 1) wait();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        lock++;
        // 只剩 t3 线程需要通知，不用全部通知
        notify();
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (this) {
            while (lock < 2) wait();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }

}

// method 5 semaphore
class FooBySemaphore {
    
    private Semaphore secondSemaphore = new Semaphore(0); // second 方法 0 个许可
    private Semaphore thirdSemaphore = new Semaphore(0); // third 方法 0 个许可
    
    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        secondSemaphore.release(); // 给 second 方法发 1 个许可
    }

    public void second(Runnable printSecond) throws InterruptedException {
        secondSemaphore.acquire(); // 消耗 1 个 second 许可才能往下执行
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        thirdSemaphore.release(); // 给 third 方法发 1 个许可
    }

    public void third(Runnable printThird) throws InterruptedException {
        thirdSemaphore.acquire(); // 消耗 1 个 third 许可才能往下执行
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

}

// method 6 lock
class FooByLock {
    
    private int flag = 0;
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            flag++;
            // 调用 signal() 会随机通知，此处如果通知到 t3 线程会死锁，所以全部通知
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try {
            while (flag != 1)
                condition.await();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            flag++;
            // 只剩 t3 线程需要通知，不用全部通知
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try {
            while (flag != 2)
                condition.await();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        } finally {
            lock.unlock();
        }
    }
}

// method 7 blocking queue
class FooByBlockingQueue {
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
        FooByBlockingQueue foo = new FooByBlockingQueue();
        // 三种不同的方式建立线程，推荐实现Runnable接口
        Runnable t1 = new Runnable() {
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
        };
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

package concurrency;

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
            notifyAll();
        }
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        while (lock < 1) wait();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        lock++;
        notifyAll();
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
    
    private Semaphore secondSemaphore = new Semaphore(0);
    private Semaphore thirdSemaphore = new Semaphore(0);
    
    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        secondSemaphore.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        secondSemaphore.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        thirdSemaphore.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        thirdSemaphore.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

}

// method 6 lock
class FooByLock {
    
    private int flag = 1;
    private ReentrantLock lock = new ReentrantLock();
    private Condition secondCondition = lock.newCondition();
    private Condition thirdCondition = lock.newCondition();

    public FooByLock() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            flag++;
            secondCondition.signal();
        } finally {
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try {
            while (flag != 2) {
                secondCondition.await();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            flag++;
            thirdCondition.signal();
        } finally {
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try {
            while (flag != 3) {
                thirdCondition.await();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        } finally {
            lock.unlock();
        }
    }
}

public class PrintInOrder {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        FooByLock foo = new FooByLock();
        // 三种不同的方式建立线程，推荐实现Runnable接口
        Runnable t1 = new Runnable() {
            public void run() {
                try {
                    TimeUnit.MILLISECONDS.sleep(2000);
                    foo.first(new Runnable() {
                        public void run() {
                            System.out.print("one");
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
                    System.out.print("two");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread t3 = new Thread(() -> {
            try {
                foo.third(() -> {
                    System.out.print("three");
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

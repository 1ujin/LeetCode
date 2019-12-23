package concurrency;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

// method 1 volatile 自旋锁
class FooBarByVolatile {
    private int n;
    private volatile boolean flag = true;
    
    public FooBarByVolatile(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            /*
             * 去掉Thread.yield的话，while循环是比较耗费性能的，可能会导致执行结果超时。
             * 可以通过Thread.yield进一步控制线程的执行，而非比较粗力度的循环。当某个线程调用yield()方法时，
             * 就会从运行状态转换到就绪状态后，CPU从就绪状态线程队列中只会选择与该线程优先级相同或者更高优先级的线程去执行。
             * 总之加上Thread.yield性能会更高一点，因此用时会更少。
             */
            while (!flag) Thread.yield();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            flag = false;
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            while (flag) {
                Thread.yield(); // 让步，减少空闲时间
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            flag = true;
        }
    }
}

// method 2 synchronized fastest
class FooBarBySynchronized {
    private int n;
    private boolean flag = false;

    public FooBarBySynchronized(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        synchronized (this) {
            for (int i = 0; i < n; i++) {
                while (flag) wait();
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                flag = true;
                notify();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        synchronized (this) {
            for (int i = 0; i < n; i++) {
                while (!flag) wait();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                flag = false;
                notify();
            }
        }
    }
}

// method 3 semaphore
class FooBarBySemaphore {
    private int n;
    private Semaphore fooSemaphore = new Semaphore(1);
    private Semaphore barSemaphore = new Semaphore(0);

    public FooBarBySemaphore(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            fooSemaphore.acquire(1);
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            barSemaphore.release(1);
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            barSemaphore.acquire(1);
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            fooSemaphore.release(1);
        }
    }
}

// method 4 cyclic barrier
class FooBarByCyclicBarrier {
    private int n;
    private static CyclicBarrier fooCyclicBarrier = new CyclicBarrier(2);
    private static CyclicBarrier barCyclicBarrier = new CyclicBarrier(2);    

    public FooBarByCyclicBarrier(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
            try {
                // 挂起两个foo之后执行
                fooCyclicBarrier.await();
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                barCyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
            try {
                // 挂起两个foo和两个bar之后执行
                fooCyclicBarrier.await();
                barCyclicBarrier.await();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}

// method 5 blocking queue
class FooBarByBlockingQueue {
    private int n;
    private BlockingQueue<Boolean> fooQueue = new ArrayBlockingQueue<>(1);
    private BlockingQueue<Boolean> barQueue = new ArrayBlockingQueue<>(1);

    public FooBarByBlockingQueue(int n) {
        this.n = n;
        try {
            fooQueue.put(true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            fooQueue.take();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            barQueue.put(true);
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            barQueue.take();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            fooQueue.put(true);
        }
    }
}

public class PrintFoobarAlternately {
    
    public static void main(String[] args) {
        FooBarByBlockingQueue fb = new FooBarByBlockingQueue(20);
        Random random = new Random(31);
        ExecutorService exec = Executors.newFixedThreadPool(2);
        Runnable r1 = () -> {
            try {
                fb.foo(() -> {
                    try {
                        TimeUnit.MILLISECONDS.sleep(random.nextInt(10) * 10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.print("foo");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable r2 = () -> {
            try {
                fb.bar(() -> {
                    try {
                        TimeUnit.MILLISECONDS.sleep(random.nextInt(10) * 10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("bar");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        exec.execute(r1);
        exec.execute(r2);
        exec.shutdown();
    }
}

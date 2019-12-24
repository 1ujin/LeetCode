package concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

//method 1 volatile 自旋锁
class ZeroEvenOddByVolatile {
    private int n;
    private volatile int flag = 1;
    
    public ZeroEvenOddByVolatile(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (flag != 1 && flag != 3) Thread.yield();
            printNumber.accept(0);
            flag++;
        }
    }
    
    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            while (flag != 4) Thread.yield();
            printNumber.accept(i);
            flag = 1;
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            while (flag != 2) Thread.yield();
            printNumber.accept(i);
            flag++;
        }
    }
}

// method 2 synchronized
class ZeroEvenOddBySynchronized {
    private int n;
    private int flag = 1;
    
    public ZeroEvenOddBySynchronized(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (this) {
                while (flag != 1 && flag != 3) wait();
                printNumber.accept(0);
                flag++;
                notifyAll();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        synchronized (this) {
            for (int i = 2; i <= n; i += 2) {
                while (flag != 4) wait();
                printNumber.accept(i);
                flag = 1;
                notifyAll();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        synchronized (this) {
            for (int i = 1; i <= n; i += 2) {
                while (flag != 2) wait();
                printNumber.accept(i);
                flag++;
                notifyAll();
            }
        }
    }
}

// method 3 semaphore
class ZeroEvenOddBySemaphore {
    private int n;
    Semaphore zeroSemaphore = new Semaphore(1);
    Semaphore evenSemaphore = new Semaphore(0);
    Semaphore oddSemaphore = new Semaphore(0);
    
    public ZeroEvenOddBySemaphore(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            zeroSemaphore.acquire();
            printNumber.accept(0);
            if (i % 2 == 0) oddSemaphore.release();
            else evenSemaphore.release();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            evenSemaphore.acquire();
            printNumber.accept(i);
            zeroSemaphore.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            oddSemaphore.acquire();
            printNumber.accept(i);
            zeroSemaphore.release();
        }
    }
}

// method 4 blocking queue
class ZeroEvenOddByBlockingQueue {
    private int n;
    private BlockingQueue<Integer> zeroQueue = new ArrayBlockingQueue<>(1);
    private BlockingQueue<Integer> evenQueue = new ArrayBlockingQueue<>(1);
    private BlockingQueue<Integer> oddQueue = new ArrayBlockingQueue<>(1);
    
    public ZeroEvenOddByBlockingQueue(int n) {
        this.n = n;
        try {
            zeroQueue.put(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            printNumber.accept(zeroQueue.take());
            if (i % 2 == 0) oddQueue.put(i + 1);
            else evenQueue.put(i + 1);
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            printNumber.accept(evenQueue.take());
            zeroQueue.put(0);
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            printNumber.accept(oddQueue.take());
            zeroQueue.put(0);
        }
    }
}

// method 5 lock
class ZeroEvenOddByLock {
    private int n;
    private int flag = 1;
    private ReentrantLock lock = new ReentrantLock();
    Condition zeroCondition = lock.newCondition();
    Condition evenCondition = lock.newCondition();
    Condition oddCondition = lock.newCondition();
    
    public ZeroEvenOddByLock(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            for (int i = 0; i < n; i++) {
                while (flag != 1 && flag != 3) zeroCondition.await();
                printNumber.accept(0);
                flag++;
                if (i % 2 == 0) oddCondition.signal();
                else evenCondition.signal();
            }
            oddCondition.signal();
            evenCondition.signal();
        } finally {
            lock.unlock();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            for (int i = 2; i <= n; i += 2) {
                while (flag != 4) evenCondition.await();
                printNumber.accept(i);
                flag = 1;
                zeroCondition.signal();
            }
            zeroCondition.signal();
        } finally {
            lock.unlock();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            for (int i = 1; i <= n; i += 2) {
                while (flag != 2) oddCondition.await();
                printNumber.accept(i);
                flag++;
                zeroCondition.signal();
            }
            zeroCondition.signal();
        } finally {
            lock.unlock();
        }
    }
}

public class PrintZeroEvenOdd {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(3);
        ZeroEvenOddByLock zeo = new ZeroEvenOddByLock(5);
        Runnable r1 = () -> {
            try {
                zeo.zero(i -> System.out.print(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable r2 = () -> {
            try {
                zeo.even(i -> System.out.print(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable r3 = () -> {
            try {
                zeo.odd(i -> System.out.print(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        exec.execute(r1);
        exec.execute(r2);
        exec.execute(r3);
        exec.shutdown();
    }

}

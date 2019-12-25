package concurrency;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

// method 1 cyclic barrier and semaphore 比较慢
class H2OByCyclicBarrier {
    
    private Semaphore hSemaphore = new Semaphore(2);
    private Semaphore oSemaphore = new Semaphore(1);
    private CyclicBarrier h2oBarrier = new CyclicBarrier(3, () -> {
        hSemaphore.release(2);
        oSemaphore.release(1);
    });
    
    public H2OByCyclicBarrier() {
        
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hSemaphore.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        try {
            h2oBarrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oSemaphore.acquire();
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        try {
            h2oBarrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

// method 2 semaphore
class H2OBySemaphore {
    
    private Semaphore hSemaphore = new Semaphore(2);
    private Semaphore oSemaphore = new Semaphore(1);
    
    public H2OBySemaphore() {
        
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hSemaphore.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        oSemaphore.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oSemaphore.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        hSemaphore.release(2);
    }
}

public class BuildingH2O {

    public static void main(String[] args) {
        String str = "OOOOOHOHHH";
        Random random = new Random(31);
        H2OBySemaphore h2o = new H2OBySemaphore();
        ExecutorService exec = Executors.newFixedThreadPool(2);
        Runnable h = () -> {
            try {
                for (char c : str.toCharArray()) {
                    TimeUnit.MILLISECONDS.sleep(random.nextInt(10) * 10);
                    if (c == 'H') h2o.hydrogen(() -> System.out.print(c));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable o = () -> {
            try {
                for (char c : str.toCharArray()) {
                    TimeUnit.MILLISECONDS.sleep(random.nextInt(10) * 10);
                    if (c == 'O') h2o.oxygen(() -> System.out.print(c));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        exec.execute(h);
        exec.execute(o);
        exec.shutdown();
    }

}

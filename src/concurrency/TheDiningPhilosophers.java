package concurrency;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class DiningPhilosophers {
    
    int num = 5;
    
    private ReentrantLock[] locks = new ReentrantLock[] {
            new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock()
    };
    
    private Semaphore eatLimit = new Semaphore(4);
    private Semaphore[] semaphores = new Semaphore[5];
    
    public DiningPhilosophers() {
        for (int i = 0; i < num; i++) {
            //每只叉子只有1个
            semaphores[i] = new Semaphore(1);
        }
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
            Runnable pickLeftFork,
            Runnable pickRightFork,
            Runnable eat,
            Runnable putLeftFork,
            Runnable putRightFork) throws InterruptedException {
        
//        int leftFork = (philosopher + 1) % 5; //左边的叉子 的编号
//        int rightFork = philosopher; //右边的叉子 的编号
//
//        eatLimit.acquire(); //限制的人数 -1
//
//        locks[leftFork].lock(); //拿起左边的叉子
//        locks[rightFork].lock(); //拿起右边的叉子
//
//        pickLeftFork.run(); //拿起左边的叉子 的具体执行
//        pickRightFork.run(); //拿起右边的叉子 的具体执行
//
//        eat.run();  //吃意大利面 的具体执行
//
//        putLeftFork.run(); //放下左边的叉子 的具体执行
//        putRightFork.run(); //放下右边的叉子 的具体执行
//
//        locks[leftFork].unlock(); //放下左边的叉子
//        locks[rightFork].unlock(); //放下右边的叉子
//
//        eatLimit.release(); //限制的人数 +1
        
//        int leftForkNumber = (philosopher + 4) % 5;
//        int rightForkNumber = philosopher;
//        if (philosopher == 4) {
//            locks[leftForkNumber].lock();
//            locks[rightForkNumber].lock();
//        } else {
//            locks[rightForkNumber].lock();
//            locks[leftForkNumber].lock();
//        }
//        pickLeftFork.run();
//        pickRightFork.run();
//        eat.run();
//        putLeftFork.run();
//        putRightFork.run();       
//        
//        locks[rightForkNumber].unlock();
//        locks[leftForkNumber].unlock();
        
        //左边叉子的位置
        int left = philosopher;
        //右边叉子的位置
        int right = (philosopher + 1) % num;
        while (true) {
            if (semaphores[left].tryAcquire()) {
                //先尝试获取左边叉子，如果成功再尝试获取右边叉子
                if (semaphores[right].tryAcquire()) {
                    //两个叉子都得到了，进餐
                    pickLeftFork.run();
                    pickRightFork.run();
                    eat.run();
                    putLeftFork.run();
                    //释放左边叉子
                    semaphores[left].release();
                    putRightFork.run();
                    //释放右边边叉子
                    semaphores[right].release();

                    //吃完了，就跳出循环
                    break;
                } else {
                    //如果拿到了左边的叉子，但没拿到右边的叉子： 就释放左边叉子
                    semaphores[left].release();
                    //让出cpu等一会
                    Thread.yield();
                }
            } else {
                //连左边叉子都没拿到，就让出cpu等会吧
                Thread.yield();
            }
        }
    }
}

public class TheDiningPhilosophers {

    public static void main(String[] args) {
        DiningPhilosophers dp = new DiningPhilosophers();
        Random random = new Random(31);
        Runnable pickLeftFork = () -> {
            try {
                TimeUnit.MILLISECONDS.sleep(random.nextInt(10) * 20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("[%d, 1, 1], ", Thread.currentThread().getId() - 11);
        };
        Runnable pickRightFork = () -> {
            try {
                TimeUnit.MILLISECONDS.sleep(random.nextInt(10) * 20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("[%d, 2, 1], ", Thread.currentThread().getId() - 11);
        };
        Runnable eat = () -> {
            try {
                TimeUnit.MILLISECONDS.sleep(random.nextInt(10) * 20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("[%d, 0, 3], ", Thread.currentThread().getId() - 11);
        };
        Runnable putLeftFork = () -> {
            try {
                TimeUnit.MILLISECONDS.sleep(random.nextInt(10) * 20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("[%d, 1, 2], ", Thread.currentThread().getId() - 11);
        };
        Runnable putRightFork = () -> {
            try {
                TimeUnit.MILLISECONDS.sleep(random.nextInt(10) * 20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("[%d, 2, 2], ", Thread.currentThread().getId() - 11);
        };
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int n = 0; n < 5; n++) {
            final int no = n;
            exec.execute(() -> {
                try {
                    for (int i = 0; i < 1; i++) dp.wantsToEat(no, pickLeftFork, pickRightFork, eat, putLeftFork, putRightFork);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        exec.shutdown();
    }

}

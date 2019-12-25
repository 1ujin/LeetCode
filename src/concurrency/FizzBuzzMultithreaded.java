package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.IntConsumer;

class FizzBuzz {
    private int n;
    private volatile int i = 1;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        synchronized (this) {            
            while (i <= n) {
                if (i % 3 == 0 && i % 5 != 0) {
                    printFizz.run();
                    i++;
                    notifyAll();
                } else wait();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        synchronized (this) {
            while (i <= n) {
                if (i % 5 == 0 && i % 3 != 0) {
                    printBuzz.run();
                    i++;
                    notifyAll();
                } else wait();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        synchronized (this) {
            while (i <= n) {
                if (i % 3 == 0 && i % 5 == 0) {
                    printFizzBuzz.run();
                    i++;
                    notifyAll();
                } else wait();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        synchronized (this) {
            while (i <= n) {
                if (i % 3 != 0 && i % 5 != 0) {
                    printNumber.accept(i);
                    i++;
                    notifyAll();
                } else wait();
            }
        }
    }
    
    public List<String> getList(Callable<List<String>> callable) {
        synchronized (this) {
            try {
                while (i < n + 1) wait();
                return callable.call();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    
    // overload
    public List<String> getList(List<String> list) {
        synchronized (this) {
            try {
                while (i < n + 1) wait();
                return list;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}

public class FizzBuzzMultithreaded {

    public static void main(String[] args) {
        FizzBuzz fb = new FizzBuzz(15);
        Random random = new Random(31);
        final List<String> list = new ArrayList<String>();
        final List<String> list1 = new ArrayList<String>();
        List<String> list2 = null;
        List<String> list3 = null;
        // 固定线程数量为4时，获取列表时不用等待就可以得到最后的结果，因为获取列表的线程call在其他4个线程之后执行
        // 固定线程数量大于5时？获取列表时必须循环等待至所有数字遍历完毕
        ExecutorService exec = Executors.newFixedThreadPool(4);
        Runnable fizz = () -> {
            try {
                fb.fizz(() -> {
                    try {
                        TimeUnit.MILLISECONDS.sleep(random.nextInt(10) * 10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    list.add("fizz");
                    list1.add("fizz");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable buzz = () -> {
            try {
                fb.buzz(() -> {
                    try {
                        TimeUnit.MILLISECONDS.sleep(random.nextInt(10) * 10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    list.add("buzz");
                    list1.add("buzz");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable fizzbuzz = () -> {
            try {
                fb.fizzbuzz(() -> {
                    try {
                        TimeUnit.MILLISECONDS.sleep(random.nextInt(10) * 10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    list.add("fizzbuzz");
                    list1.add("fizzbuzz");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable number = () -> {
            try {
                fb.number(n -> {
                    try {
                        TimeUnit.MILLISECONDS.sleep(random.nextInt(10) * 10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    list.add(Integer.toString(n));
                    list1.add(Integer.toString(n));
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Callable<List<String>> call = () -> {
            return fb.getList(() -> {
                return list;
            });
        };
        Callable<List<String>> overloadCall = () -> {
            return fb.getList(list1);
        };
        exec.execute(fizz);
        exec.execute(buzz);
        exec.execute(fizzbuzz);
        exec.execute(number);
        try {
            list3 = exec.submit(overloadCall).get();
            list2 = exec.submit(call).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        exec.shutdown();
        System.out.println(list2);
        System.out.println(list3);
    }

}

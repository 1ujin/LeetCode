package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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
        try {
            return callable.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<String> getList(List<String> list) {
        return list;
    }
}

public class FizzBuzzMultithreaded {

    public static void main(String[] args) {
        FizzBuzz fb = new FizzBuzz(15);
        final List<String> list = new ArrayList<String>();
        ExecutorService exec = Executors.newFixedThreadPool(4);
        Runnable fizz = () -> {
            try {
                fb.fizz(() -> list.add("fizz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }  
        };
        Runnable buzz = () -> {
            try {
                fb.buzz(() -> list.add("buzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }  
        };
        Runnable fizzbuzz = () -> {
            try {
                fb.fizzbuzz(() -> list.add("fizzbuzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }  
        };
        Runnable number = () -> {
            try {
                fb.number(n -> list.add(Integer.toString(n)));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }  
        };
        Callable<List<String>> call = () -> {
            return fb.getList(() -> {
                return list;
            });
        };
        exec.execute(fizz);
        exec.execute(buzz);
        exec.execute(fizzbuzz);
        exec.execute(number);
        try {
            System.out.print(exec.submit(call).get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        exec.shutdown();
    }

}

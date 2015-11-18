package stingion.train;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by joe on 19.11.15.
 */
public class Exch implements Runnable {

    private Exchanger<Long> exchanger;
    private int number;

    public Exch(Exchanger<Long> exchanger, int number) {
        this.exchanger = exchanger;
        this.number = number;
    }

    @Override
    public void run() {
        long sum = 0;
        for (int i = 0; i <= number; i++) {
            sum += i;
        }
        try {
            System.out.println(Thread.currentThread().getId() + " before exchanging: " + sum);
            System.out.println(Thread.currentThread().getId() + " after exchanging: " + exchanger.exchange(sum));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Exchanger<Long> exchanger = new Exchanger<>();
        ExecutorService es = Executors.newCachedThreadPool();
        es.execute(new Exch(exchanger, 3));
        es.execute(new Exch(exchanger, 20));
        es.shutdown();
    }
}

package stingion.train;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by joe on 19.11.15.
 */
public class Twix {
    public static void main(String[] args) throws InterruptedException {
        Semaphore s = new Semaphore(2);
        ExecutorService es = Executors.newCachedThreadPool();
        es.execute(new Acq(s));
        es.execute(new Acq(s));
        es.execute(new Acq(s));
        es.execute(new Acq(s));
        es.execute(new Acq(s));
        es.execute(new Acq(s));
        es.execute(new Acq(s));

        Thread.sleep(1000);
        es.execute(new Rel(s));
        es.execute(new Rel(s));
        Thread.sleep(3000);
        es.shutdownNow();
    }
}

class Acq implements Runnable {
    private Semaphore s;

    public Acq(Semaphore s) {
        this.s = s;
    }

    @Override
    public void run() {
        System.out.println("acquire " + Thread.currentThread().getId());
        try {
            s.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("released acq " + Thread.currentThread().getId());
    }
}

class Rel implements Runnable {
    private Semaphore s;

    public Rel(Semaphore s) {
        this.s = s;
    }

    @Override
    public void run() {
        System.out.println("released");
        s.release();
    }
}

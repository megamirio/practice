package stingion.train;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by joe on 19.11.15.
 */
public class CyclicBarrierNext {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cb = new CyclicBarrier(3, new Run());
        ExecutorService es = Executors.newCachedThreadPool();
        es.execute(new Okey(cb));
        es.execute(new Okey(cb));
        es.execute(new Okey(cb));
        Thread.sleep(3000);
        System.out.println("exit");
        es.shutdownNow();
    }
}

class Okey implements Runnable{
    private CyclicBarrier cb;

    public Okey(CyclicBarrier cb) {
        this.cb = cb;
    }

    @Override
    public void run() {
        try {
            cb.await();
            System.out.println(Thread.currentThread().getId() + " released");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

class Run implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(1500);
            System.out.println("Okey now");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
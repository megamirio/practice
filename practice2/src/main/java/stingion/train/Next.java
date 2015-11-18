package stingion.train;

import lombok.AllArgsConstructor;
import lombok.Setter;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by joe on 19.11.15.
 */
public class Next {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(2);
        System.out.println("start cdl: " + cdl.getCount());
        ExecutorService es = Executors.newCachedThreadPool();
        es.execute(new AwaitDown(cdl));
        es.execute(new AwaitDown(cdl));
        es.execute(new AwaitDown(cdl));
        Thread.sleep(1500);
        es.execute(new CountDown(cdl));
        Thread.sleep(1500);
        es.execute(new CountDown(cdl));
        es.shutdownNow();
    }
}

@AllArgsConstructor
class CountDown implements Runnable {

    private CountDownLatch cdl;

    @Override
    public void run() {
        cdl.countDown();
        System.out.println(cdl.getCount());
    }
}

@AllArgsConstructor
class AwaitDown implements Runnable {

    private CountDownLatch cdl;

    @Override
    public void run() {
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getId() + " released");
    }
}

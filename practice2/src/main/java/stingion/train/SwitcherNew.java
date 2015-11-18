package stingion.train;

import lombok.AllArgsConstructor;
import lombok.Setter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by joe on 19.11.15.
 */
@AllArgsConstructor
public class SwitcherNew implements Runnable {

    private LampNew lamp;

    @Override
    public void run() {
        try {
            do {
                AtomicInteger ai =new AtomicInteger(2);
                lamp.switching();
            } while (true);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(2);
        LampNew lamp = new LampNew();
        lamp.setSleepTime(500);

        es.execute(new SwitcherNew(lamp));
        es.execute(new SwitcherNew(lamp));
        Thread.sleep(5000);
        es.shutdownNow();
    }
}

class LampNew {
    @Setter
    private int sleepTime;

    private boolean isOn;

    public synchronized void switching() throws InterruptedException {
        isOn = !isOn;
        System.out.println(isOn ? "ON" : "OFF");
        Thread.sleep(sleepTime);
        notify();
        wait();
    }
}
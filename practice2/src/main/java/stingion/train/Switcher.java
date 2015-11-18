package stingion.train;

import jdk.nashorn.internal.objects.annotations.Getter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by joe on 18.11.15.
 */

class Lamp {

    private boolean isOn = false;

    public synchronized void on() throws InterruptedException {
        isOn = true;
        threadCommunication();
    }

    public synchronized void off() throws InterruptedException {
        isOn = false;
        threadCommunication();
    }

    private void threadCommunication() throws InterruptedException {
        System.out.println(isOn ? "ON" : "OFF");
        Thread.sleep(500);
        notify();
        wait();
    }
}

enum SwitcherType {
    TurnOn, TurnOff
}

public class Switcher implements Runnable {

    private Lamp lamp;
    private final boolean type;

    public Switcher(Lamp lamp, SwitcherType type) {
        this.lamp = lamp;
        this.type = type == SwitcherType.TurnOn ? true : false;
    }

    private void turn() {
        try {
            do {
                if (type)
                    lamp.on();
                else
                    lamp.off();
            } while (true);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void run() {
        turn();
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();
        Lamp lamp = new Lamp();
        Switcher on = new Switcher(lamp, SwitcherType.TurnOn);
        Switcher off = new Switcher(lamp, SwitcherType.TurnOff);

        es.execute(on);
        es.execute(off);

        Thread.sleep(5000);
        es.shutdownNow();
    }
}

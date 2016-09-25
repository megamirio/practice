package stingion.now.temp.lampswitchernew;

import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Lamp {
    @Getter
    @Setter
    private boolean isOn;

    public synchronized void switching(boolean isOn) throws InterruptedException {
        this.isOn = isOn;
        System.out.println(isOn);
        Thread.sleep(1000);
        notify();
        wait();
    }

}

public class LampSwitcherNew implements Runnable {
    private Lamp lamp;
    private boolean isOn;

    public LampSwitcherNew(Lamp lamp, boolean isOn) {
        this.lamp = lamp;
        this.isOn = isOn;
    }

    @Override
    public void run() {
        try {
            do {
                lamp.switching(isOn);
            } while (true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Okey {
    public static void main(String[] args) throws InterruptedException {
        Lamp lamp = new Lamp();

        ExecutorService es = Executors.newFixedThreadPool(2);
        es.execute(new LampSwitcherNew(lamp, true));

        do {
            if (lamp.isOn()) {
                es.execute(new LampSwitcherNew(lamp, false));
                break;
            }
        } while (true);

        Thread.sleep(5000);
        es.shutdownNow();
    }
}
package stingion.now.temp;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Lamp {
    @Getter
    @Setter
    private boolean isOn;

    public synchronized void switching() throws InterruptedException {
        isOn = !isOn;
        System.out.println(isOn);
        Thread.sleep(1000);
        notify();
        wait();
    }

}

class LampSwitcher implements Runnable {
    private Lamp lamp;
    private boolean isSwitcherOn;

    public LampSwitcher(Lamp lamp, boolean isSwitcherOn) {
        this.lamp = lamp;
        this.isSwitcherOn = isSwitcherOn;
    }

    @Override
    public void run() {
        try {
            do {
                if (isSwitcherOn && !lamp.isOn()) {
                    lamp.switching();
                } else if (!isSwitcherOn && lamp.isOn()) {
                    lamp.switching();
                }
            } while (true);
        } catch (InterruptedException ex) {
            System.out.println("End!");
        }
    }
}

public class LampSwitcherApp {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start");
        Lamp lamp = new Lamp();
        ExecutorService es = Executors.newCachedThreadPool();

        es.execute(new LampSwitcher(lamp, false));
        es.execute(new LampSwitcher(lamp, true));
        Thread.sleep(5000);
        es.shutdownNow();
    }
}

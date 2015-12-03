package stingion.train;

import lombok.Getter;

import java.util.Random;

/**
 * Created by joe on 30.11.15.
 */
public class CommaSeparated {
    public static void main(String[] args) throws InterruptedException {
        CommaSep cs = new CommaSep(1000000);
        long start = System.nanoTime();
        cs.buildString();
        long end = System.nanoTime();
        System.out.println("length = " + cs.getSb().length() + " " + "dur = " + (end - start));
        System.out.println("------------------------");

        int amount = 5;
        CommaSepThread[] cses = new CommaSepThread[amount];
        Thread[] tes = new Thread[amount];

        for (int i = 0; i < amount; i++) {
            cses[i] = new CommaSepThread(1000000 / amount);
            tes[i] = new Thread(cses[i]);
        }

        long start2 = System.nanoTime();

        for (int i = 0; i < amount; i++) {
            tes[i].start();
            tes[i].join();
        }

        long end2 = System.nanoTime();
        System.out.println("length1 = " + cses[0].getSb().length() + " " + "dur1 = " + (end2 - start2));
    }
}

class CommaSep {
    @Getter
    private StringBuilder sb = new StringBuilder();
    private static final Random rand = new Random();
    private int numAmount;

    public CommaSep(int numAmount) {
        this.numAmount = numAmount;
    }

    public void buildString() {
        for (int i = 0; i < numAmount; i++) {
            sb.append(rand.nextInt());
        }
    }
}

class CommaSepThread implements Runnable {
    private static final Random rand = new Random();
    @Getter
    private StringBuilder sb = new StringBuilder();
    private int numAmount;

    public CommaSepThread(int numAmount) {
        this.numAmount = numAmount;
    }

    @Override
    public void run() {
        for (int i = 0; i < numAmount; i++) {
            sb.append(rand.nextInt());
        }
    }
}

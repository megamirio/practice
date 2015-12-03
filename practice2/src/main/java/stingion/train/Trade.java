package stingion.train;

import lombok.AllArgsConstructor;

/**
 * Created by joe on 03.12.15.
 */
public class Trade {
    public static void main(String[] args) throws InterruptedException {
        Ob ob = new Ob();
        new Thread(new Tre1(ob)).start();
        new Thread(new Tre2(ob)).start();
        ;
        System.out.println("okey");
        Thread.sleep(500);
        new Thread(new Tre3(ob)).start();
        ;
    }
}

class Ob {
    public synchronized void meth1() {
        try {
            wait();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("meth1");
    }

    public synchronized void meth2() {
        try {
            wait();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("meth2");
    }

    public synchronized void meth3() {
        System.out.printf("ss");
        notifyAll();
    }
}

@AllArgsConstructor
class Tre1 implements Runnable {
    private Ob ob;

    @Override
    public void run() {
        ob.meth1();
    }
}

@AllArgsConstructor
class Tre2 implements Runnable {
    private Ob ob;

    @Override
    public void run() {
        ob.meth2();
    }
}

@AllArgsConstructor
class Tre3 implements Runnable {
    private Ob ob;

    @Override
    public void run() {
        ob.meth3();
    }
}

package stingion.train;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by joe on 03.12.15.
 */
public class Tommy {
    static class Obj {
        private Lock lock = new ReentrantLock();

        public void meth() {
            if(lock.tryLock()) {
                System.out.println(Thread.currentThread().getId() + " Okey go!");
//            lock.unlock();
//            methU();
                try {
                    Thread.sleep(1000);
                    System.out.println("unlocked");
                    lock.unlock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void methU() {
            System.out.println("Will unlock");
            try {
                Thread.sleep(1000);
                System.out.println("unlocked");
                lock.unlock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class R1 implements Runnable {

        private Obj obj;

        public R1(Obj obj) {
            this.obj = obj;
        }

        @Override
        public void run() {
            obj.meth();
        }
    }

    static class R2 implements Runnable {

        private Obj obj;

        public R2(Obj obj) {
            this.obj = obj;
        }

        @Override
        public void run() {
            obj.methU();
        }
    }

    public static void main(String[] args) {
        System.out.println("okey");
        Obj obj = new Obj();
//        new Thread(new R1(obj)).start();
        Thread t =new Thread(new R1(obj));
        t.start();
        t.interrupt();
//        new Thread(new R2(obj)).start();
    }
}

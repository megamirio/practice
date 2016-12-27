package practice3.skywind.good;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by royalflush on 13.12.16.
 */

class ThreadOne implements Callable<Integer> {
    private ConcurrentLinkedQueue cunQueue;
    private ConcurrentLinkedQueue queueOne;

    public ThreadOne(ConcurrentLinkedQueue cunQueue, ConcurrentLinkedQueue queueOne) {
        this.cunQueue = cunQueue;
        this.queueOne = queueOne;
    }

    @Override
    public Integer call() {
        Object obj;
        while ((obj = cunQueue.poll()) != null) {
            queueOne.add(new Random().nextInt());
        }

        return new Random().nextInt();
    }
}

public class Threader {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        System.out.println(Thread.currentThread().getName());
//        List list = new LinkedList();
//
//        for (int i = 0; i < 5000000; i++) {
//            list.add(new Object());
//        }
//
//        List<Future<Integer>> futureslist = new ArrayList<>();
//
//        ConcurrentLinkedQueue<Object> queue = new ConcurrentLinkedQueue<>(list);
//
//        ConcurrentLinkedQueue<Integer> queueOne = new ConcurrentLinkedQueue<>();
//
//        int amount = 10;
//        ExecutorService executor = Executors.newFixedThreadPool(amount);
//
//        long b = System.nanoTime();
//        for (int i = 0; i < amount; i++) {
//            futureslist.add(executor.submit(new ThreadOne(queue, queueOne)));
//        }
//
//        executor.shutdown();
//
//        for (Future<Integer> future : futureslist) {
//            future.get();
//        }
//        long e = System.nanoTime();
//        long r = e - b;
//        System.out.println(((double) r) / 1000000000);
//        System.out.println(queueOne.size());

        List list2 = null;// = new ArrayList();
        //list2.add("one");

        for(Object o:list2){

        }
    }
}

/*
 * Created under not commercial project
 */
package stingion.newek.integration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.annotation.Gateway;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Give implements Runnable {

    private StrUpCaseGateway gateway;

    public Give(StrUpCaseGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1; i++) {
            gateway.send(UUID.randomUUID().toString() + "i");
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        System.out.println("end");
    }
}

class Take implements Runnable {

    private StrUpCaseGateway gateway;

    public Take(StrUpCaseGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("start>>>");
            String out = gateway.receive();
            System.out.println(out);
            if (out == null) {
                break;
            }
            System.out.println("last");
        }
        System.out.println("end now");
    }
}

class One implements Runnable{
    @Override
    public void run() {
        System.out.println("go");
    }
}

public class StrUpCase2 {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("classpath*:stingion/practice2/spring-integration.xml");
        StrUpCaseGateway gateway = context.getBean("gateway", StrUpCaseGateway.class);
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(new Give(gateway));
//        Thread tGive = new Thread(new Give(gateway));
      executor.execute(new Take(gateway));
//        tGive.start();
//        tTake.start();
        Thread.sleep(2000);
        System.out.println("one>>>");
//        tGive.stop();
//        tTake.stop();

//        ((ClassPathXmlApplicationContext)context).close();

//        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(new One());
        executor.shutdown();
    }
}

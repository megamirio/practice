package stingion.event4er;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by royalflush on 30.12.16.
 */
public class Starter {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-context.xml");
        MyEventPublisher publisher = context.getBean(MyEventPublisher.class);
        publisher.publish();
        publisher.publish();
        publisher.publish();
    }
}

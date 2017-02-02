package stingion.event4er.blacklist;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import stingion.event4er.MyEventPublisher;

/**
 * Created by royalflush on 03.01.17.
 */
public class Example {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-context.xml");
        EmailService emailService = context.getBean(EmailService.class);
        emailService.sendEmail("okey@gamil.com", "some text");
        emailService.sendEmail("email1@gamil.com", "some text");
        emailService.sendEmail("email3@gamil.com", "some text");
    }
}

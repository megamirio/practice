package stingion.spring.el;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ievgen on 9/22/14 6:15 PM.
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context/spring-el.xml");

        Customer obj = (Customer) context.getBean("customerBean");
        System.out.println(obj);

        obj = (Customer) context.getBean("customerBean2");
        System.out.println(obj);
    }
}

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
        System.out.println("-------------------");
        Oxy oxy = context.getBean("oxy", Oxy.class);
        InOxy inOxy = oxy.getInOxy();

        System.out.println(oxy);
        System.out.println(inOxy);

        oxy = context.getBean("oxy", Oxy.class);
        inOxy = oxy.getInOxy();

        System.out.println(oxy);
        System.out.println(inOxy);
    }
}

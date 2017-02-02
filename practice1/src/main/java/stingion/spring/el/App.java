package stingion.spring.el;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ievgen on 9/22/14 6:15 PM.
 */
public class App {
    private static Logger log = LoggerFactory.getLogger(App.class);
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context/spring-el.xml");

//        Customer obj = (Customer) context.getBean("customerBean");
//        System.out.println(obj);
//
//        obj = (Customer) context.getBean("customerBean2");
//        System.out.println(obj);
//        System.out.println("-------------------");
//        Oxy oxy = context.getBean("oxy", Oxy.class);
//        InOxy inOxy = oxy.getInOxy();
//
//        System.out.println(oxy);
//        System.out.println(inOxy);
//
//        oxy = context.getBean("oxy", Oxy.class);
//        inOxy = oxy.getInOxy();
//
//        System.out.println(oxy);
//        System.out.println(inOxy);
        Itis itis = context.getBean("itis", Itis.class);
        itis.inter(11);
        ((ClassPathXmlApplicationContext) context).close();
        log.info("okey '{}' now ~{}~ is", 22, 888);
        log.trace("I'm trace");
        log.debug("I'm debug");
    }
}

class Itis {
    public Integer inter(int a) {
        int a1 = 22 / a;
        return 55;
    }

    public Integer inter() {
        int a1 = 22 / 10;
        return 55;
    }
}

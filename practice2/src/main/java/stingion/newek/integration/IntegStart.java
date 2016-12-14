package stingion.newek.integration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import stingion.newek.Good;

/**
 * Created by ievgen on 8/5/14 5:57 PM.
 */
public class Integ {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:stingion/practice2/spring-integration.xml");

        String one = context.getBean("one", String.class);
        System.out.println(one);
    }
}

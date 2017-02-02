package stingion.validation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by royalflush on 05.01.17.
 */
public class PersonStart {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-context.xml");
        Person person = context.getBean("person", Person.class);
        System.out.println(person);
    }
}

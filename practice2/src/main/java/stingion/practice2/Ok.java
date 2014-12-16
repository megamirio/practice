package stingion.practice2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ievgen on 8/5/14 5:57 PM.
 */
public class Ok {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:stingion/practice2/spring-context5.xml");

        SayWord sayWord = (SayWord) context.getBean("sayWord");
        System.out.println(sayWord.says());
    }
}

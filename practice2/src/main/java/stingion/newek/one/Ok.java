package stingion.newek.one;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import stingion.newek.Good;
import stingion.newek.two.Temp;
import stingion.practice2.SayWord;

/**
 * Created by ievgen on 8/5/14 5:57 PM.
 */
public class Ok {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:stingion/practice2/spring-context5.xml");

//        System.out.println(context.getBean("tempo", String.class));
//        System.out.println(context.getBean("abc", String.class));
//        System.out.println(context.getBean("abc222", String.class));

        Good good = context.getBean("good", Good.class);
        System.out.println(good.getIn());
        Good good2 = context.getBean("good", Good.class);
        System.out.println(good2.getIn());
        System.out.println(good.getInGood());
        System.out.println(good.getInGood());
        System.out.println(good.getInGood());
    }
}

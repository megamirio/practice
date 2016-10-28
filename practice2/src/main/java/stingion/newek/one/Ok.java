package stingion.newek.one;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import stingion.newek.two.Temp;
import stingion.practice2.SayWord;

/**
 * Created by ievgen on 8/5/14 5:57 PM.
 */
public class Ok {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:stingion/practice2/spring-context6.xml",
                "classpath*:stingion/practice2/spring-context5.xml");
        Abc abc = context.getBean("abcAlias", Abc.class);
        Temp temp = context.getBean("tempo2", Temp.class);

        System.out.println(temp);
        System.out.println(temp.getAbc());
    }
}

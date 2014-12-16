package stingion.spring.integration.in2;

/**
 * Created by ievgen on 8/6/14 9:16 PM.
 */
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PollerApp {

    public static void main(String[] args) throws Exception{
        new ClassPathXmlApplicationContext("spring-context/delay.xml");
    }

}

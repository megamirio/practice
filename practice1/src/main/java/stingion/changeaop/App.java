package stingion.changeaop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("changeaop.xml");
        One one = context.getBean("one", One.class);
        Object objIn = new Object();
        Object objOut = one.obj(objIn);
        System.out.println(objIn);
        System.out.println(objOut);
        ((ClassPathXmlApplicationContext) context).close();
    }
}

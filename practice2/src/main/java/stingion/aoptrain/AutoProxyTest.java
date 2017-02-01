package stingion.aoptrain;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by royalflush on 01.02.17.
 */
public class AutoProxyTest {
    public static void main(String[] args) {
        String[] paths = {"stingion/practice2/applicationContext.xml"};
        ApplicationContext ctx = new ClassPathXmlApplicationContext(paths);
        Cat tiger = (Cat) ctx.getBean("tiger");
        tiger.hasHotBlood();
        Bird albatross = (Bird) ctx.getBean("albatross");
        albatross.hasBeak();
    }
}

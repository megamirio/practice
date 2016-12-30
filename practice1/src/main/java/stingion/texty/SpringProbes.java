package stingion.texty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by royalflush on 27.12.16.
 */
public class SpringProbes {
    public static void main(String[] args) {
//        AbstractApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
//        context.getEnvironment().setActiveProfiles("two");
//        System.out.println(context.getBean("word"));
//        System.out.println(context.getBean("taddyBear", TaddyBear.class).getBulka());
        // setting an active profile
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.getEnvironment().setActiveProfiles("two");
        ctx.load("spring-context.xml");
        ctx.refresh();
        System.out.println(ctx.getBean("bulka", String.class));
        System.out.println(ctx.getBean("taddyBear", TaddyBear.class));
        ctx.close();

        ctx = new GenericXmlApplicationContext();
//        ctx.getEnvironment().setActiveProfiles("one");
        ctx.load("spring-context.xml");
        ctx.refresh();
        System.out.println(ctx.getBean("bulka", String.class));
        ctx.close();

        ctx = new GenericXmlApplicationContext();
        ctx.getEnvironment().setActiveProfiles("production");
        ctx.load("*-config.xml");
        ctx.refresh();
        print(ctx);
        ctx.close();

        // using the default active profile
        ctx = new GenericXmlApplicationContext();
        ctx.load("*-config.xml");
        ctx.getEnvironment().setActiveProfiles("default");
        ctx.refresh();
        print(ctx);
//        ctx.close();

        System.out.println(ctx.getEnvironment().getSystemProperties());
        System.out.println(ctx.getEnvironment().getProperty("java.library.path"));
    }

    private static void print(ApplicationContext ctx) {
        String welcome = ctx.getBean("profile", String.class);
        System.out.println("Active profile: " + welcome);
    }
}

@Getter
@Setter
//@Profile("two")
@Component
@ToString
class TaddyBear {
    @Autowired
    @Qualifier("bulka")
    private String bulka;
}
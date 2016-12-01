package stingion.practice2;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ievgen on 8/5/14 5:57 PM.
 */
class OneLookUp {
    public void out() {
        System.out.println(d());
    }

    @Lookup("two")
    public Double d() {
        return null;
    }
}

@Getter
@Setter
class Quick {

    @Autowired
    private OneLookUp f;

    @Lookup
    public OneLookUp l() {
        return null;
    }
}

public class Ok {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("classpath*:stingion/practice2/spring-context5.xml");

        SayWord sayWord = (SayWord) context.getBean("sayWord");
        System.out.println(sayWord.says());

        OneLookUp one = context.getBean("olu", OneLookUp.class);
        System.out.println(one.d());

//        Quick q = context.getBean("q", Quick.class);
//        System.out.println(q);
//
//        Quick q2 = context.getBean("q", Quick.class);
//        System.out.println(q2);
//
//        System.out.println(q.getD() == q2.getD());

        Quick q = context.getBean("q", Quick.class);
        System.out.println(q.getF());

        Quick q2 = context.getBean("q", Quick.class);
        System.out.println(q2.getF());

        System.out.println(q.toString());
        System.out.println(q2
                .toString());
        System.out.println(q.l().toString());
        System.out.println(q2.l().toString());
    }
}

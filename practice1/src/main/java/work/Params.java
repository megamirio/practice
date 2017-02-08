package work;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by royalflush on 07.02.17.
 */
public class Params {
    private static final String[] PARSED_PARAMS = {"message", "error"};

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println(context.getBean("str1", String.class));

        Map<String, String> map = new HashMap<>();
        map.put("one", "okey go");
        map.put("Error", "error It's bad one");
        map.put("message", "message Good is");
        map.put("new one", "set it");

//        Object obj = Arrays.stream(PARSED_PARAMS)
//                .collect(Collectors.toMap(p -> p, p -> map.entrySet().stream().filter(e-> e.getKey().equalsIgnoreCase(p)). ));
//                .map(p -> map.entrySet().stream().filter(e -> e.getKey().equalsIgnoreCase(p)))
//                .collect(Lists.);

        Object obj = map.entrySet().stream().filter(e -> Arrays.stream(PARSED_PARAMS).anyMatch(a -> e.getKey().equalsIgnoreCase(a)))
                .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));

        System.out.println(obj);
    }
}

package practice3.java8now;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class Obj {
    public Object get(Object o) {
        if (o instanceof String) {
            return new Integer(3);
        }
        return new ArrayList<>();
    }
}

public class NextUp {
    public static void main(String[] args) {
        System.out.println("Next up");
        Function<Obj, Boolean> func = a -> (a.get(55) instanceof Number);
        System.out.println(func.apply(new Obj()));
        Map map = new HashMap<>();
        map.put(33, "sd");
        map.put(313, "1sd");
        map.put(313d, 2);
        map.merge(3311, "ABC", (value, newValue) -> ((String) value).concat((String) newValue));
        System.out.println(map);

        System.out.println(map.computeIfPresent(33111, (k, v) -> k + " " + v));

        List<String> list = Lists.newArrayList("sdfs", "s", "aasdf", "233sd");
        System.out.println(list.stream().sorted().collect(Collectors.toList()));
        System.out.println(list);
    }
}

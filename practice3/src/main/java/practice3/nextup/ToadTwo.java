package practice3.nextup;

import java.time.Clock;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by joe on 29.04.16.
 */
public class ToadTwo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("525");
        list.add("2222");
        list.add("33");
        Stream<String> stream = list.stream();
        System.out.println(list);
//        System.out.println(stream.collect(Collectors.toList()));

//        list.stream().filter(a -> a.length() < 4).sorted().map(Integer::valueOf);//.forEach(s -> System.out.println(s.getClass()));
//        System.out.println(stream.anyMatch(s -> s.equals("2222")));
//        System.out.println(stream.anyMatch(s -> s.equals("2222")));
        System.out.println(list.stream().filter(a -> a.length() < 4).sorted().map(Integer::valueOf).reduce((a1, a2) -> a1 + a2).get());
        Map<Integer, String> map = new HashMap<>();
        map.put(5, "abc");
        map.put(15, "1abc");
        map.put(-15, "ab1abc");
        map.put(115, "bc");
        map.computeIfPresent(15, (k, v) -> k + "#" + v);
        map.computeIfAbsent(151, k -> "#" + k);
        System.out.println(map);
        System.out.println(map.getOrDefault(42, "not found"));
        Clock clock = Clock.systemDefaultZone();
        System.out.println(clock);
        System.out.println(LocalTime.now(ZoneId.of("Europe/Kiev")));
    }
}

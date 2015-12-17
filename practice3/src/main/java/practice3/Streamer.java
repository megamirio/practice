package practice3;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by joe on 15.12.15.
 */
public class Streamer {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 3, -5, 555, 23, 5, 2);
        List<Integer> listNew = list.stream().limit(list.size()).filter(num -> num != 3).collect(Collectors.toList());
        System.out.println(list);
        System.out.println(listNew);
        listNew.stream()
                .sorted(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1 < o2 ? -1 : (o1 > o2 ? 1 : 0);
                    }
                }).forEach(System.out::println);
        System.out.println("-------------");
        listNew.stream().map(i -> i * i % 2).distinct().collect(Collectors.toList()).forEach(System.out::println);
        IntSummaryStatistics stats = list.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println(stats.getMin());
    }
}

package practice3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by joe on 17.12.15.
 */
public class SteamerNext {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> nums = random.ints(-2, 3).limit(17).boxed().collect(Collectors.toList());
        nums.stream().forEach(System.out::print);
        System.out.println("\n=========================");
        List<Integer> numsNotModTwo = nums.stream().filter(num -> num != 0 && num != -2 && num != 2).collect(Collectors.toList());
        numsNotModTwo.stream().sorted().forEach(System.out::print);
        System.out.println("\n=========================");
//        numsNotModTwo.stream().unordered().forEach(System.out::print);
        List<Integer> numsSorted = numsNotModTwo.stream().sorted().collect(Collectors.toList());
        System.out.println(numsSorted);
        System.out.println(numsSorted.stream().unordered().collect(Collectors.toList()));
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        strings.stream().filter(string -> !string.isEmpty()).forEach(System.out::println);
        System.out.println(numsSorted);
        strings.parallelStream().filter(string -> !string.isEmpty()).forEach(System.out::println);
        System.out.println(numsSorted);
        strings.stream().filter(string -> !string.isEmpty()).forEach(System.out::println);

        System.out.println("\n=========================");
        Integer value1 = null;
        Integer value2 = new Integer(10);

        //Optional.ofNullable - allows passed parameter to be null.
        Optional<Integer> a = Optional.ofNullable(value1);

        //Optional.of - throws NullPointerException if passed parameter is null
        Optional<Integer> b = Optional.of(value2);
        System.out.println(sum(a, b));
        System.out.println("************************");
        strings.stream().forEach(e -> System.out.println("This is good: " + e));
    }

    public static Integer sum(Optional<Integer> a, Optional<Integer> b) {

        //Optional.isPresent - checks the value is present or not

        System.out.println("First parameter is present: " + a.isPresent());
        System.out.println("Second parameter is present: " + b.isPresent());

        //Optional.orElse - returns the value if present otherwise returns
        //the default value passed.
        Integer value1 = a.orElse(new Integer(0));

        //Optional.get - gets the value, value should be present
        Integer value2 = b.get();
        return value1 + value2;
    }
}

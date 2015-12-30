package practice3;

import java.util.Arrays;
import java.util.List;

/**
 * Created by joe on 28.12.15.
 */
public class StreamGo {
    public static void main(String[] args) {
        System.out.println("Okey go!");
        List<String> list = Arrays.asList("abc", "ost", "abbb", "abec", "abcc dd", "ab cc3c", "");
//        int str =
        list.stream().filter(s -> s.startsWith("a") && s.endsWith("c")).map(s -> "!" + s + "!").forEach(System.out::println);
//                .reduce(0, (s, p) -> s += p.length(), (s1, s2) -> s1 + s2);
//        System.out.println(str);
        Converter<Integer, String> converter = (argument) -> Integer.valueOf(argument);
        System.out.println(converter.convert("234"));
        converter.getHello();
        converter.getHi();
    }

    @FunctionalInterface
    interface Converter<R, A>{
        R convert(A argument);

        default void getHello(){
            System.out.println("Hello");
        }

        default void getHi(){
            System.out.println("Hi");
        }
    }
}

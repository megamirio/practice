package practice3.java8;

@FunctionalInterface
interface First<T> {

    T okey4(T t);

    boolean equals(Object obj);

    default void okey() {
        System.out.println("Print OKEY");
    }

    default void okey2() {
        System.out.println("Print OKEY");
    }
}

public class Probes {
    public static void main(String[] args) {
        First<Integer> first = (a) ->  25 * 2;
        System.out.println(first.okey4(5));
    }
}

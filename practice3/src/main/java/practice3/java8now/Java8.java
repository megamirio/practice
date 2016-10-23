package practice3.java8now;

import lombok.ToString;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;

interface Formula {
    double calculate(int i);

    default double div10(int i) {
        return i / 10d;
    }
}

interface Func<A, F> {
    F func(A v);
}

@ToString
class AClass {
    Integer i;
    Double d;

    public AClass() {
    }

    public AClass(Integer i, Double d) {
        this.i = i;
        this.d = d;
    }

    public AClass(Double d) {
        this.d = d;
    }

    public AClass(Integer i) {
        this.i = i;
    }
}

interface I1<A, F> {
    F create(A a);
}

interface I2<A1, A2, F> {
    F create(A1 a1, A2 a2);
}

public class Java8 {
    public static void main(String[] args) {
        System.out.println("Java 8");
        Formula f = i -> i * 10d;
//        System.out.println(f.div10(112));
//        System.out.println(f.calculate(10));

        Func<Integer, Double> func = Double::valueOf;
        Integer i = 101;
        Func<Integer, Integer> func2 = i::compareTo;
//        System.out.println(func.func(15));
        System.out.println(func2.func(1011));

        I1<Integer, AClass> i1 = AClass::new;
        System.out.println(i1.create(15));
        I1<Double, AClass> d1 = AClass::new;
        System.out.println(d1.create(15.5d));
        I2<Integer, Double, AClass> i2 = AClass::new;
        System.out.println(i2.create(-5, 15.5d));

        Object obj = new Object();

        Predicate<Object> predicate = obj::equals;
        System.out.println(predicate.test(new Object()));
        System.out.println(predicate.test(obj));
        System.out.println(predicate.or(a -> a.equals(new Object())).negate().test(obj));

//        String a = null;//"null";
        String a = "null";
        Optional<String> opt = Optional.ofNullable(a);
        System.out.println(opt);
        System.out.println(opt.isPresent());
        System.out.println(opt.orElse("123a"));
        System.out.println(opt);

        String ost = "ost";
        Supplier<String> supplier = ost::toString;

        opt.orElseGet(supplier);
//        String str = opt.orElse("2354") + opt.get();

//        System.out.println(opt.get());
        System.out.println(opt.orElseGet(supplier));
        opt.ifPresent(System.out::println);
    }
}

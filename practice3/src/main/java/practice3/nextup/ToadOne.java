package practice3.nextup;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.print.attribute.standard.PresentationDirection;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by joe on 27.04.16.
 */
public class ToadOne {

    int okey = 11;

    public String getWithBrackets(String word) {
        return "\"" + word + "\"";
    }

    public static String _getWithBrackets(String word) {
        return "!!!" + word + "!!!";
    }

    public static void main(String[] args) {
        System.out.println("System of a down");
        System.out.println(new ToadOne().getWithBrackets("abc"));

        Transformer transformer = (a) -> "{" + a + "}";
        System.out.println(transformer.transform("amb"));
        transformer = a -> new ToadOne().getWithBrackets((String) a);
        System.out.println(transformer.transform("a"));
        Transformer<String, String> transformer2 = ToadOne::_getWithBrackets;
        System.out.println(transformer2.transform("OM"));
        ToadOne to = new ToadOne();
        Transformer<String, String> transformer3 = to::getWithBrackets;
//        to = null;
        System.out.println(transformer3.transform("Ostin"));
        DataIdFactory dataId = Data::new;
        DataAllFactory dataAll = Data::new;

        System.out.println(dataId.create("newId"));
        System.out.println(dataAll.create("newOneId", "newOneName", "newOneAddition"));

        int num = 15;
        to.okey++;
        Transformer<Integer, Integer> transformer1 = (a) -> a + 1 + to.okey;
        System.out.println(transformer1.transform(15));
        transformer.printOkey();
        System.out.println(transformer.returnOne());
        num = 15;

        Predicate<Integer> intPredicate = i -> String.valueOf(i).length() > 1;
        System.out.println(intPredicate.negate().test(12));
        System.out.println(intPredicate.negate().test(7));

        Predicate<Object> objPredicate = o -> o == null;
        System.out.println(objPredicate.test(null));
        System.out.println(objPredicate.test(22));
        Predicate<Object> isNull = Objects::isNull;
        System.out.println(isNull.test(null));
        System.out.println(isNull.test("abc"));

        Function<String, Integer> toInteger = a -> Integer.valueOf(a) + 5;
        Function<String, String> backToString = toInteger.andThen(a -> "!" + a + "!");
        System.out.println(backToString.apply("5"));

        Supplier<Data> dataSupplier = Data::new;
        System.out.println(dataSupplier.get());
        Consumer<Data> consumer = d -> System.out.println("Hello, " + d);
        consumer.accept(dataSupplier.get());

        Optional<String> optional = Optional.ofNullable(null);

        System.out.println(optional.isPresent());           // true
        optional.orElse("fallback");    // "bam"
//        optional.get();                 // "bam"

        optional.ifPresent((s) -> System.out.println(s.charAt(0)));
    }
}

@FunctionalInterface
interface Transformer<A, V> {
    V transform(A arg);

    default void printOkey() {
        System.out.println("OKEY");
    }

    default int returnOne() {
        return 1;
    }
}

@AllArgsConstructor
@ToString
@NoArgsConstructor
class Data {
    private String id;
    private String name;
    private String addition;

    public Data(String id) {
        this.id = id;
    }
}

@FunctionalInterface
interface DataIdFactory<D extends Data> {
    D create(String id);
}

@FunctionalInterface
interface DataAllFactory<D extends Data> {
    D create(String id, String name, String addition);
}

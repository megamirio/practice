package practice3.java8again;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.io.IOException;
import java.util.Optional;
import java.util.function.Predicate;

interface Okey<P, V> {
    V func(P v);
}

interface Okey2<A1, A2, V> {
    V func(A1 a1, A2 a2);
}

@AllArgsConstructor
@ToString
class Some {
    long id;
    String name;
}

public class Today {

    public static void main(String[] args) {
        Okey<Integer, String> okey = String::valueOf;
        System.out.println(okey.func(1));

        Okey<Integer, Okey> okey2 = a -> new Okey<Integer, String>() {
            @Override
            public String func(Integer v) {
                return String.valueOf(v);
            }
        };

        System.out.println(okey2.func(2));

        Okey2<Integer, String, Some> someCreator = Some::new;
        System.out.println(someCreator.func(55, "abc"));

        Predicate<String> pred = s -> s.length() < 5;

        pred.test("foo");
        System.out.println(pred.negate().test("foo"));

        String st = null;

        Optional<String> optional = Optional.empty();

        optional = Optional.of("yes");
        optional.isPresent();           // true
//        optional.get();                 // "bam"
        optional.orElse("fallback");    // "bam"
        System.out.println(optional.orElse("fallback"));
        optional.ifPresent((s) -> System.out.println(s.charAt(0)));     // "b"
    }
}

class AstException extends Exception {
}

class AstExceptionExt extends AstException {
}

interface First1{
    public void meth() throws AstExceptionExt, IOException;
}

interface First2 extends First1{
    public void meth() throws AstExceptionExt;
}
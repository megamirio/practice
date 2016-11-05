package practice3.java8new;

import org.jetbrains.annotations.Contract;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

interface IOne {

    public Object get(Object input);

    @Contract("_,null,_ -> null;_,_,null -> fail")
    public default Object one(Object input1, Object input2, Object input3) {
        assert input3 != null;
        if (input2 == null)
            return null;
        return null;
    }
}

public class One {

    @Contract
    public Object one(Object input) {
        return null;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("2233");
        list.add("2233aa");
        list.add("223");
        list.add("aa223aa");

        Optional<List<String>> opt = Optional.ofNullable(list);
        System.out.println(opt.filter(e -> e.size() > 1).orElse(new LinkedList<>()));
        Consumer<Object> sout = o -> System.out.println(o);
        sout.accept("ab");
        IOne i = a -> a.toString();
        System.out.println(i.one(3,null,3));
        System.out.println(i.one(3,null,null));
    }
}

package practice3.java8;

interface Beta {
    default int getIt(String number) {
        return Integer.valueOf(number);
    }

    default int getIt2(String number) {
        return getIt("1");
    }
}

class Okey {
    private String str;

    public Okey(String str) {
        this.str = str;
    }
}

@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}

interface PersonFactory<P, S> {
    P create(S word);
}

public class NextUp {
    public static void main(String[] args) {
        System.out.println("Go go go!");
        System.out.println(new Beta() {
        }.getIt("12"));

        Converter<Integer, String> conv = String::valueOf;
        System.out.println(conv.convert(33));
//        Converter<Okey, String> conv2 = Okey::new;
        PersonFactory<Okey, String> personFactory = Okey::new;
        System.out.println(personFactory.create("abc"));
        System.out.println(personFactory.create("abc"));
        System.out.println(personFactory.create("abc"));

    }
}

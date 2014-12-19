package stingion.classloading;

import com.sun.java.accessibility.util.Translator;

/**
 * Created by imalysh on 12/17/2014.
 */
class Opa {

    static final String str="s";

    static {
        System.out.println("static block of Opa");
    }

    {
        System.out.println("instance of Opa");
    }

    public Opa(String str) {
        System.out.println(str);
    }

    public Opa() {
    }
}

class A1 {
    static {
        new Opa("a1");
    }
}

class A2 extends A1 {
    static {
        new Opa("a2");
    }
}

interface Ita {
    Opa strNF = new Opa("ita");
}

interface ItaAfter extends Ita {
    Opa strNF2 = new Opa("itaAfter");
}

class Ok1 implements Ita {

    static {
        System.out.println("ommm before");
    }

    private void one() {
    }
}

class Ok2 extends Ok1 {
    static {
        System.out.println("ommm");
    }

    public static final String str = "oxy";

    public void one() {
    }
}

class A0 {

    public int j = 101;

    public A0() {
        forOverriding();
    }

    public void forOverriding() {
    }
}

class A extends A0 {

    public int i = 10;

    {
        System.out.println("A block " + i);
    }

    public A() {
        System.out.println("A constructor");
        forOverriding();
    }

    @Override
    public void forOverriding() {
        System.out.println("It's i = " + i);
    }
}

public class Starter {
    public static void main(String[] args) throws Exception {
//        String str = Ok2.str;
//        System.out.println(str);
////        System.out.println(Ok2.strNF);
//        Class.forName("stingion.classloading.Ita");
//        Class.forName("stingion.classloading.A2");
////        assert str == null : new Object().getClass();
////        Class.forName("stingion.classloading.Ok2", true, Ok2.class.getClassLoader());
//        System.out.println(Starter.class.getClassLoader());
//        System.out.println(Translator.class.getClassLoader());
//        System.out.println(Object.class.getClassLoader());
        System.out.println("---------------------------------------------");
        Class opaClass = Class.forName("stingion.classloading.Opa", false, Opa.class.getClassLoader());
        System.out.println(opaClass.getDeclaredConstructors()[0]);
        System.out.println(Opa.str);
    }
}

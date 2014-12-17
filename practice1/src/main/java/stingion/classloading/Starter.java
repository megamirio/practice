package stingion.classloading;

import com.sun.java.accessibility.util.Translator;

/**
 * Created by imalysh on 12/17/2014.
 */
public class Starter {
    public static void main(String[] args) {
        System.out.println(Starter.class.getClassLoader());
        System.out.println(Translator.class.getClassLoader());
        System.out.println(Object.class.getClassLoader());
    }
}

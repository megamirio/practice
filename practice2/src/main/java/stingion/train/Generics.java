package stingion.train;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joe on 30.11.15.
 */
public class Generics {
    public static void main(String[] args) {
        List<Number> list = new ArrayList<Number>();
        list.add(new Integer(2));
        list.add(new Short((short) 2));
//        list.add(new Object());
        String str = "abc";
        String str2 = new String("abc");
        String str3 = str2.intern();
        System.out.println(str == str2);
        System.out.println(str == str3);
    }
}

class Okey2 {
    private int an = new OkeyIn().anI;

    class OkeyIn {
        private int anI;

        {
            final int i2 = new Okey2().an;

            new Object() {
                void meth(final int k) {
                    int i = i2 + k;
                }
            }.meth(2);
        }
    }
}

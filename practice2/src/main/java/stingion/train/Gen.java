package stingion.train;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by joe on 01.12.15.
 */
public class Gen implements Serializable {
    public static void main(String[] args) {
        new Team<>(new Gen()).sout();
        System.out.println("ok");
        System.gc();

        Set<String> set = new HashSet();
        set.add("abc");
        set.add("abc2");
        set.add("abc");
        set.add("abc3");
        Iterator<String> it = set.iterator();
        System.out.println(it.next());
//        for (String st = it.next(); it.hasNext(); st = it.next()) {
//            System.out.println(st);
        set.add("фы");
//        }
        System.out.println(set);

        TreeSet<Team> set2 =new TreeSet<>();
        set2.add(new Team(2));

    }
}

class Team<T extends Serializable> {
    private T t;

    public Team(T t) {
        this.t = t;
    }

    public void sout() {
        System.out.println(t.toString());
    }
}

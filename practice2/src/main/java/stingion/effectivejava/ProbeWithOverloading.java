package stingion.effectivejava;

import java.util.*;

/**
 * Created by ievgen on 8/30/15.
 */
public class ProbeWithOverloading {
    public void methodList(List list) {
        System.out.println("List");
    }

    public void methodList(Set set) {
        System.out.println("Set");
    }

    public void methodList(Collection collection) {
        System.out.println("Unknown collection");
    }

    public static void main(String[] args) {
        ProbeWithOverloading pwol = new ProbeWithOverloading();
        Collection[] collections = {new ArrayList(), new HashSet(), new TreeSet()};
        System.out.println("Go, go, go!");
        for (Collection collection : collections) {
            pwol.methodList(collection);
        }
    }
}

package stingion.patterns.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by imalysh on 2/5/2015.
 */
interface Unit {
    public void go();
}

class Group implements Unit {

    private String name;

    private List<Unit> list = new ArrayList<>();

    public Group(String name) {
        this.name = name;
    }

    public void addUnit(Unit unit) {
        list.add(unit);
    }

    public void removeUnit(Unit unit) {
        list.remove(unit);
    }

    @Override
    public void go() {
        System.out.println(name + ":");
        for (Unit unit : list) {
            unit.go();
        }
    }
}

class Person implements Unit {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public void go() {
        System.out.println(name + " go!");
    }
}

public class CompositePattern {

    public static void main(String[] args) {
        Group group = new Group("Home 1");
        group.addUnit(new Person("Omar"));
        group.addUnit(new Person("Omar2"));
        group.addUnit(new Person("Omar3"));

        Group group1 = new Group("Home 2");
        group1.addUnit(new Person("Omar4"));
        group1.addUnit(new Person("Omar5"));
        group1.addUnit(new Person("Omar6"));

        Group group2 = new Group("Two homes");
        group2.addUnit(group);
        group2.addUnit(group1);

        group2.go();
    }
}

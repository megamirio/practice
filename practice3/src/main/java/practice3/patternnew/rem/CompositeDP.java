package practice3.patternnew.rem;

import java.util.ArrayList;
import java.util.List;

interface Composite {
    void print();
}

class Ellipse implements Composite {
    @Override
    public void print() {
        System.out.println(this);
    }
}

class Graph implements Composite {

    private List<Composite> graphs = new ArrayList<>();

    public void addComposite(Composite composite) {
        graphs.add(composite);
    }

    @Override
    public void print() {
        for (Composite composite : graphs) {
            composite.print();
        }
    }
}

public class CompositeDP {
    public static void main(String[] args) {
        System.out.println("CompositeDP");

        Composite composite1 = new Ellipse();
        Composite composite2 = new Ellipse();
        Composite composite3 = new Ellipse();

        Graph graph1 = new Graph();
        graph1.addComposite(composite1);
        graph1.addComposite(composite3);

        Graph graph2 = new Graph();
        graph2.addComposite(composite2);
        graph2.addComposite(graph1);

        graph2.print();
    }
}

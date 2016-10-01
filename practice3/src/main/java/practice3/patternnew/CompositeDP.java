package practice3.patternnew;

import java.util.ArrayList;
import java.util.List;

interface Graph {
    void draw();
}

class Ellipse implements Graph {
    @Override
    public void draw() {
        System.out.println("Ellipse drawing " + this);
    }
}

class Graphics implements Graph {
    List<Graph> graphs = new ArrayList<>();

    void addGraph(Graph graph) {
        graphs.add(graph);
    }

    @Override
    public void draw() {
        for (Graph graph : graphs) {
            graph.draw();
        }
    }
}

public class CompositeDP {
    public static void main(String[] args) {
        System.out.println("Composite DP");

        Ellipse ellipse1 = new Ellipse();
        Ellipse ellipse2 = new Ellipse();
        Ellipse ellipse3 = new Ellipse();

        Graphics graphics = new Graphics();
        Graphics graphics2 = new Graphics();

        graphics.addGraph(ellipse1);
        graphics.addGraph(ellipse3);

        graphics2.addGraph(ellipse2);
        graphics2.addGraph(graphics);

        graphics2.draw();
    }
}

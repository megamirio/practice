package practice3.patternnew.rem;

import java.util.LinkedList;
import java.util.List;

interface Part {
    void accept(Visitor visitor);
}

class Mouse implements Part {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Keyboard implements Part {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Comp implements Part {
    List<Part> parts = new LinkedList<>();
    {
        parts.add(new Mouse());
        parts.add(new Keyboard());
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
        for (Part part : parts) {
            part.accept(visitor);
        }
    }
}


interface Visitor {
    void visit(Mouse mouse);

    void visit(Keyboard keyboard);

    void visit(Comp comp);
}

class VisitorImpl implements Visitor {
    @Override
    public void visit(Mouse mouse) {
        System.out.println("visit mouse");
    }

    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("visit keyboard");
    }

    @Override
    public void visit(Comp comp) {
        System.out.println("visit comp");
    }
}

public class VisitorDP {
    public static void main(String[] args) {
        System.out.println("Visitor DP");
        new Comp().accept(new VisitorImpl());
    }
}

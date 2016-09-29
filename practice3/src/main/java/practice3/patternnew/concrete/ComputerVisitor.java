package practice3.patternnew.concrete;

interface Part {
    void accept(Checker visitor);
}

class Mouse implements Part {
    @Override
    public void accept(Checker visitor) {
        visitor.visit(this);
    }
}

class Keyboard implements Part {
    @Override
    public void accept(Checker visitor) {
        visitor.visit(this);
    }
}

class Computer implements Part {
    Part[] parts = new Part[]{new Mouse(), new Keyboard()};

    @Override
    public void accept(Checker visitor) {
        for (Part part : parts) {
            part.accept(visitor);
        }
        visitor.visit(this);
    }
}

interface Checker {
    void visit(Mouse mouse);

    void visit(Keyboard keyboard);

    void visit(Computer computer);
}

class CheckerImpl implements Checker {
    @Override
    public void visit(Mouse mouse) {
        System.out.println("Mouse attached: " + mouse);
    }

    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("Keyboard attached: " + keyboard);
    }

    @Override
    public void visit(Computer computer) {
        System.out.println("Computer attached: " + computer);
    }
}

public class ComputerVisitor {
    public static void main(String[] args) {
        System.out.println("Computer Concrete Design Pattern");
        new Computer().accept(new CheckerImpl());
    }
}

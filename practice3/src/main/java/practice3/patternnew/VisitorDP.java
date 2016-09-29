package practice3.patternnew;

/**
 * Created by eugene on 29.09.16.
 */

interface Part {
    void accept(Visitor visitor);
}

class PartA implements Part {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class PartB implements Part {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class PartC implements Part {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class PartComb implements Part {

    Part[] parts = new Part[]{new PartC(), new PartB(), new PartC()};

    @Override
    public void accept(Visitor visitor) {
        for (Part part : parts) {
            part.accept(visitor);
        }

        visitor.visit(this);
    }
}

interface Visitor {
    void visit(PartA partA);

    void visit(PartB partB);

    void visit(PartC partC);

    void visit(PartComb partComb);
}

class VisitorImpl implements Visitor {
    @Override
    public void visit(PartA partA) {
        System.out.println("It's: " + partA);
    }

    @Override
    public void visit(PartB partB) {
        System.out.println("It's: " + partB);
    }

    @Override
    public void visit(PartC partC) {
        System.out.println("It's: " + partC);
    }

    @Override
    public void visit(PartComb partComb) {
        System.out.println("It's: " + partComb);
    }
}

public class VisitorDP {
    public static void main(String[] args) {
        System.out.println("Visitor Design Pattern");
        new PartComb().accept(new VisitorImpl());
    }
}

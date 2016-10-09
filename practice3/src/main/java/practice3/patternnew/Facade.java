package practice3.patternnew;

interface ShapeA {
    void draw();
}

class ShapeA1 implements ShapeA {
    @Override
    public void draw() {
        System.out.println("shapeA1");
    }
}

class ShapeA2 implements ShapeA {
    @Override
    public void draw() {
        System.out.println("shapeA2");
    }
}

class ShapeAFacade {
    private ShapeA1 shapeA1;
    private ShapeA2 shapeA2;

    public ShapeAFacade(ShapeA1 shapeA1, ShapeA2 shapeA2) {
        this.shapeA1 = shapeA1;
        this.shapeA2 = shapeA2;
    }

    void drawShapeA1() {
        shapeA1.draw();
    }

    void drawShapeA2() {
        shapeA2.draw();
    }
}

public class Facade {
    public static void main(String[] args) {
        ShapeAFacade facade = new ShapeAFacade(new ShapeA1(), new ShapeA2());
        facade.drawShapeA1();
        facade.drawShapeA2();
    }
}

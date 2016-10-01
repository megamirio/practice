package practice3.patternnew;

interface DrawAPI {
    void draw(int x, int y, int radius);
}

class RedCircle implements DrawAPI {
    @Override
    public void draw(int x, int y, int radius) {
        System.out.println("Red circle: " + x + " | " + y + " | " + radius);
    }
}

abstract class Shape {
    protected int x;
    protected int y;
    protected int radius;
    protected DrawAPI drawAPI;

    public Shape(int x, int y, int radius, DrawAPI drawAPI) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.drawAPI = drawAPI;
    }

    public abstract void draw();
}

class Circle extends Shape {
    public Circle(int x, int y, int radius, DrawAPI drawAPI) {
        super(x, y, radius, drawAPI);
    }

    @Override
    public void draw() {
        drawAPI.draw(x, y, radius);
    }
}

public class BridgeDP {
    public static void main(String[] args) {
        System.out.println("Bridge DP");
        new Circle(2, 3, 5, new RedCircle()).draw();
    }
}

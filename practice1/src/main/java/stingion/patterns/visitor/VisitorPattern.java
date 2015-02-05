package stingion.patterns.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by imalysh on 2/5/2015.
 */
interface Car {
    public void accept(Visitor visitor);
}

class BMW implements Car {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Audi implements Car {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Reno implements Car {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Garage implements Car {
    private List<Car> list = new ArrayList<>();

    public void addCar(Car car) {
        list.add(car);
    }

    public void removeCar(Car car) {
        list.remove(car);
    }

    @Override
    public void accept(Visitor visitor) {
        for (Car car : list) {
            car.accept(visitor);
        }
    }
}

interface Visitor {
    public void visit(BMW bmw);

    public void visit(Audi audi);

    public void visit(Reno reno);
}

class VisitorImpl implements Visitor {
    @Override
    public void visit(BMW bmw) {
        System.out.println("Visit " + BMW.class.getSimpleName());
    }

    @Override
    public void visit(Audi audi) {
        System.out.println("Visit " + Audi.class.getSimpleName());
    }

    @Override
    public void visit(Reno reno) {
        System.out.println("Visit " + Reno.class.getSimpleName());
    }
}

public class VisitorPattern {
    public static void main(String[] args) {
        System.out.println("Go, go, go!!!");

        Garage garage = new Garage();
        garage.addCar(new BMW());
        garage.addCar(new Audi());
        garage.addCar(new Reno());

        garage.accept(new VisitorImpl());
    }
}

package stingion.patterns.factorymethod;

/**
 * Created by imalysh on 1/23/2015.
 */
abstract class Car {
}

class BMW extends Car {
}

class Audi extends Car {
}

class Moskvich extends Car {
}

class Zhygul extends Car {
}

class Volga extends Car {
}

abstract class CarCreator {
    public abstract Car createCar();
}

class BMWCreator extends CarCreator {

    @Override
    public Car createCar() {
        return new BMW();
    }
}

class AudiCreator extends CarCreator {

    @Override
    public Car createCar() {
        return new Audi();
    }
}

enum USSRCarType {
    Moskvich,
    Zhygul,
    Volga
}

class USSRCarCreator {
    public Car createCar(USSRCarType carType) {
        switch (carType) {
            case Moskvich:
                return new Moskvich();
            case Zhygul:
                return new Zhygul();
            case Volga:
                return new Volga();
            default:
                return null;
        }
    }
}

public class CarMethodFactory {
    public static void main(String[] args) {
        CarCreator[] creators = new CarCreator[]{new BMWCreator(), new AudiCreator()};
        for (CarCreator creator : creators) {
            Car car = creator.createCar();
            System.out.println(car);
        }

        USSRCarCreator SUCreator = new USSRCarCreator();
        Car[] cars = new Car[]{SUCreator.createCar(USSRCarType.Moskvich), SUCreator.createCar(USSRCarType.Volga),
                               SUCreator.createCar(USSRCarType.Zhygul)};
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}

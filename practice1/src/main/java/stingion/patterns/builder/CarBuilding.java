package stingion.patterns.builder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by imalysh on 1/23/2015.
 */
@ToString
@Setter
class Car {

    private double engineVolume;
    private int colour;
}

abstract class CarBuilder {

    @Getter
    protected Car car;

    public void createCar() {
        car = new Car();
    }

    public abstract void buildEngineVolume();

    public abstract void buildColour();
}

class HundaiAccentBuilder extends CarBuilder {

    @Override
    public void buildEngineVolume() {
        car.setEngineVolume(1.6);
    }

    @Override
    public void buildColour() {
        car.setColour(1);
    }
}

class MitsubishiColtBuilder extends CarBuilder {

    @Override
    public void buildEngineVolume() {
        car.setEngineVolume(1.4);
    }

    @Override
    public void buildColour() {
        car.setColour(2);
    }
}

class Plant {
    private CarBuilder builder;

    public void setBuilder(CarBuilder builder) {
        this.builder = builder;
    }

    public void construct() {
        builder.createCar();
        builder.buildEngineVolume();
        builder.buildColour();
    }

    public Car getCar(){
        return builder.car;
    }
}

public class CarBuilding {
    public static void main(String[] args) {
        Plant plant = new Plant();

        plant.setBuilder(new HundaiAccentBuilder());
        plant.construct();
        System.out.println(plant.getCar());

        plant.setBuilder(new MitsubishiColtBuilder());
        plant.construct();
        System.out.println(plant.getCar());
    }
}

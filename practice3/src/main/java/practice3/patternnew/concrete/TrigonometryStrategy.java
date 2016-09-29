package practice3.patternnew.concrete;

import lombok.Setter;

/**
 * Created by eugene on 29.09.16.
 */
interface Strategy {
    double doOperation(double arg);
}

class TanStrategy implements Strategy {
    @Override
    public double doOperation(double arg) {
        return Math.tan(arg);
    }
}

class CotanStrategy implements Strategy {
    @Override
    public double doOperation(double arg) {
        return 1 / Math.tan(arg);
    }
}

class SinStrategy implements Strategy {
    @Override
    public double doOperation(double arg) {
        return Math.sin(arg);
    }
}

class CosStrategy implements Strategy {
    @Override
    public double doOperation(double arg) {
        return Math.cos(arg);
    }
}

class MathContext {
    @Setter
    private Strategy strategy;

    public double executeStrateg(double arg) {
        return strategy.doOperation(arg);
    }
}

public class TrigonometryStrategy {
    public static void main(String[] args) {
        System.out.println("Concrete Example with Strategy Design Pattern");

        double arg = Math.PI/2;
        MathContext context = new MathContext();

        context.setStrategy(new CosStrategy());
        System.out.println("Cos:" + context.executeStrateg(arg));

        context.setStrategy(new SinStrategy());
        System.out.println("Sin:" + context.executeStrateg(arg));

        context.setStrategy(new TanStrategy());
        System.out.println("tg:" + context.executeStrateg(arg));

        context.setStrategy(new CotanStrategy());
        System.out.println("ctg:" + context.executeStrateg(arg));
    }
}

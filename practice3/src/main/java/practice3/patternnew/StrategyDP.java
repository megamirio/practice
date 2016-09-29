package practice3.patternnew;

import lombok.Setter;

/**
 * Created by eugene on 29.09.16.
 */
interface Strategy {
    int doOperation(int arg1, int arg2);
}

class AddStrategy implements Strategy {
    public int doOperation(int arg1, int arg2) {
        return arg1 + arg2;
    }
}

class SubstractStrategy implements Strategy {
    public int doOperation(int arg1, int arg2) {
        return arg1 - arg2;
    }
}

class MultiplyStrategy implements Strategy {
    public int doOperation(int arg1, int arg2) {
        return arg1 * arg2;
    }
}

class Context {
    @Setter
    private Strategy strategy;

    public int executeStrategy(int arg1, int arg2) {
        return strategy.doOperation(arg1, arg2);
    }
}

public class StrategyDP {
    public static void main(String[] args) {
        System.out.println("Strategy Design Pattern");
        Context context = new Context();

        context.setStrategy(new AddStrategy());
        System.out.println(context.executeStrategy(125,25));

        context.setStrategy(new SubstractStrategy());
        System.out.println(context.executeStrategy(125,25));

        context.setStrategy(new MultiplyStrategy());
        System.out.println(context.executeStrategy(125,25));
    }
}

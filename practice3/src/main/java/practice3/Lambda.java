package practice3;

import java.util.Objects;
import java.util.function.Consumer;

/**
 * Created by joe on 08.10.15.
 */
public class Lambda {
    public static void main(String[] args) {
        Lambda lb = new Lambda();

        Consumer sou = a -> {
            if (a instanceof Number)
                System.out.printf(" %10.3f%n", a);
            else
                System.out.printf("%-15s", a + ":");
        };

        Consumer sout = a -> sou.accept(a);

        sout.accept(lb.outputAndResut(2, 2, (a, b) -> a + b, () -> sou.accept("summation")));
        sout.accept(lb.outputAndResut(2, 2, (a, b) -> a - b, () -> sou.accept("subtraction")));
        sout.accept(lb.outputAndResut(211.13, 3232, (a, b) -> a * b, () -> sou.accept("multiplication")));
        sout.accept(lb.outputAndResut(2, 2.3, (a, b) -> a / b, () -> sou.accept("division")));
    }

    interface MathOperation {
        double operation(double arg1, double arg2);
    }

    interface MessageOutput {
        void output();
    }

    public double outputAndResut(double arg1, double arg2, MathOperation operation, MessageOutput message) {
        message.output();
        return operation.operation(arg1, arg2);
    }
}

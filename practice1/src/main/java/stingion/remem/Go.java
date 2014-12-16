package stingion.remem;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

class A {
}

class B extends A {
}

interface Quiz {
    void eastern();

    class Omega {

        @Setter
        @Getter
        private int i;
    }
}

class Opergame {
    protected void eastern() {
    }
}

class Opergame2 extends Opergame {

    @Override
    public void eastern() {

    }
}


/**
 * Created under not commercial project
 */
public class Go {

    public void sim(A a) {
        System.out.println(a.getClass());
    }

    public void sim(B b) {
        System.out.println(b.getClass());
    }

    public static void main(String[] args) {
        System.out.println("Go, go, go!!!");

        A a = new A();
        B b = new B();

        Go go = new Go();

        go.sim(a);
        go.sim(b);

        Quiz.Omega omega = new Quiz.Omega();

        omega.setI(3);
        System.out.println(omega.getI());

        int[] a1 = {3,-3,3};
        int[] a2 = a1.clone();
        System.out.println(Arrays.toString(a2));
    }
}

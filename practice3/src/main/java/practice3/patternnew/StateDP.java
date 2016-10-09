package practice3.patternnew;

import lombok.Getter;
import lombok.Setter;

interface State {
    void doAction(Cont cont);
}

class StartState implements State {
    @Override
    public void doAction(Cont cont) {
        cont.setState(this);
    }

    public String toString() {
        return "Start state";
    }
}

class StopState implements State {
    @Override
    public void doAction(Cont cont) {
        cont.setState(this);
    }

    public String toString() {
        return "Stop state";
    }
}

class Cont {
    @Setter
    @Getter
    private State state;
}

public class StateDP {
    public static void main(String[] args) {
        System.out.println("State DP");
        Cont cont = new Cont();
        new StartState().doAction(cont);
        System.out.println(cont.getState());
        new StopState().doAction(cont);
        System.out.println(cont.getState());
    }
}

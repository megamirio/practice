package practice3.patternnew;

import lombok.Setter;

abstract class Colleague {
    private Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    public void send(String message) {
        mediator.send(message, this);
    }

    abstract void notify(String message);
}

class ColleagueA extends Colleague {
    public ColleagueA(Mediator mediator) {
        super(mediator);
    }

    @Override
    void notify(String message) {
        System.out.println(this + " gets message: " + message);
    }
}

class ColleagueB extends Colleague {
    public ColleagueB(Mediator mediator) {
        super(mediator);
    }

    @Override
    void notify(String message) {
        System.out.println(this + " gets message: " + message);
    }
}

interface Mediator {
    void send(String message, Colleague colleague);
}

@Setter
class ConcreteMediator implements Mediator {
    private ColleagueA colleagueA;
    private ColleagueB colleagueB;

    @Override
    public void send(String message, Colleague colleague) {
        if (colleague.equals(colleagueA)) {
            colleagueB.notify(message);
        } else {
            colleagueA.notify(message);
        }
    }
}

public class MediatorDP {
    public static void main(String[] args) {
        System.out.println("Mediator DP");

        ConcreteMediator mediator = new ConcreteMediator();
        ColleagueA colleagueA = new ColleagueA(mediator);
        ColleagueB colleagueB = new ColleagueB(mediator);

        mediator.setColleagueA(colleagueA);
        mediator.setColleagueB(colleagueB);
        colleagueA.send("okey?");
        colleagueB.send("no!");
    }
}

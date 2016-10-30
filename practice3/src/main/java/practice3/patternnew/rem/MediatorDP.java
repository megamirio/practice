package practice3.patternnew.rem;

import lombok.Setter;

interface Colleague {
    void send(String message);

    void notification(String message);
}

abstract class ConcreteColleague implements Colleague {

    private ColleagueMediator mediator;

    public ConcreteColleague(ColleagueMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void send(String message) {
        mediator.send(message, this);
    }

    @Override
    public void notification(String message) {
        System.out.println(this + " gets: " + message);
    }
}

class ConcreteColleagueA extends ConcreteColleague {
    public ConcreteColleagueA(ColleagueMediator mediator) {
        super(mediator);
    }
}

class ConcreteColleagueB extends ConcreteColleague {
    public ConcreteColleagueB(ColleagueMediator mediator) {
        super(mediator);
    }
}

interface ColleagueMediator {
    void send(String message, Colleague colleague);
}

@Setter
class ConcreteColleagueMediator implements ColleagueMediator {
    private ConcreteColleagueA colleagueA;
    private ConcreteColleagueB colleagueB;

    @Override
    public void send(String message, Colleague colleague) {
        if (colleague.equals(colleagueA)) {
            colleagueB.notification(message);
        }
        if (colleague.equals(colleagueB)) {
            colleagueA.notification(message);
        }
    }
}

public class MediatorDP {
    public static void main(String[] args) {
        System.out.println("Mediator DP");

        ConcreteColleagueMediator mediator = new ConcreteColleagueMediator();
        ConcreteColleagueA colleagueA = new ConcreteColleagueA(mediator);
        ConcreteColleagueB colleagueB = new ConcreteColleagueB(mediator);

        mediator.setColleagueA(colleagueA);
        mediator.setColleagueB(colleagueB);

        colleagueA.send("Hello, B");
        colleagueB.send("Hi, A");
    }
}

package practice3.patternnew;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by eugene on 29.09.16.
 */

class Subject {
    private List<Observer> observers = new ArrayList<>();

    @Getter
    private String state;

    public void attache(Observer observer) {
        observers.add(observer);
    }

    public void setState(String state) {
        this.state = state;
        notifyAllObservers();
    }

    void notifyAllObservers() {
        for (Observer o : observers) {
            o.update();
        }
    }
}

abstract class Observer {
    protected Subject subj;

    public Observer(Subject subj) {
        this.subj = subj;
        subj.attache(this);
    }

    abstract void update();
}

class ObserverA extends Observer {
    public ObserverA(Subject subj) {
        super(subj);
    }

    @Override
    public void update() {
        System.out.println("Observer A(" + this + "): " + subj.getState());
    }
}

public class ObserverDP {
    public static void main(String[] args) {
        System.out.println("Observer Design Pattern");

        Subject subj = new Subject();
        new ObserverA(subj);
        new ObserverA(subj);
        subj.setState("Okey@");
        subj.setState("NO!");
    }
}

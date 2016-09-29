package practice3.patternnew.concrete;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eugene on 29.09.16.
 */
@AllArgsConstructor
@NoArgsConstructor
class Bank {

    @Getter
    @Setter
    private int id;
}

class BankEventSubject {
    private List<BankObserver> observers = new ArrayList<>();

    @Getter
    private Bank bank;

    public void setBank(Bank bank) {
        this.bank = bank;
        notifyAllObservers();
    }

    void attach(BankObserver observer) {
        observers.add(observer);
    }

    void notifyAllObservers() {
        for (BankObserver observer : observers) {
            observer.update();
        }
    }
}

abstract class BankObserver {
    @Getter
    protected BankEventSubject subj;

    public BankObserver(BankEventSubject subj) {
        this.subj = subj;
        subj.attach(this);
    }

    abstract void update();
}

class OtpBank extends BankObserver {

    public OtpBank(BankEventSubject subj) {
        super(subj);
    }

    @Override
    public void update() {
        if (subj.getBank().getId() == 1) {
            System.out.println("It's needed for OtpBank: " + this);
        }
    }
}

class PrivatBank extends BankObserver {

    public PrivatBank(BankEventSubject subj) {
        super(subj);
    }

    @Override
    public void update() {
        if (subj.getBank().getId() == 2) {
            System.out.println("It's needed for PrivatBank: " + this);
        }
    }
}

class OshchadBank extends BankObserver {

    public OshchadBank(BankEventSubject subj) {
        super(subj);
    }

    @Override
    public void update() {
        if (subj.getBank().getId() == 3) {
            System.out.println("It's needed for OshchadBank: " + this);
        }
    }
}

public class BankObserverDP {
    public static void main(String[] args) {
        System.out.println("Concrete Bank Observer Design Pattern");

        BankEventSubject subj = new BankEventSubject();
        new OshchadBank(subj);
        new OtpBank(subj);
        new OshchadBank(subj);
        new PrivatBank(subj);

        subj.setBank(new Bank(3));
        subj.setBank(new Bank(1));
        subj.setBank(new Bank(1));
        subj.setBank(new Bank(5));
        subj.setBank(new Bank(2));
    }
}

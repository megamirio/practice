package practice3.patternnew.concrete;

import lombok.Setter;

abstract class Sender {
    private SenderMediator mediator;

    public Sender(SenderMediator mediator) {
        this.mediator = mediator;
    }

    void send(String message) {
        mediator.send(message, this);
    }

    void notify(String message) {
        System.out.println(this + " received message: " + message);
    }
}

class SenderA extends Sender {
    public SenderA(SenderMediator mediator) {
        super(mediator);
    }
}

class SenderB extends Sender {
    public SenderB(SenderMediator mediator) {
        super(mediator);
    }
}

class SenderC extends Sender {
    public SenderC(SenderMediator mediator) {
        super(mediator);
    }
}

interface SenderMediator {
    void send(String message, Sender sender);
}

@Setter
class SenderMediatorConcrete implements SenderMediator {
    private SenderA senderA;
    private SenderB senderB;
    private SenderC senderC;

    @Override
    public void send(String message, Sender sender) {
        if (message.contains("[0]")) {
            senderA.notify(message);
        } else if (message.contains("[1]")) {
            senderB.notify(message);
        } else if (message.contains("[2]")) {
            senderC.notify(message);
        } else {
            System.out.println("Sent to noone;");
        }

    }
}

public class SystemMessagerMediator {
    public static void main(String[] args) {
        System.out.println("Concrete Mediator:");

        SenderMediatorConcrete mediator = new SenderMediatorConcrete();
        SenderA senderA = new SenderA(mediator);
        SenderB senderB = new SenderB(mediator);
        SenderC senderC = new SenderC(mediator);

        mediator.setSenderA(senderA);
        mediator.setSenderB(senderB);
        mediator.setSenderC(senderC);

        senderA.send("okey");
        senderA.send("okey[2]");
        senderA.send("oke[0]y");
        senderA.send("okey[2]");
    }
}

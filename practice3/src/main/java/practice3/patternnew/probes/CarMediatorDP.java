package practice3.patternnew.probes;

import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

enum PartType {
    Customer, Plant, Seller, Service
}

interface Participant {
    void send(String message);

    void notify(String message);
}

@ToString(of = {"type"})
class ConcreteParticipant implements Participant {
    private CarMediator mediator;
    @Getter
    private PartType type;


    public ConcreteParticipant(PartType type, CarMediator mediator) {
        this.mediator = mediator;
        this.type = type;
    }

    @Override
    public void send(String message) {
        mediator.send(message);
    }

    @Override
    public void notify(String message) {
        System.out.println(this + " received message: " + message);
    }
}

interface CarMediator {
    void send(String message);
}

class ConcreteCarMediator implements CarMediator {
    private static Map<PartType, String> partsMap = new HashMap<>();

    static {
        partsMap.put(PartType.Plant, "[0]");
        partsMap.put(PartType.Seller, "[1]");
        partsMap.put(PartType.Customer, "[2]");
        partsMap.put(PartType.Service, "[3]");
    }

    private Map<PartType, ConcreteParticipant> parts = new HashMap<>();

    public void addParticipant(ConcreteParticipant participant) {
        parts.put(participant.getType(), participant);
    }

    @Override
    public void send(String message) {
        for (Map.Entry<PartType, String> entry : partsMap.entrySet()) {
            if (message.contains(entry.getValue())) {
                parts.get(entry.getKey()).notify(message.replace(entry.getValue(), ""));
                break;
            }
        }
    }
}

public class CarMediatorDP {
    public static void main(String[] args) {
        System.out.println("Design Pattern of Mediator");

        ConcreteCarMediator carMediator = new ConcreteCarMediator();
        ConcreteParticipant plant = new ConcreteParticipant(PartType.Plant, carMediator);
        ConcreteParticipant seller = new ConcreteParticipant(PartType.Seller, carMediator);
        ConcreteParticipant customer = new ConcreteParticipant(PartType.Customer, carMediator);
        ConcreteParticipant service = new ConcreteParticipant(PartType.Service, carMediator);


        carMediator.addParticipant(plant);
        carMediator.addParticipant(seller);
        carMediator.addParticipant(service);
        carMediator.addParticipant(customer);


        System.out.println(plant);
        System.out.println(seller);
        System.out.println(customer);
        System.out.println(service);

        customer.send("abc [0]");
        customer.send("abc [3]");
    }
}

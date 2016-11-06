package practice3.patternnew.rem;

import spark.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProcessPatterns {
    private static int DONE_COUNT = 0;
    private static int TO_BE_DONE_COUNT = 0;

    public static Map<Integer, String> creationalPatterns() {
        return new HashMap<Integer, String>() {{
            put(100, "Abstract factory");
            put(101, "Builder");
            put(102, "Factory method");
            put(103, "Prototype");
            put(104, "Singleton");
            put(105, "Lazy initialization");
            put(106, "Multiton");
            put(107, "Object pool");
        }};
    }

    public static Map<Integer, String> structuralPatterns() {
        return new HashMap<Integer, String>() {{
            put(200, "Facade");
            put(201, "Adapter");
            put(202, "Bridge");
            put(203, "Composite");
            put(204, "Decorator");
            put(205, "Front controller");
            put(206, "Flyweight");
            put(207, "Proxy");
        }};
    }

    public static Map<Integer, String> behavioralPatterns() {
        return new HashMap<Integer, String>() {{
            put(300, "Strategy");
            put(301, "Template method");
            put(302, "Chain of responsibility");
            put(303, "Command");
            put(304, "Interpreter");
            put(305, "Mediator");
            put(306, "Memento");
            put(307, "Null Object");
            put(308, "Observer");
            put(309, "Servant");
            put(310, "State");
            put(311, "Visitor");
        }};
    }

    public static List<Integer> donePatterns() {
        return Arrays.asList(300, 200, 301, 201, 102, 100, 101, 104, 307, 207, 305, 203, 311, 204, 308, 202, 205, 304,
                303, 206, 309, 103, 105, 106, 107);
    }

    public static void main(String[] args) {

        StringBuilder output = new StringBuilder();

        output.append(">>> Processed Design Patterns (DONE_COUNT): <<<\n");
        creationalPatterns().forEach((k, v) -> {
            output.append(donePatterns().contains(k) ? ((++DONE_COUNT) + ") " + v + "\n") : "");
        });
        structuralPatterns().forEach((k, v) -> {
            output.append(donePatterns().contains(k) ? ((++DONE_COUNT) + ") " + v + "\n") : "");
        });
        behavioralPatterns().forEach((k, v) -> {
            output.append(donePatterns().contains(k) ? ((++DONE_COUNT) + ") " + v + "\n") : "");
        });

        output.append("\n>>> To be done Design Patterns (TO_BE_DONE_COUNT): <<<\n");
        output.append(">>> (creational) <<<\n");
        creationalPatterns().forEach((k, v) -> {
            output.append(!donePatterns().contains(k) ? ((++TO_BE_DONE_COUNT) + ") " + v + "\n") : "");
        });
        output.append(">>> (structural) <<<\n");
        structuralPatterns().forEach((k, v) -> {
            output.append(!donePatterns().contains(k) ? ((++TO_BE_DONE_COUNT) + ") " + v + "\n") : "");
        });
        output.append(">>> (behavioral) <<<\n");
        behavioralPatterns().forEach((k, v) -> {
            output.append(!donePatterns().contains(k) ? ((++TO_BE_DONE_COUNT) + ") " + v + "\n") : "");
        });

        output.append("\nConclusion:\n");
        output.append("Design patterns: total count = " + (TO_BE_DONE_COUNT + DONE_COUNT)
                + ", done: " + DONE_COUNT + ", to be done: " + TO_BE_DONE_COUNT + "\n");

        output.replace(0, output.length() - 1, (output.toString().replaceFirst("DONE_COUNT", String.valueOf(DONE_COUNT))
                .replaceFirst("TO_BE_DONE_COUNT", String.valueOf(TO_BE_DONE_COUNT))));

        System.out.println(output.toString());

        //See on jetty server (http://localhost:4555/patterns)
        Service service = Service.ignite();
        service.port(4555);
        service.init();
        service.get("/patterns", (rq, rs) -> output.toString().replaceAll("\n", "<br />")
                .replace(">>> ", "&nbsp;&nbsp;&nbsp;<font color=\"blue\">>>> </font>"));

        System.out.println("See webpage: http://localhost:4555/patterns");
    }
}

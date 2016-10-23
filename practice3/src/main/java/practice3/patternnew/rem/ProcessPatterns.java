package practice3.patternnew.rem;

import java.util.stream.Stream;

public class ProcessPatterns {
    public static void main(String[] args) {
        Stream<String> donePatterns =
                Stream.of(
                        "Strategy (behavioral)",
                        "Facade (structural)",
                        "Template method (behavioral)"
                );
        System.out.println(">>> Processed Design Patterns: <<<");
        donePatterns.forEach(System.out::println);
        System.out.println(">>> To be done Design Patterns: <<<");
    }
}

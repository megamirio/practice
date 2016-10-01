package practice3.patternnew;

interface Word {
    String write();
}

class ExclamationSign implements Word {
    @Override
    public String write() {
        return "!";
    }
}

abstract class WordDecorator implements Word {
    private Word word;

    public WordDecorator(Word word) {
        this.word = word;
    }

    @Override
    public String write() {
        if (word != null) {
            return writeNew() + word.write();
        }
        return writeNew();
    }

    public abstract String writeNew();
}

class AnyWordDecorator extends WordDecorator {
    private String anyWord;

    public AnyWordDecorator(String anyWord) {
        super(null);
        this.anyWord = anyWord;
    }

    public AnyWordDecorator(String anyWord, Word word) {
        super(word);
        this.anyWord = anyWord;
    }

    @Override
    public String writeNew() {
        return anyWord;
    }
}

class CommaDecorator extends WordDecorator {

    public CommaDecorator(Word word) {
        super(word);
    }

    @Override
    public String writeNew() {
        return ",";
    }
}

class SpaceDecorator extends WordDecorator {

    public SpaceDecorator(Word word) {
        super(word);
    }

    @Override
    public String writeNew() {
        return " ";
    }
}

class WorldDecorator extends WordDecorator {

    public WorldDecorator(Word word) {
        super(word);
    }

    @Override
    public String writeNew() {
        return "World";
    }
}

class HelloDecorator extends WordDecorator {

    public HelloDecorator(Word word) {
        super(word);
    }

    @Override
    public String writeNew() {
        return "Hello";
    }
}

public class DecoratorDP {
    public static void main(String[] args) {
        System.out.println("Decorator DP");
        System.out.println(new HelloDecorator(new CommaDecorator(new SpaceDecorator(
                new WorldDecorator(new ExclamationSign())))).write());

        String expression = new AnyWordDecorator("Hello", new AnyWordDecorator(",", new AnyWordDecorator(" ",
                new AnyWordDecorator("All", new AnyWordDecorator("!"))))).write();
        System.out.println(expression);
    }
}

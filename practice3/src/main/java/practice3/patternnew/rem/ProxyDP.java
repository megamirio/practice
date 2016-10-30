package practice3.patternnew.rem;

interface Summator {
    int sum(int a, int b);

    int sum(int a, int b, int c);
}

class SummatorImpl implements Summator {
    @Override
    public int sum(int a, int b) {
        return a + b;
    }

    @Override
    public int sum(int a, int b, int c) {
        return a + b + c;
    }
}

class SummatorProxy implements Summator {
    private SummatorImpl summator = new SummatorImpl();

    @Override
    public int sum(int a, int b) {
        if (checkerPositive(a, b))
            return summator.sum(a, b);
        throw new RuntimeException("All argument should be posivite");
    }

    @Override
    public int sum(int a, int b, int c) {
        if (checkerPositive(a, b, c))
            return summator.sum(a, b, c);
        throw new RuntimeException("All argument should be posivite");
    }

    private boolean checkerPositive(int... a) {
        for (int number : a) {
            if (number < 0) return false;
        }
        return true;
    }
}

public class ProxyDP {
    public static void main(String[] args) {
        System.out.println("ProxyDP");
        Summator summator = new SummatorProxy();
        System.out.println(summator.sum(334, 234));
        System.out.println(summator.sum(334, 234, 333));
    }
}

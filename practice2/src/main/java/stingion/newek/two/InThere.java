package stingion.newek.two;

/**
 * Created by royalflush on 09.12.16.
 */
public class InThere {
    private InThere(String one) {
    }

    public static InThere getInstance(String one) {
        return new InThere(one);
    }
}

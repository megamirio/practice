package stingion;

import org.jetbrains.annotations.Contract;

/**
 * Created by imalysh on 1/21/2015.
 */
public class NotNullChecking {

    public static String getResult(String text) {
        if (text == null) return "no";
        if (text == "Fail") throw new RuntimeException("fail");
        else return "It's text: " + text;
    }

    public static void main(String[] args) {
        NotNullChecking nnc = new NotNullChecking();
        System.out.println(getResult(null));
    }
}

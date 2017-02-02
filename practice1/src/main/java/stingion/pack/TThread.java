package stingion.pack;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.Callable;

/**
 * Created by royalflush on 13.12.16.
 */
class One implements Callable<String> {
    @Autowired
    private String one;

    @Override
    public String call() throws Exception {
        return one;
    }
}

public class TThread {
    public static void main(String[] args) {

    }
}

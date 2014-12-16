package stingion.spring.integration;

import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Created by ievgen on 8/4/14 10:23 PM.
 */
@Component
public class Counter {
    public Integer randomInt() {
        return new Random().nextInt();
    }
}

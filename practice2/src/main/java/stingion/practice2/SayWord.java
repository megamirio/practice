package stingion.practice2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ievgen on 8/5/14 5:49 PM.
 */
@Component
public class SayWord {

    @Autowired
    private String word;

    public String says() {
        return "says: " + word;
    }
}

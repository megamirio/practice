package stingion.newek;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import stingion.newek.two.InGood;

/**
 * Created by royalflush on 09.12.16.
 */
public class Good {

    @Autowired
    @Getter
    private InGood in;

    @Lookup
    public InGood getInGood() {
        return null;
    }
}

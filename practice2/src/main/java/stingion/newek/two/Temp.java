package stingion.newek.two;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import stingion.newek.one.Abc;

import javax.annotation.Resource;

/**
 * Created by eugene on 27.10.16.
 */
@Component
@Getter
@Setter
public class Temp {

    private Abc abc;

    public Temp() {
    }

    public void out() {
        System.out.println("temp>>" + abc);
    }
}

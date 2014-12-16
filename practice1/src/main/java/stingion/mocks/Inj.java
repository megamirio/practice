package stingion.mocks;

import lombok.Getter;
import lombok.Setter;

/**
 * Created under not commercial project
 */
@Getter
@Setter
public class Inj {
    private ToInj toInj;

    public void ok() {
        System.out.println("ok");
    }
}

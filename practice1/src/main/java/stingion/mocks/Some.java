package stingion.mocks;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * Created under not commercial project
 */
@Getter
@Setter
public class Some {
    private List field1;
    private Date field2;

    public int exec(Object obj) {
        System.out.println("exec");
        return 2;
    }
}

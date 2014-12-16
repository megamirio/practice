package stingion.spring.el;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by ievgen on 9/22/14 6:11 PM.
 */
@Getter
@Setter
@ToString
@Component("itemBean2")
public class Item {

    @Value("itemB")
    private String name;

    @Value("20")
    private int qty;

}

package stingion.spring.el;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by ievgen on 9/22/14 6:10 PM.
 */
@Getter
@Setter
@ToString
@Component("customerBean2")
public class Customer {

    @Value("#{itemBean2}")
    private Item item;

    @Value("#{itemBean2.name}")
    private String itemName;
}

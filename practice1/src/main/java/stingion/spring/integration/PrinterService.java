package stingion.spring.integration;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

/**
 * Created by ievgen on 8/3/14 7:22 PM.
 */
@Component
public class PrinterService {


    // if only one method is present in the class the @ServiceActivator is not necessary
    // in alternative the method has to be explicitly declared in the configuration

    @ServiceActivator
    public void printValue(Integer value) {
        System.out.println("Square " + value + "^2" + value * value);
    }
}

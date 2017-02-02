package stingion.spring.integration;

//import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * Created by ievgen on 8/3/14 7:22 PM.
 */
@Service
public class HelloService {

//    static final Logger logger = Logger.getLogger(HelloService.class);

    public Integer negativeNumber(Integer number) {
        System.out.println("Negative number:  " + number);
        return number;
    }

    public Integer positiveNumber(Integer number) {
        System.out.println("Positive number:  " + number);
        return number;
    }
}
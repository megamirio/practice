package stingion.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Random;

/**
 * Created by ievgen on 8/3/14 7:32 PM.
 */
@Controller
@RequestMapping("/welcome")
public class HelloController {

    @Autowired
    @Qualifier("inputChannel")
    MessageChannel channel;

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {

        channel.send(MessageBuilder.withPayload("Let's get random number: " + new Random().nextInt(Integer.MAX_VALUE)).build());

        model.addAttribute("message", "Spring 3 MVC Hello World");
        return "hello";
    }

}

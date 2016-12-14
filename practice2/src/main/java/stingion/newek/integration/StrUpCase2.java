/*
 * Created under not commercial project
 */
package com.appspot.stingion.integration.minor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StrUpCase2 {
    private static Logger log = LoggerFactory.getLogger(StrUpCase2.class);

    private static ApplicationContext context;

    public static void main(String[] args) {
        context = new ClassPathXmlApplicationContext("META-INF/com/appspot/stingion/spring/integration-minor.xml");
        StrUpCaseGateway gateway = context.getBean("gateway", StrUpCaseGateway.class);
        gateway.send("Spring Integration using Gateway");
        String msg = gateway.receive();
        log.info("OUTPUT: {}", msg);
    }
}

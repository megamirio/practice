package stingion.spring.integration;

/**
 * Created by ievgen on 8/3/14 7:18 PM.
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import stingion.practice2.Ok;
import stingion.practice2.SayWord;


/**
 * The goal of this example is to show how a message can be sent to one input channel,
 * be transformed by a service, sent to a second channel and consumed by a second service
 */
public class HelloApp {
    public static void main(String[] args) throws InterruptedException {

        System.loadLibrary("Practice1.class");

        // load the Spring context
       // ApplicationContext context = new ClassPathXmlApplicationContext("spring-context/spring-config.xml");

        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-context5.xml", Ok.class);
//        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-context5.xml");
//        ApplicationContext ac = new ClassPathXmlApplicationContext("stingion/practice2/spring-context5.xml");

        System.out.println(((SayWord)ac.getBean("sayWord")).says());

        //System.out.println((String) context2.getBean("word"));
        //System.out.println((String) context2.getBean(""));

        // get the reference to the message channel
//        MessageChannel channel = (MessageChannel) context.getBean("inputChannel");
//        MessageChannel channel = (MessageChannel) context.getBean("numbers");
//        channel.send(MessageBuilder.withPayload("").build());

        // create a message with the content "World"
//        Message<Integer> message = MessageBuilder.withPayload(new Random().nextInt()).build();

//        channel.send(message);
//        ((ClassPathXmlApplicationContext) context).close();

//        MessageChannel controlChannel = ac.getBean("controlChannel2", MessageChannel.class);
//        PollableChannel adapterOutputChanel = ac.getBean("adapterOutputChanel", PollableChannel.class);
//        System.out.println("Received before adapter started: " + adapterOutputChanel.receive(1000));
//        controlChannel.send(new GenericMessage<String>("@inboundAdapter.start()"));
//        System.out.println("Received before adapter started: " + adapterOutputChanel.receive(1000));
//        controlChannel.send(new GenericMessage<String>("@inboundAdapter.stop()"));
//        System.out.println("Received after adapter stopped: " + adapterOutputChanel.receive(1000));
        //ac.close();

        //TimeUnit.MILLISECONDS.sleep(5000);
        ((ClassPathXmlApplicationContext) ac).close();
    }
}

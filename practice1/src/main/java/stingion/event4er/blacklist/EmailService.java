package stingion.event4er.blacklist;

import lombok.Setter;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import java.util.List;

/**
 * Created by royalflush on 03.01.17.
 */
public class EmailService implements ApplicationEventPublisherAware{
    private List<String> backList;
    private ApplicationEventPublisher publisher;

    public void setBackList(List<String> backList) {
        this.backList = backList;
    }

    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void sendEmail(String address, String text){
        if(backList.contains(address)){
            publisher.publishEvent(new BlackListEvent(this, address, text));
            return;
        }
    }
}

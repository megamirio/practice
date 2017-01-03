package stingion.event4er.blacklist;

import lombok.Getter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

/**
 * Created by royalflush on 03.01.17.
 */
@Getter
public class BlackListEvent extends ApplicationEvent {
    private final String address;
    private final String test;

    public BlackListEvent(Object source, String address, String test) {
        super(source);
        this.address = address;
        this.test = test;
    }

    @Override
    public String toString() {
        return "BlackListEvent{" +
                "source='" + super.source + '\'' +
                ", address='" + address + '\'' +
                ", test='" + test + '\'' +
                '}';
    }
}

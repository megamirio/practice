package stingion.event4er;

import org.springframework.context.ApplicationEvent;

/**
 * Created by royalflush on 30.12.16.
 */
public class MyCustomEvent extends ApplicationEvent {

    private static final long serialVersionUID = -5308299518665062983L;

    public MyCustomEvent(Object source) {
        super(source);
    }

    @Override
    public String toString() {
        return super.toString() + "@" + super.hashCode();
    }
}

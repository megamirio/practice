package stingion.event4er;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationListener;

/**
 * Created by royalflush on 30.12.16.
 */
public class MyEventListener implements ApplicationListener<MyCustomEvent> {

    private static final Log LOG = LogFactory.getLog(MyEventListener.class);

    public void onApplicationEvent(MyCustomEvent event) {
        LOG.info("Event Occurred : " + event);
    }
}

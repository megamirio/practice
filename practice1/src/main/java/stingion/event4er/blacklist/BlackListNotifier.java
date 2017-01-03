package stingion.event4er.blacklist;

import lombok.Setter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationListener;

/**
 * Created by royalflush on 03.01.17.
 */
public class BlackListNotifier implements ApplicationListener<BlackListEvent> {

    private static final Log LOG = LogFactory.getLog(BlackListNotifier.class);

    @Setter
    private String notificationAddress;

    @Override
    public void onApplicationEvent(BlackListEvent event) {
        LOG.info(notificationAddress + " : " + event + "@" + event.hashCode());
    }
}

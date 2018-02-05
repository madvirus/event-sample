package eventsample.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class EventHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Async
    @TransactionalEventListener
    public void handle(SampleEvent event) {
        logger.info("handle event");
    }

}

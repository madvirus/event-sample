package eventsample;

import eventsample.app.SampleService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class EventSampleApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(EventSampleApplication.class, args);
        SampleService service = ctx.getBean(SampleService.class);
        service.doSome();
    }

}

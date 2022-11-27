package be.atbash.jakarta.core.demo.qualifierinject.demo;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.slf4j.Logger;

@ApplicationScoped
public class DemoBean {

    @Inject
    private Logger logger;

    public void doSomething(String value) {
        logger.info("Performing logic for {}", value);
        logger.info("Logger name {}", logger.getName());
    }
}

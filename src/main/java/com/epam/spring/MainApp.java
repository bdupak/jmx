package com.epam.spring;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.logging.Logger;

public class MainApp {
    private static Logger LOG = Logger.getLogger(MainApp.class.getCanonicalName());

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Config config = context.getBean(Config.class, "config");

        LOG.info("Current config content: " + config.toString());
        String timeout = config.getTimeout();
        String poolSize = config.getPoolSize();
        while (!config.isStopApp()) {

            LOG.info("INFO LEVEL logging .....");
            Thread.sleep(10000);
            LOG.severe("SEVERE LEVEL logging .....");
            LOG.config("CONFIG LEVEL logging .....");
            LOG.fine("FINE LEVEL logging .....");
            LOG.info("INFO LEVEL oldTimeOut = " + timeout + " | timeout = " + config.getTimeout() + " | oldPoolSize = "
                    + poolSize + " | poolSize = " + config.getPoolSize());
            if (!timeout.equalsIgnoreCase(config.getTimeout())
                    || !poolSize.equalsIgnoreCase(config.getPoolSize())) {
                LOG.info(String.format("Modified config content: %s", config.toString()));
                timeout = config.getTimeout();
                poolSize = config.getPoolSize();
            }
        }
    }
}

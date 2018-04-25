package com.epam;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args ) throws InterruptedException {
        run();
    }

    private static void run() throws InterruptedException {
        registerBean();
        Hello hello = new Hello();
        while (true) {
            Thread.sleep(2000);
            hello.sayHello();
            hello.getMessage();
        }
    }

    private static void registerBean() {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        Hello hello = new Hello();
        ObjectName helloName;
        try {
            helloName = new ObjectName("HelloBean:name=HelloBean");
            mBeanServer.registerMBean(hello, helloName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.epam.hello;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;


public class Main
{
    public static void main( String[] args ) throws Exception {
        run();
    }

    private static void run() throws Exception {
        Hello hello = new Hello("hello");
        registerBean(hello);
        while (true) {
            Thread.sleep(2000);
            hello.sayHello();
            hello.getMessage();
        }
    }

    private static void registerBean(Hello hello) throws Exception {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        ObjectName helloName;
        helloName = new ObjectName("HelloBean:name=HelloBean");
        mBeanServer.registerMBean(hello, helloName);
    }
}

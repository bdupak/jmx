package com.epam.notification;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

public class Main {
    public static void main(String[] args) throws Exception {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        ObjectName objectName = new ObjectName("notification:type=NotificationTest");
        NotificationTest notificationTest = new NotificationTest();
        mBeanServer.registerMBean(notificationTest, objectName);
        System.out.println("Waiting for incoming request...");
        Thread.sleep(Long.MAX_VALUE);
    }
}

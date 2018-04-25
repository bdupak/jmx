package com.epam.count;

import javax.management.*;
import java.lang.management.ManagementFactory;

public class SystemConfigManagement {

    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException,
            InstanceAlreadyExistsException, MBeanRegistrationException, InterruptedException {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        SystemConfig systemConfig = new SystemConfig(10, "default");
        ObjectName objectName = new ObjectName("config:type=SystemConfig");
        mBeanServer.registerMBean(systemConfig, objectName);
        while(systemConfig.getThreadCount() != 0) {
            Thread.sleep(3000);
            System.out.println("Thread Count= " + systemConfig.getThreadCount() + " ::: Schema name= " + systemConfig.getSchemaName());
        }
    }
}

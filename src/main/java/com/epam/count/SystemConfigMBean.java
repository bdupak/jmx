package com.epam.count;

public interface SystemConfigMBean {

    void setThreadCount(int noOfThreads);

    int getThreadCount();

    void setSchemaName(String schemaName);

    String getSchemaName();

    String doConfig();
}

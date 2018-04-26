package com.epam.notification;

import javax.management.AttributeChangeNotification;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

public class NotificationTest extends NotificationBroadcasterSupport implements NotificationTestMBean {

    private int cacheSize = 200;
    private long sequenceNumber = 1;

    @Override
    public int getCacheSize() {
        return cacheSize;
    }

    @Override
    public synchronized void setCacheSize(final int size) {
        int oldSize = cacheSize;
        cacheSize = size;
        final Notification notification = new AttributeChangeNotification(this,
                sequenceNumber++,
                System.currentTimeMillis(),
                String.format("CacheSize changed from %s to %s.", oldSize, size),
                "CacheSize",
                "int",
                oldSize,
                cacheSize);
        sendNotification(notification);
    }
}

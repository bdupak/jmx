package com.epam;

public class Hello implements HelloMBean {

    private String message = "Hello";

    public Hello() {

    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void sayHello() {
        System.out.println(message);
    }
}

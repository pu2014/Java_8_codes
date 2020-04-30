package com.pu.jdk;

public class HowManyMethodsObjectHas {
    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();
        System.out.println(obj.hashCode());
        System.out.println(obj.equals(new Object()));
        System.out.println(obj.toString());
        System.out.println(obj.getClass());
        obj.wait();
        obj.notify();
        obj.notifyAll();
    }
}

package org.example;

public class Main {
    public static void main(String[] args) {
        LazySingleton instance1 = LazySingleton.getLazyInstance();
        LazySingleton instance2 = LazySingleton.getLazyInstance();

        System.out.println(instance1.hashCode());
        instance1.printData();

        System.out.println(instance2.hashCode());
        instance2.printData();

        System.out.println("thread safe ex:");

        new DataPrinter().start();
        new DataPrinter().start();
    }
}

class DataPrinter extends Thread {
    @Override
    public void run(){
        ThreadSafeSingleton.getThreadSafeInstance().printData();
    }
}
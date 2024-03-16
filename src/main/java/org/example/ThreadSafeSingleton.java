package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreadSafeSingleton {

    private String[] LETERS = { "a", "b", "c", "d", "e"};

    private List<String> data = Arrays.asList(LETERS);


    private static ThreadSafeSingleton threadSafeInstance;

    private static boolean delayMe =  true;

    private ThreadSafeSingleton(){
        Collections.shuffle(data);
    }

    //add synchronized after static they ensure that only one thread can access a block of code or method at a time
    public static synchronized ThreadSafeSingleton getThreadSafeInstance(){
        if ( threadSafeInstance == null){
            if (delayMe){
                Thread.currentThread();
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException ie){}
            }
            threadSafeInstance = new ThreadSafeSingleton();
        }
        return threadSafeInstance;
    }

    public void printData(){
        for (String item: data){
            System.out.printf("%s ", item);
        }
        System.out.println();
    }
}

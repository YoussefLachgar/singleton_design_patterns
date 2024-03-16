package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreadSafeSingleton {

    private String[] LETERS = { "a", "b", "c", "d", "e"};

    private List<String> data = Arrays.asList(LETERS);

    //add volatile after static they stop the caching of the variable (you can not caching variable)
    private static ThreadSafeSingleton threadSafeInstance;

    private static boolean delayMe =  true;

    private ThreadSafeSingleton(){
        Collections.shuffle(data);
    }

    public static ThreadSafeSingleton getThreadSafeInstance(){
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

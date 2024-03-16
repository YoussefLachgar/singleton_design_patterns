package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LazySingleton {

    private String[] LETERS = { "a", "b", "c", "d", "e"};

    private List<String> data = Arrays.asList(LETERS);

    private static LazySingleton lazyInstance;

    private LazySingleton(){
        Collections.shuffle(data);
    }

    public static LazySingleton getLazyInstance(){
        if ( lazyInstance == null){
            lazyInstance = new LazySingleton();
        }
        return lazyInstance;
    }

    public void printData(){
        for (String item: data){
            System.out.printf("%s ", item);
        }
        System.out.println();
    }
}

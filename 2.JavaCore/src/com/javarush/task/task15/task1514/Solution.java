package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики 1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static
    {
        labels.put(12.2, "abchj");
        labels.put(112.2, "abgc");
        labels.put(122.2, "abcc");
        labels.put(132.2, "avbc");
        labels.put(142.2, "aabc");


    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}

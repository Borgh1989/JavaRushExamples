package com.javarush.task.task15.task1518;

/* 
Статики 3
*/

public class Solution {


       static class Cat {
            public String name;


        }
        public static Cat cat;
        static {
            cat = new Cat();
            cat.name= "Vasia";
            System.out.println(cat.name);
        }

    public static void main(String[] args) {

    }
}

package com.learning.twentyfour.phase2.java.modifiers.test;

import com.learning.twentyfour.phase2.java.modifiers.Parent;

public class Child extends Parent {

    public String b = "Child_b";


    @Override
    public void print() {
        super.print();


        System.out.println(b);
        System.out.println(super.b);
        System.out.println(super.c);
//        System.out.println(super.d);


        printAll();

    }

//    public static void printAll() {
//        System.out.println("child - printall");
//    }
}

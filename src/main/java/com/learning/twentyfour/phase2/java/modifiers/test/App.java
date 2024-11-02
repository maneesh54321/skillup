package com.learning.twentyfour.phase2.java.modifiers.test;

import com.learning.twentyfour.phase2.java.modifiers.Parent;

public class App {
    public static void main(String[] args) {
        Child p = new Child();

        System.out.println(p.b);
        System.out.println(p.b);

        p.print();

        var v = p.getClass().getClassLoader();

         do {
            System.out.println("\n\n"+v.getName());
            v = v.getParent();
        }while(v!= null);

        System.out.println("Bootstrap");
    }
}

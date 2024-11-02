package com.learning.twentyfour.phase2.java.modifiers;

import com.learning.twentyfour.phase2.java.modifiers.test.Child;

public class App {

    public static void main(String[] args) {
        Parent p = new Child();

        p.print();
    }
}

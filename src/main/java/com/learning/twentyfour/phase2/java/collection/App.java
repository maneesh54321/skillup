package com.learning.twentyfour.phase2.java.collection;

import java.util.List;
import java.util.TreeSet;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        List<TestClass> list1 = Stream.of(new TestClass("", ""), new TestClass("", "")).sorted().toList();
//        List<TestClass> list = List.of(new TestClass("", ""), new TestClass("", ""));
//
//        var a  = new TreeSet<TestClass>();
//        a.addAll(list);

//        System.out.println(list);
    }
}

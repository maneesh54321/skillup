package com.learning.twentythree.dsalgo.Utils;

import com.learning.twentythree.dsalgo.linkedlist.ListNode;

import java.util.Arrays;
import java.util.List;

public class IOUtils {
    public static void printIntArray(int[] arr){
        List.of(arr).forEach(ele -> System.out.print(Arrays.toString(ele) + " "));
    }

    public static void swap (int i, int j, int[] arr){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void printIntegerLinkedList(ListNode sorted) {
        if(sorted!=null){
            System.out.print(sorted.val+" ");
            sorted = sorted.next;
            printIntegerLinkedList(sorted);
        }
    }
}

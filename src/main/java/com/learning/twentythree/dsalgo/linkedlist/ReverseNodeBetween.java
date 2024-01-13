package com.learning.twentythree.dsalgo.linkedlist;

public class ReverseNodeBetween {

    public static ListNode reverseBetween(ListNode A, int m, int n) {
        if(m==n){
            return A;
        }
        ListNode result = new ListNode(-1);
        result.next = A;
        ListNode left = null, right = null, start = null, end = null, next = null, prev = null, curr = result;
        int i = 1;
        while(true){
            if(i==m){
                left = curr;
            }
            if(i == m+1 ){
                start = curr;
                prev = curr;
            }
            if(i==(n+2)){
                right = curr;
                left.next = end;
                start.next = right;
                break;
            }
            if(i > m+1 && i <= n+1){
                if(i == m+2){
                    next = curr.next;
                }
                if(i==n+1){
                    end = curr;
                }
                curr.next = prev;
                prev = curr;
                curr = next;
                if(curr != null){
                    next = curr.next;
                }
            } else {
                curr = curr.next;
            }
            i++;
        }
        return result.next;
    }
}

package com.learning.twentythree.dsalgo.stack;

public class BrowserHistoryWithLinkedList {

    public static void main(String[] args) {
        BrowserHistoryWithLinkedList browserHistory = new BrowserHistoryWithLinkedList("leetcode.com");
        browserHistory.visit("google.com");       // You are in "leetcode.com". Visit "google.com"
        browserHistory.visit("facebook.com");     // You are in "google.com". Visit "facebook.com"
        browserHistory.visit("youtube.com");      // You are in "facebook.com". Visit "youtube.com"
        browserHistory.back(1);                   // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
        browserHistory.back(1);                   // You are in "facebook.com", move back to "google.com" return "google.com"
        browserHistory.forward(1);                // You are in "google.com", move forward to "facebook.com" return "facebook.com"
        browserHistory.visit("linkedin.com");     // You are in "facebook.com". Visit "linkedin.com"
        browserHistory.forward(2);                // You are in "linkedin.com", you cannot move forward any steps.
        browserHistory.back(2);                   // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
        browserHistory.back(7);
    }

    static class DoublyListNode {
        private String value;
        private DoublyListNode next;
        private DoublyListNode previous;

        public DoublyListNode(String value, DoublyListNode next, DoublyListNode previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }
    }

    private DoublyListNode first;

    private DoublyListNode last;

    int size;

    public BrowserHistoryWithLinkedList(String homepage) {
        last = first = new DoublyListNode(homepage, null, null);
        size++;
    }

    public void addAtLast(String value) {
        if (size == 0) {
            first = last = new DoublyListNode(value, null, null);
        } else {
            if(last.next!= null){
                last.next.previous = null;
            }
            last.next = new DoublyListNode(value, null, last);
            last = last.next;
            last.previous.next = last;
        }
        size++;
    }

    public int size() {
        return size;
    }

    public void visit(String url) {
        addAtLast(url);
    }

    public String back(int steps) {
        while (steps > 0 && last.previous != null) {
            steps--;
            last = last.previous;
            size--;
        }
        return last.value;
    }

    public String forward(int steps) {
        while (steps > 0 && last.next != null) {
            steps--;
            last = last.next;
            size++;
        }
        return last.value;
    }
}

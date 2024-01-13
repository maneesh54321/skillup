package com.learning.twentythree.dsalgo.linkedlist;

class MyHashMap {

    static class KeyValueListNode {
        KeyValuePair keyValuePair;
        KeyValueListNode next;

        public KeyValueListNode(KeyValuePair val, KeyValueListNode next) {
            this.keyValuePair = val;
            this.next = next;
        }
    }

    static class KeyValuePair {
        int key;
        int val;

        public KeyValuePair(int key, int val) {
            this.key = key;
            this.val = val;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            KeyValuePair that = (KeyValuePair) o;
            return key == that.key && val == that.val;
        }
    }

    int arraySize = 16;

    private KeyValueListNode[] array;

    public MyHashMap() {
        array = new KeyValueListNode[arraySize];
    }

    public void put(int key, int value) {
        int hashcode = calculateHashcode(key);
        KeyValuePair kvp = new KeyValuePair(key, value);
        KeyValueListNode curr = array[hashcode];
        KeyValueListNode result = new KeyValueListNode(null, curr);
        KeyValueListNode prev = result;
        while(curr!=null){
            if(curr.keyValuePair.key == key){
                curr.keyValuePair.val = value;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
        prev.next = new KeyValueListNode(kvp, null);
        array[hashcode] = result.next;
    }

    public int get(int key) {
        int hashcode = calculateHashcode(key);
        KeyValueListNode curr = array[hashcode];
        while(curr!=null){
            if(curr.keyValuePair.key == key) {
                return curr.keyValuePair.val;
            }
            curr = curr.next;
        }
        return -1;
    }

    public void remove(int key) {
        int hashcode = calculateHashcode(key);
        KeyValueListNode curr = array[hashcode];
        KeyValueListNode result = new KeyValueListNode(null, curr);
        KeyValueListNode prev = result;
        while(curr!=null){
            if(curr.keyValuePair.key == key){
                prev.next = curr.next;
                curr.next = null;
                break;
            }
            prev = curr;
            curr = curr.next;
        }
        array[hashcode] = result.next;
    }

    int calculateHashcode(int key) {
        return Math.abs(key) % arraySize;
    }
}

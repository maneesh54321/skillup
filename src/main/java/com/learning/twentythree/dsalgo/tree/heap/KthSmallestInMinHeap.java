package com.learning.twentythree.dsalgo.tree.heap;

public class KthSmallestInMinHeap {

    public static void main(String[] args) {

        Heap minHeap = new Heap(7, Heap.HEAP_TYPE.MIN);
        KthSmallestInMinHeap main = new KthSmallestInMinHeap();

        System.out.println(main.findKthSmallest(minHeap, 4));
    }

    public int findKthSmallest(Heap minHeap, int k){
        Heap auxMinHeap = new Heap(k, Heap.HEAP_TYPE.MIN);
        var count = 0;
        auxMinHeap.Insert(minHeap.getMaximum());

        while (true){
        }
    }
}

package com.learning.twentythree.dsalgo.tree.heap;

public class FindMaxInMinHeap {
    public static void main(String[] args) {
        Heap heap = new Heap(7, Heap.HEAP_TYPE.MIN);
        heap.Insert(1);
        heap.Insert(2);
        heap.Insert(3);
        heap.Insert(4);
        heap.Insert(5);
        heap.Insert(6);
        heap.Insert(7);
        heap.printHeapArr();

        FindMaxInMinHeap main = new FindMaxInMinHeap();
        System.out.println(main.findMaxInHeap(heap));
    }

    public int findMaxInHeap(Heap heap){
        int maxEleStartIndex = (heap.getCount()-1-1)/2 + 1;
        int max = Integer.MIN_VALUE;
        for (int i = maxEleStartIndex; i < heap.getCount(); i++) {
            max = Math.max(max, heap.getArr()[i]);
        }
        return max;
    }

}

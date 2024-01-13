package com.learning.twentythree.dsalgo.tree.heap;

public class Heap {
    private int capacity;
    private int count;
    private int[] arr;
    private HEAP_TYPE heapType;

    public enum HEAP_TYPE {
        MIN, MAX
    }

    public Heap(int capacity, HEAP_TYPE heapType) {
        this.capacity = capacity;
        this.heapType = heapType;
        this.count = 0;
        this.arr = new int[this.capacity];
    }

    public int getCount() {
        return count;
    }

    public int[] getArr() {
        return arr;
    }

    public HEAP_TYPE getHeapType() {
        return heapType;
    }

    public static void main(String[] args) {
        Heap maxHeap = new Heap(5, HEAP_TYPE.MAX);
        maxHeap.Insert(1);
        maxHeap.Insert(2);
        maxHeap.Insert(3);
        maxHeap.Insert(4);
        maxHeap.Insert(5);
//        System.out.println(maxHeap.deleteMax());
//        System.out.println(maxHeap.deleteMax());
//        System.out.println(maxHeap.deleteMax());
//        System.out.println(maxHeap.deleteMax());
//        System.out.println(maxHeap.deleteMax());

        System.out.println(maxHeap.deleteElementAtIndex(2));
        maxHeap.printHeapArr();
    }

    public int Parent(int i) {
        if (i <= 0 || i >= this.count) {
            return -1;
        }
        return (i - 1) / 2;
    }

    public int LeftChild(int i) {
        int left = 2 * i + 1;
        if (left >= this.count)
            return -1;
        return left;
    }

    public int RightChild(int i) {
        int right = 2 * i + 2;
        if (right >= this.count)
            return -1;
        return right;
    }

    public int getMaximum() {
        if (count == 0) {
            return -1;
        }
        return this.arr[0];
    }

    private void percolateDown(int i) {
        int tmp, l, r;
        l = LeftChild(i);
        r = RightChild(i);
        if (this.heapType == HEAP_TYPE.MAX) {
            int max;


            if (l != -1 && arr[l] > arr[i]) {
                max = l;
            } else {
                max = i;
            }
            if (r != -1 && arr[r] > arr[max]) {
                max = r;
            }

            if (max != i) {
                tmp = arr[i];
                arr[i] = arr[max];
                arr[max] = tmp;
                percolateDown(max);
            }
        } else {
            int min;
            if (l != -1 && arr[l] < arr[i]) {
                min = l;
            } else {
                min = i;
            }
            if (r != -1 && arr[r] < arr[min]) {
                min = r;
            }

            if (min != i) {
                tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
                percolateDown(min);
            }
        }
    }

    private void percolateUp(int i) {
        int p, tmp;

        p = Parent(i);

        if (this.heapType == HEAP_TYPE.MAX) {
            if (p != -1 && arr[p] < arr[i]) {
                tmp = arr[i];
                arr[i] = arr[p];
                arr[p] = tmp;
                percolateUp(p);
            }
        } else {
            if (p != -1 && arr[p] > arr[i]) {
                tmp = arr[i];
                arr[i] = arr[p];
                arr[p] = tmp;
                percolateUp(p);
            }
        }
    }

    public int deleteMax() {
        if (this.count == 0) {
            return -1;
        }
        int result = getMaximum();
        arr[0] = arr[count - 1];
        count--;
        percolateDown(0);
        return result;
    }

    public void resizeHeap() {
        int[] arr_old = new int[capacity];
        System.arraycopy(arr, 0, arr_old, 0, capacity - 1);

        this.arr = new int[capacity * 2];
        System.arraycopy(arr_old, 0, arr, 0, capacity - 1);
        capacity *= 2;
    }

    public void Insert(int data) {
        if (count == capacity)
            resizeHeap();
        arr[count] = data;
        count++;
        percolateUp(count - 1);
    }

    public void printHeapArr() {
        for (int i = 0; i < count; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public int deleteElementAtIndex(int i) {
        var result = arr[i];
        arr[i] = arr[count - 1];
        count--;
        percolateDown(i);
        return result;
    }
}

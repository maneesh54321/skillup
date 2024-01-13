package com.learning.twentythree.dsalgo.queue;

import java.util.*;

public class SlidingWindowMaximum {
    public static void main(String[] args) {

    }

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            if (Objects.equals(o1, o2))
                return 0;
            return o1 > o2 ? 1 : -1;
        });
        Map<Integer, Integer> freq = new HashMap<>();
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < B; i++) {
            int elem = A.get(i);
            freq.put(elem, freq.getOrDefault(elem, 0) + 1);
            priorityQueue.add(elem);
            queue.add(elem);
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(priorityQueue.peek());
        for (int i = B; i < A.size(); i++) {
            int removeEle = queue.remove();
            freq.put(removeEle, freq.get(removeEle) - 1);
            while (!priorityQueue.isEmpty() && freq.get(priorityQueue.peek()) <= 0) {
                priorityQueue.remove();
            }
            int currEle = A.get(i);
            freq.put(currEle, freq.getOrDefault(currEle, 0) + 1);
            priorityQueue.add(currEle);
            queue.add(currEle);
            list.add(priorityQueue.peek());
        }

        return list;
    }
}

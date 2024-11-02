package com.learning.twentyfour.phase2.dsalgo.btree;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class PriorityQueue<T> implements Queue<T> {

    private final List<T> elements;

    private final BiPredicate<T, T> isSmaller;

    {
        elements = new ArrayList<>();
    }

    public PriorityQueue() {
        isSmaller = (ele1, ele2) -> ((Comparable) ele1).compareTo(ele2) < 0;
    }

    public PriorityQueue(Comparator<T> comparator) {
        isSmaller = (ele1, ele2) -> comparator.compare(ele1, ele2) < 0;
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Queue.super.forEach(action);
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public <T1> T1[] toArray(IntFunction<T1[]> generator) {
        return Queue.super.toArray(generator);
    }

    @Override
    public boolean add(T t) {
        return offer(t);
    }

    @Override
    public boolean remove(Object o) {
        return size() <= 0;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeIf(Predicate<? super T> filter) {
        return Queue.super.removeIf(filter);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Spliterator<T> spliterator() {
        return Queue.super.spliterator();
    }

    @Override
    public Stream<T> stream() {
        return Queue.super.stream();
    }

    @Override
    public Stream<T> parallelStream() {
        return Queue.super.parallelStream();
    }

    @Override
    public boolean offer(T t) {
        elements.add(t);
        heapify(elements.size() - 1);
        return true;
    }

    public void heapify(int i) {
        if(i==0) return;
        int parentIdx;
        T current = elements.get(i);
        if (i % 2 == 0) parentIdx = (i - 2) / 2;
        else parentIdx = (i - 1) / 2;
        T parent = elements.get(parentIdx);

        if (isSmaller.test(parent, current)) {
            elements.set(i, parent);
            elements.set(parentIdx, current);
            heapify(parentIdx);
        }
    }

    @Override
    public T remove() {
        T result = elements.getFirst();
        elements.set(0, elements.getLast());
        elements.removeLast();
        percolateDown(0);
        return result;
    }

    private void percolateDown(int i) {
        T curr = elements.get(i);
        int leftChildIdx = 2 * i + 1;
        int rightChildIdx = 2 * i + 2;

        if (isSmaller.test(curr, elements.get(leftChildIdx))) {
            elements.set(leftChildIdx, curr);
            percolateDown(leftChildIdx);
        } else if (isSmaller.test(curr, elements.get(rightChildIdx))) {
            elements.set(rightChildIdx, curr);
            percolateDown(rightChildIdx);
        }
    }

    @Override
    public T poll() {
        return remove();
    }

    @Override
    public T element() {
        return remove();
    }

    @Override
    public T peek() {
        return elements.get(0);
    }
}

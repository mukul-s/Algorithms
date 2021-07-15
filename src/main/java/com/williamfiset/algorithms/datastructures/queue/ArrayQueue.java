package com.williamfiset.algorithms.datastructures.queue;

/**
 * A lazy initialized circular queue
 * front points to index which is next for dequeue operation
 * rear points to index which is next for enqueue operation
 * @author muku
 */
@SuppressWarnings("unchecked")
public class ArrayQueue<T> implements Queue<T> {
    private int front;
    private int rear;
    private int capacity;
    private static final int DEFAULT_CAPACITY = 10;
    private T[] elements = (T[]) new Object[0];

    public ArrayQueue() {
        this.capacity = DEFAULT_CAPACITY;
    }

    public ArrayQueue(int capacity) {
        if (capacity <= 0) {
            throw new RuntimeException("Invalid capacity");
        }
        this.capacity = capacity;
    }

    @Override
    public void enqueue(T elem) {
        ensureCapacity();
        if (isFull()) {
            throw new RuntimeException("Queue Overflow");
        }
        elements[rear++] = elem;
        adjustIndex(rear);
    }

    private void ensureCapacity() {
        if (capacity == 0) {
            capacity = DEFAULT_CAPACITY;
        } else if (elements.length == 0) {
            // capacity = elements.length - 1
            elements = (T[]) new Object[capacity + 1];
        }
    }

    private boolean isFull() {
        return size() == capacity;
    }

    @Override
    // @SuppressWarnings("unchecked")
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue underflow");
        }
        T removeEle = elements[front];
        front++;
        adjustIndex(front);
        return removeEle;
    }

    @Override
    //@SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue underflow");
        }
        return elements[front];
    }

    @Override
    public int size() {
        return rear >= front ? (rear - front) : capacity - (front - rear);
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    private int adjustIndex(int index) {
        return index % capacity;
    }
}

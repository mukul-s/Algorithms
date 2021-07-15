package com.williamfiset.algorithms.datastructures.queue;

/**
 * @author liujingkun, liujkon@gmail.com
 * @param <T> the type of element held int the queue
 */
public interface Queue<T> {
  public void enqueue(T elem);

  public T dequeue();

  public T peek();

  public int size();

  public boolean isEmpty();
}

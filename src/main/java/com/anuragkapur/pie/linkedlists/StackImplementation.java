package com.anuragkapur.pie.linkedlists;

/**
 * @author anuragkapur
 */
public interface StackImplementation<E> {

    void push(E element);
    E pop();
    E peek();
    int size();

}

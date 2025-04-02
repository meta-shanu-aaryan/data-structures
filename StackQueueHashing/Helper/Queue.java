package StackQueueHashing.Helper;

public interface Queue<T> { 

    public boolean add(T obj);

    public T pop();

    public boolean isEmpty();

    public boolean isFilled();

    public T peek();
}

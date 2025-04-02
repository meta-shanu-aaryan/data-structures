package StackQueueHashing.Helper;

public interface Stack<T> {
    public boolean push(T t);

    public T pop();

    public T peek();

    // public T size();
    public boolean isEmpty();

    public boolean isFilled();
}

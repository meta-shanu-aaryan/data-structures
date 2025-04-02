package StackQueueHashing.Helper;

import java.util.ArrayList;
import java.util.List;

public class StackImplementation<T> implements Stack<T> {

    List<T> stackList = new ArrayList<>();
    int size;
    int top = -1;

    public StackImplementation(int size) {
        this.size = size;
    }

    public StackImplementation() {
        this.size = Integer.MAX_VALUE;
    }

    @Override
    public boolean push(T t) {
        if (stackList.size() < size) {
            top++;
            return stackList.add(t);
        } else {
            return false;
        }
    }

    @Override
    public T pop() {
        if (top == -1) {
            throw new AssertionError("Can't pop, stack is empty");
        } else {
            T obj = stackList.remove(top);
            top--;
            return obj;
        }
    }

    @Override
    public T peek() {
        if (top == -1) {
            throw new AssertionError("Can't peek, stack is empty");
        } else {
            return stackList.get(top);
        }
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFilled() {
        return ((top + 1) == size);
    }

}

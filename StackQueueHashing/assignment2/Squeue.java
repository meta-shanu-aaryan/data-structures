package StackQueueHashing.assignment2;

import java.util.List;

import StackQueueHashing.Helper.Queue;

public class Squeue<T> implements Queue<T> {

    private T[] t_array;
    private int front = -1;
    private int rear = -1;
    private int size;

    @SuppressWarnings("unchecked")
    public Squeue(int size) {
        t_array = (T[]) new Object[size];
        this.size = size;
    }

    @SuppressWarnings("unchecked")
    public Squeue(List<T> arrList) {
        t_array = (T[]) new Object[arrList.size()];
        this.size = arrList.size();
        int count = 0;
        for (T t : arrList) {
            t_array[count] = t;
            count++;
        }
    }

    @Override
    public boolean add(T obj) {
        try {
            if (isFilled()) {
                return false;
            }
            if (front == -1 && rear == -1) {
                front = 0;
                rear = 0;
                t_array[rear] = obj;
                return true;
            } else {
                rear = (rear + 1) % size;
                t_array[rear] = obj;
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean isEmpty() {
        if (front == -1 && rear == -1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isFilled() {
        if ((rear + 1) % size == front) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public T pop() {
        try {
            if (isEmpty()) {
                throw new AssertionError("Queue is empty, can't pop anything");
            } else {
                T val = t_array[front];
                if (front == rear) {
                    front = -1;
                    rear = -1;
                } else {
                    front = (front + 1) % size;
                }
                return val;
            }

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public T peek() {
        if (!isEmpty()) {
            return t_array[front];
        } else {
            throw new AssertionError("Can't access front, empty queue");
        }
    }

    public void display() {
        if (front == -1 && rear == -1) {
            System.out.println("nothing to display");
        } else {
            if (front < rear) {
                for (int i = front; i <= rear; i++) {
                    System.out.print(t_array[i] + "<-");
                }
                System.out.println();
            } else {
                for (int i = front; i < size; i++) {
                    System.out.print(t_array[i] + "<-");
                }

                for (int i = 0; i <= rear; i++) {
                    System.out.print(t_array[i] + "<-");
                }
                System.out.println();
            }
        }

    }

}
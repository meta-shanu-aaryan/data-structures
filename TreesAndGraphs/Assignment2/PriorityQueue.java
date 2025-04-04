package TreesAndGraphs.Assignment2;

public class PriorityQueue {
    private TValue[] queue;
    private int max = 0;

    public PriorityQueue(int size) {
        queue = new TValue[size];
    }

    public boolean insert(String name, int value) {
        if (isFull()) {
            throw new AssertionError("queue overflowed, can not insert anything");
        }
        TValue element = new TValue(value, name);
        if (max == 0) {
            queue[0] = element;
            max++;
            return true;
        } else {
            int index = max;

            while (index > 0 && element.getData() > queue[index - 1].getData()) {
                queue[index] = queue[index - 1];
                index--;
            }
            queue[index] = element;

            max++;

            return true;
        }
    }

    public boolean insert(int value) {
        if (isFull()) {
            throw new AssertionError("queue overflowed, can not insert anything");
        }

        TValue element = new TValue(value);

        if (max == 0) {
            queue[0] = element;
            max++;
            return true;
        } else {
            int index = max;

            while (index > 0 && element.getData() > queue[index - 1].getData()) {
                queue[index] = queue[index - 1];
                index--;
            }
            queue[index] = element;

            max++;

            return true;
        }

    }

    public TValue remove() {
        if (isEmpty()) {
            throw new AssertionError("Queue is empty, can't remove anything");
        }
        TValue returnable = queue[0];
        for (int i = 0; i < max - 1; i++) {
            queue[i] = queue[i + 1];
        }
        max--;
        return returnable;
    }

    public boolean isEmpty() {
        return (max == 0);
    }

    public boolean isFull() {
        return (max == queue.length);
    }

    public void display() {
        for (int i = 0; i < max; i++) {
            System.out.print(queue[i].getData() + "<-");
        }
        System.out.println();
    }
}

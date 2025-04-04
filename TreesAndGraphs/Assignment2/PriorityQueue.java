package TreesAndGraphs.Assignment2;

public class PriorityQueue {
    private TValue[] queue;
    private int max = 0;

    // contructor
    public PriorityQueue(int size) {
        queue = new TValue[size];
    }

    /**
     * Inserts element to the priorit queue
     * 
     * @param name  string name whatever name you want
     * @param value int n on the basis it is prioritize
     * @return true if inserted successfully
     * @throws AssertionError when queue is full
     */
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

    /**
     * Inserts element to the priorit queue
     * 
     * @param value int n on the basis it is prioritize
     * @return true if inserted successfully
     * @throws AssertionError when queue is full
     */
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

    /**
     * Removes element from the queue
     * 
     * @return true if removed successfully
     * @throws AssertionError if the queue is already empty
     */
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

    /**
     * Shows if a priority queue is empty or not
     * 
     * @return true if its epmty else false
     */
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

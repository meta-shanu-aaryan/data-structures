package dsaOverview.assignment1;

import dsaOverview.assignment1.helper.LinkedList;
import dsaOverview.assignment1.helper.Node;

public class SublistRotate {
    static void rotate(LinkedList ls, int l, int r, int n) {
        int index = 1;
        Node temp = ls.getHead();

        Node leftPrev = null;
        Node right = null;
        Node rotatePos = null;

        while (temp != null) {
            if (index == l - 1) {
                leftPrev = temp;
            } else if (index == (l + n - 1)) {
                rotatePos = temp;
            } else if (index == r) {
                right = temp;
            }

            temp = temp.next;
            index++;
        }

        temp = leftPrev.next;
        leftPrev.next = rotatePos.next;
        rotatePos.next = right.next;
        right.next = temp;
    }
}

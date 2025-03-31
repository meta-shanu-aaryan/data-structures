package dsaOverview.assignment1;

import java.util.HashMap;

import dsaOverview.assignment1.helper.Node;

public class LoopFinder {
    static boolean hasLoop(Node head) {
        HashMap<Node, Boolean> mpp = new HashMap<>();
        Node temp = head;
        while (temp != null) {
            if (mpp.get(temp) != null) {
                return true;
            }
            mpp.put(temp, true);
            temp = temp.getNext();
        }
        return false;
    }
}

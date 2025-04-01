package dsaOverview.assignment1;

import dsaOverview.assignment1.helper.LinkedList;
import dsaOverview.assignment1.helper.Node;

public class Main2 {
    public static void main(String[] args) {
        LinkedList ls = new LinkedList(10);
        ls.append(20);
        ls.append(30);
        ls.append(40);
        ls.append(50);
        ls.append(60);
        ls.append(70);

        Node temp = ls.getHead();
        while (temp != null) {
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
    }
}

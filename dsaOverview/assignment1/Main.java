package dsaOverview.assignment1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import dsaOverview.assignment1.helper.LinkedList;
import dsaOverview.assignment1.helper.Node;

public class Main {
    static int intScanner() {
        int n;
        while (true) {
            Scanner sc = new Scanner(System.in);
            try {
                n = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("The input should be integer values only");
            }
        }
        return n;
    }

    // static char charScanner() {
    // char n;
    // while (true) {
    // Scanner sc = new Scanner(System.in);
    // try {
    // n = sc.next();
    // break;
    // } catch (InputMismatchException e) {
    // System.out.println("The input should be integer values only");
    // }
    // }
    // return n;
    // }

    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("What do you want to do?");
                System.out.println("1.\tRotate sublist of linkedlist");
                System.out.println("2.\tTo check Loop");
                System.out.println("3.\tFind Degree of polynomial");
                int choice = Main.intScanner();

                switch (choice) {
                    case 1:
                        System.out.print("Enter the number of elements ");
                        int n = Main.intScanner();
                        System.out.println("Enter the elements of linkedlist");
                        int elemFirst = Main.intScanner();
                        LinkedList l1 = new LinkedList(elemFirst);
                        for (int i = 0; i < n - 1; i++) {
                            int elem = Main.intScanner();
                            l1.append(elem);
                        }

                        Node helperNode = l1.getHead();
                        while (helperNode != null) {
                            System.out.print(helperNode.getValue() + "->");
                            helperNode = helperNode.next;
                        }
                        System.out.println();
                        System.out.println("Enter the left position of sublist");
                        int l = Main.intScanner();
                        System.out.println("Enter the right position of sublist");
                        int r = Main.intScanner();
                        System.out.println("Enter the position to rotate");
                        int pos = Main.intScanner();

                        SublistRotate.rotate(l1, l, r, pos);

                        helperNode = l1.getHead();
                        while (helperNode != null) {
                            System.out.print(helperNode.getValue() + "->");
                            helperNode = helperNode.next;
                        }
                        break;
                    case 2:
                        List<Node> nodeList = new ArrayList<>();
                        System.out.println("Enter the number of elements");
                        n = Main.intScanner();
                        System.out.println("Enter the first element");
                        elemFirst = Main.intScanner();
                        l1 = new LinkedList(elemFirst);
                        nodeList.add(l1.getHead());
                        for (int i = 0; i < n - 2; i++) {
                            int elem = Main.intScanner();
                            l1.append(elem);
                        }
                        int tailValue = Main.intScanner();
                        System.out.println("Enter the position where you want tail to point to form loop");
                        Node tail = new Node(tailValue);
                        break;
                    case 3:
                        System.out.println("How many elements do you have ?");
                        int num = Main.intScanner();
                        System.out.println("enter number of variables: ");
                        int varNum = Main.intScanner();
                        int[][] arr = new int[num][varNum + 1];

                        for (int i = 0; i < num; i++) {
                            System.out.println("Enter coefficient: ");
                            int coeff = Main.intScanner();
                            arr[i][0] = coeff;

                            for (int j = 1; j <= varNum; j++) {
                                System.out.println("Enter the degree of variables");
                                arr[i][j] = Main.intScanner();
                            }
                        }

                        System.out.println("Highest degree of this polynomial is" + Polynomial.highestDegree(arr));
                        break;
                    default:
                        break;
                }

            } catch (Exception e) {
                // throw e;
                System.out.println(e.getMessage());
            }

        }
    }

}
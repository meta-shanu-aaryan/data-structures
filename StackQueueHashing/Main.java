package StackQueueHashing;

import java.util.InputMismatchException;
import java.util.Scanner;

import StackQueueHashing.assignment1.InfixCalculator;
import StackQueueHashing.assignment2.Squeue;

public class Main {

    static int scannerInt() {
        int n;
        while (true) {
            @SuppressWarnings("resource")
            Scanner sc = new Scanner(System.in);
            try {
                n = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Enter integer value only");
            }
        }
        return n;
    }

    static String stringScanner() {
        String s;
        while (true) {
            @SuppressWarnings("resource")
            Scanner sc = new Scanner(System.in);
            try {
                s = sc.nextLine();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return s;
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("Welcome, assignment 2 of DSA is here...");
            System.out.println("Press the key: ");
            System.out.println("1\tAssignment 1 - infix calculator");
            System.out.println("2\tAssignment 2 - Circular Queue");
            // System.out.println("3\tAssignment 3 - College Counselling mockup");

            int choice = Main.scannerInt();

            switch (choice) {
                case 1:
                    InfixCalculator ic = new InfixCalculator();
                    System.out.println("Enter the expression");
                    String expression = Main.stringScanner();
                    System.out.println("The evaluated result is: " + ic.evaluate(expression));
                    break;
                case 2:
                    System.out.println("Enter the size of queue");
                    int size = Main.scannerInt();
                    Squeue<Integer> queue = new Squeue<>(size);
                    while (true) {
                        System.out.println("1.\tAdd to queue");
                        System.out.println("2.\tRemove from queue");
                        System.out.println("3.\tDisplay queue");
                        System.out.println("4.\tCheck empty");
                        System.out.println("5.\tCheck Full");
                        System.out.println("6.\tExit...");
                        int qChoice = Main.scannerInt();
                        switch (qChoice) {
                            case 1:
                                try {
                                    System.out.println("Enter element");
                                    queue.add(Main.scannerInt());
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 2:
                                try {
                                    System.out.println(queue.pop() + " removed element");
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 3:
                                queue.display();
                                break;
                            case 4:
                                if (queue.isEmpty()) {
                                    System.out.println("It's empty");
                                } else {
                                    System.out.println("Not empty");
                                }
                                break;
                            case 5:
                                if (queue.isFilled()) {
                                    System.out.println("Queue is full");
                                } else {
                                    System.out.println("Not filled");
                                }
                                break;
                            default:
                                break;
                        }
                        if (qChoice == 6) {
                            break;
                        }
                    }
                    break;
                default:
                    break;
            }
        }

    }
}

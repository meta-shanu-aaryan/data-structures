package TreesAndGraphs.Assignment2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static int intScanner() {
        int n;
        while (true) {
            @SuppressWarnings("resource")
            Scanner sc = new Scanner(System.in);
            try {
                n = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("The input should be intefer value only");
            }
        }
        return n;
    }

    public static void main(String[] args) {
        try {
            System.out.println("Enter the size of the queue");
            int size = intScanner();
            PriorityQueue queue = new PriorityQueue(size);
            System.out.println("-----------------------");
            System.out.println("Queue is up and running");
            System.out.println("-----------------------");

            while (true) {
                System.out.println("Operations.....");
                System.out.println("1.\tInsert");
                System.out.println("2.\tRemove");
                System.out.println("3.\tprint queue");
                System.out.println("4.\tcheck empty");
                System.out.println("5.\tcheck full");
                System.out.println("6.\texit program");

                int choice = intScanner();

                switch (choice) {
                    case 1:
                        try {
                            System.out.println("Enter the number");
                            int temp = intScanner();
                            if (queue.insert(temp)) {
                                System.out.println("Inserted successfully.");
                            } else {
                                System.out.println("Something went wrong");
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());

                        }
                        break;
                    case 2:
                        try {
                            System.out.println(queue.remove().getData());
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3:
                        queue.display();
                        break;
                    case 4:
                        if (queue.isEmpty()) {
                            System.out.println("Queue is empty");
                        } else {
                            System.out.println("Not empty");
                        }
                        break;
                    case 5:
                        if (queue.isFull()) {
                            System.out.println("Queue is full");
                        } else {
                            System.out.println("Not full");
                        }
                    default:
                        break;
                }
                if (choice == 6) {
                    System.out.println("Exiting program...");
                    break;
                }
            }

        } catch (AssertionError a) {
            System.out.println(a.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

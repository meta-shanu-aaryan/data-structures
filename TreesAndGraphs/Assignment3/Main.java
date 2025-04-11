package TreesAndGraphs.Assignment3;

import java.util.InputMismatchException;
import java.util.Scanner;

import TreesAndGraphs.Assignment2.PriorityQueue;
import TreesAndGraphs.Assignment2.TValue;

public class Main {

    public static int intScanner() {
        int n;
        while (true) {
            @SuppressWarnings("resource")
            Scanner sc = new Scanner(System.in);
            try {
                n = sc.nextInt();
                if (n >= 0) {
                    break;
                } else {
                    System.out.println("Enter positive values only");
                }
            } catch (InputMismatchException e) {
                System.out.println("Only integer value is accepted");
            }
        }
        return n;
    }

    public static String stringScanner() {
        String n;
        while (true) {
            @SuppressWarnings("resource")
            Scanner sc = new Scanner(System.in);
            try {
                n = sc.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("something entered was not expected");
            }
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println("-------------------------------------------");
        System.out.println("| Welcome, let's arrange the ballers      |");
        System.out.println("| So that Virat can score lowest possible |");
        System.out.println("-------------------------------------------");

        System.out.println("Enter the bowls virat will play");
        int viratBowls = intScanner();

        System.out.println("Enter the number of bowlers");
        int noOfBowlers = intScanner();

        PriorityQueue pq = new PriorityQueue(noOfBowlers);

        for (int i = 0; i < noOfBowlers; i++) {
            System.out.println("Enter the name of bowler");
            String bowlerName = stringScanner();
            System.out.println("Enter the Bowls he has");
            int noOfBowls = intScanner();

            pq.insert(bowlerName, noOfBowls);
        }

        while (viratBowls != 0) {
            TValue bowler = pq.remove();
            if (bowler.getData() == 0) {
                System.out.println("Well, you messed up, king is always king you know...");
                break;
            }
            System.out.print(bowler.getName() + "->");
            pq.insert(bowler.getName(), bowler.getData() - 1);
            viratBowls--;
        }
        System.out.println();

        System.out.println("Here is the strategy, but you know king is the king.");
    }
}

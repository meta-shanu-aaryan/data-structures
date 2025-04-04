package ObjectsAndCollections.Assignment2;

import java.util.Scanner;

public class Main {
    private static String stringScanner() {
        String s;
        while (true) {
            @SuppressWarnings("resource")
            Scanner sc = new Scanner(System.in);
            try {
                s = sc.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Something went wrong, expected string");
            }
        }
        return s;
    }

    public static void main(String[] args) {
        StringOperator so = new StringOperator();

        while (true) {
            System.out.println("Enter the String to check its unique");
            String str = stringScanner();

            System.out.println();
            System.out.println("Unique characters in String " + str + " is " + so.uniqueCharCount(str));

            System.out.println();
            System.out.println("Enter \"exit\" to exit, or press other key to continue");

            String exitInp = stringScanner();

            if ("exit".equals(exitInp)) {
                break;
            }
        }
        System.out.println();
        System.out.println(
                "Thank you for using this program, we were caching your input for faster feedback is you wanted output for same.");
    }
}

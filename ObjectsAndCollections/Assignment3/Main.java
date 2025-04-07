package ObjectsAndCollections.Assignment3;

import java.util.Scanner;

public class Main {
    static String stringScanner() {
        String str;
        while (true) {
            @SuppressWarnings("resource")
            Scanner sc = new Scanner(System.in);
            try {
                str = sc.nextLine();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return str;
    }

    public static void main(String[] args) {
        OrgCompound oc = new OrgCompound();

        System.out.println(oc.atomicMassCalculator("CH3COOH"));
        while (true) {
            System.out.println("Enter the compund. (Should includ only C H and O)");
            String inputCompund = stringScanner();
            System.out.println("The atomic mass of " + inputCompund + " is " + oc.atomicMassCalculator(inputCompund));
        }
    }
}

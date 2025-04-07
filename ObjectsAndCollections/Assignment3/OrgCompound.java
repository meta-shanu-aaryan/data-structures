package ObjectsAndCollections.Assignment3;

import java.util.Stack;

public class OrgCompound {

    /**
     * Checks if the string is integer or not
     * 
     * @param input string argument that we want to check
     * @return true if the string is an integer else false
     */
    private boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Calculates the Atomic mass of the compound it gets, the compound should only
     * have C, H and O as atoms
     * 
     * @param compund string, that is the compound of which weight we want to
     *                calculate
     * @return totalMass of the compound, -1 if the compound is not acceptable or
     *         invalid
     */
    public int atomicMassCalculator(String compund) {
        try {
            int totalMass = 0;
            Stack<String> stack = new Stack<>();

            String[] compSplit = compund.split("");

            for (int i = 0; i < compSplit.length; i++) {
                switch (compSplit[i]) {
                    case "H":
                        stack.push("1");
                        break;
                    case "C":
                        stack.push("12");
                        break;
                    case "O":
                        stack.push("16");
                        break;
                    case "(":
                        stack.push("(");
                        break;
                    case ")":
                        int temp = 0;
                        while (stack.peek() != "(") {
                            temp += Integer.parseInt(stack.pop());
                        }
                        stack.pop();
                        stack.push(Integer.toString(temp));
                    default:
                        System.out.println(compSplit[i] + " is not a valid input");
                        break;
                }
                if (isInteger(compSplit[i])) {
                    String num = "";
                    while (i < compSplit.length && isInteger(compSplit[i])) {
                        num = num + compSplit[i];
                        i++;
                    }
                    i--;

                    stack.push(Integer.toString(Integer.parseInt(num) * Integer.parseInt(stack.pop())));
                }
            }

            while (!stack.empty()) {
                totalMass += Integer.parseInt(stack.pop());
            }

            return totalMass;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

}

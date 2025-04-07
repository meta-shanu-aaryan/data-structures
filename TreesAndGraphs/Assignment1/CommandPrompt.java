package TreesAndGraphs.Assignment1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

public class CommandPrompt {
    static Scanner sc = new Scanner(System.in);

    public static String stringScanner() {
        String s;
        while (true) {
            try {
                s = sc.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("SOmething entered is not valid");
            }
        }
        return s;
    }

    /**
     * Finds the directory recursively
     * 
     * @param s  String s to find
     * @param n  node n in which to find
     * @param st an empty stack initialized
     * @return
     */
    public Stack<Node<String>> findDirectory(String s, Node<String> n, Stack<Node<String>> st) {
        if (n.getData().equals(s)) {
            return st;
        }

        for (Node<String> nod : n.getChildren()) {
            st.add(nod);
            Stack<Node<String>> ts = findDirectory(s, nod, st);
            if (ts.peek().getData().equals(s))
                return ts;
            st.pop();
        }

        return st;
    }

    /**
     * Prints tree using recursion
     * 
     * @param nod    the node from which the tree is to print
     * @param prefix takes a blank string "" for initialization
     */
    public void printTree(Node<String> nod, String prefix) {
        if (nod == null) {
            return;
        }

        System.out.println(prefix + "\u2514\u2500\u2500\u2500" + nod.getData());

        for (Node<String> n : nod.getChildren()) {
            printTree(n, (prefix + "|    "));
        }
    }

    public static void main(String[] args) {
        CommandPrompt cp = new CommandPrompt();

        System.out.println("Enter your root directory name");
        String rootName = CommandPrompt.stringScanner();
        Tree<String> rootDirectory = new Tree<String>(rootName);
        Node<String> currentDirectory = rootDirectory.getRoot();
        ArrayList<Node<String>> dirStorage = new ArrayList<>();
        dirStorage.add(currentDirectory);
        System.out.println("------------------------------------------");
        System.out.println("| Welcome to Virtual Directory Simulator |");
        System.out.println("------------------------------------------");

        while (true) {
            System.out.print("R:");
            for (int i = 0; i < dirStorage.size(); i++) {
                System.out.print("\\" + dirStorage.get(i).getData());
            }
            System.out.print(">");
            String choice = stringScanner();
            String[] s = choice.split(" ");
            switch (s[0]) {
                case "mkdir":
                    boolean flag2 = false;
                    for (Node<String> node : currentDirectory.getChildren()) {
                        if (node.getData().equals(s[1])) {
                            flag2 = true;
                            break;
                        }
                    }
                    if (!flag2) {
                        currentDirectory.addNode(new Node<String>(s[1], currentDirectory));
                    } else {
                        System.out.println("Directory with this name already exist");
                    }
                    break;
                case "cd":
                    boolean flag = false;
                    for (Node<String> n : currentDirectory.getChildren()) {
                        if (s[1].equals(n.getData())) {
                            currentDirectory = n;
                            dirStorage.add(n);
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        System.out.println("The system cannot find the path specified.");
                    }
                    break;
                case "bk":
                    
                    currentDirectory = dirStorage.remove(dirStorage.size() - 1).getParent();
                    break;
                case "ls":
                    for (Node<String> nod : currentDirectory.getChildren()) {
                        System.out.println(nod.getDate() + "\t" + nod.getTIme() + "\t\t" + nod.getData());
                    }
                    break;
                case "find":
                    Stack<Node<String>> result = cp.findDirectory(s[1], currentDirectory, new Stack<>());
                    if (!result.empty()) {
                        System.out.print(".\\");
                        String sm = "";
                        while (!result.empty()) {
                            sm = result.pop().getData() + "\\" + sm;
                        }
                        System.out.println(sm);
                    } else {
                        System.out.println("Directory not found");
                    }
                    break;
                case "tree":
                    cp.printTree(rootDirectory.getRoot(), "");
                    break;
                case "exit":
                    // System.out.println("\u2514, \u251c, \u2500 and \u2502 unicode");
                    System.out.println("Thank you for using ");
                    break;
                default:
                    break;
            }
            if (s[0].equals("exit")) {
                break;
            }
        }
    }
}

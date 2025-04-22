package AlgorithAnalysisAndDesign2.Assignment2;

public class Main {
    public static void main(String[] args) {
        EmployeeListQuickSort emp = new EmployeeListQuickSort();

        emp.add("Shanu", 20122, 22);
        emp.add("Swayam", 20000, 21);
        emp.add("Anurag", 15000, 22);
        emp.add("Ram", 23000, 23);
        emp.add("Mohan", 20122, 21);
        emp.add("Soham", 19999, 24);

        System.out.println("Before sorting");
        emp.printList();

        emp.quickSort();

        System.out.println("\nAfter Sorting");
        emp.printList();
    }
}

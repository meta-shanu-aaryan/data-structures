package AlgorithmanalysisAndDesign1.assignment2;

public class Main {
    public static void main(String[] args) {
        LinkedList<Employee> l1 = new LinkedList<>(new Employee("Shanu", 18000, 22));

        l1.add(new Employee("Swayam", 22000, 21));

        l1.add(new Employee("Brook", 70000, 400));

        Node<Employee> temp = l1.head;
        while (temp != null) {
            System.out.println(temp.value.toString());
            temp = temp.next;
        }

        temp = l1.sort();
        while (temp != null) {
            System.out.println(temp.value.toString());
            temp = temp.next;
        }

    }
}

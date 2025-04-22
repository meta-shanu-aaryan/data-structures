package AlgorithAnalysisAndDesign2.Assignment2;

public class EmployeeNode {
    String name;
    int salary, age;
    EmployeeNode next;

    EmployeeNode(String name, int salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.next = null;
    }
}
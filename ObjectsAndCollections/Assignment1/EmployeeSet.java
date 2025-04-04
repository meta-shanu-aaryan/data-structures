package ObjectsAndCollections.Assignment1;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class EmployeeSet {
    Set<Employee> employeeSet = new HashSet<>();

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public boolean addEmployee(Employee employee) {
        return employeeSet.add(employee);
    }

    public static void main(String[] args) {
        EmployeeSet es = new EmployeeSet();

        Employee e1 = new Employee("Suresh", "Don't know");
        Employee e2 = e1;
        Employee e3 = new Employee("Mahesh", "Hoga kuchh");
        Employee e4 = new Employee("subhash", "Don't have time to enter address");
        Employee e5 = new Employee("Mukesh", "Hello there");
        Employee e6 = new Employee("Suresh", "abcdefg");
        Employee e7 = new Employee("Suresh", "qwerty");

        Collections.addAll(es.employeeSet, e1, e2, e3, e4, e5, e6, e7);

        for (Employee emp : es.getEmployeeSet()) {
            System.out.println(emp.toString());
        }
    }
}

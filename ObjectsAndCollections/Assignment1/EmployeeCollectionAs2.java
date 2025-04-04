package ObjectsAndCollections.Assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeCollectionAs2 {
    private List<Employee> empList = new ArrayList<>();

    public List<Employee> getEmpList() {
        return empList;
    }

    public boolean addEmployee(Employee emp) {
        return empList.add(emp);
    }

    public boolean addEmployee(String name, String address) {
        return empList.add(new Employee(name, address));
    }

    public void sortByName() {
        Collections.sort(empList, new SortByName());
    }

    public static void main(String[] args) {
        EmployeeCollectionAs2 ec = new EmployeeCollectionAs2();

        Employee e1 = new Employee("Suresh", "Don't know");
        Employee e2 = e1;
        Employee e3 = new Employee("Mahesh", "Hoga kuchh");
        Employee e4 = new Employee("subhash", "Don't have time to enter address");
        Employee e5 = new Employee("Mukesh", "Hello there");
        Employee e6 = new Employee("Durgesh", "abcdefg");
        Employee e7 = new Employee("Bhim", "qwerty");

        Collections.addAll(ec.empList, e1, e2, e3, e4, e5, e6, e7);

        System.out.println("Before Sorting is done");
        for (Employee emp : ec.getEmpList()) {
            System.out.println(emp.toString());
        }

        ec.sortByName();

        System.out.println();
        System.out.println("After sorting is done");
        for (Employee emp : ec.getEmpList()) {
            System.out.println(emp.toString());
        }
    }
}

class SortByName implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getName().compareTo(o2.getName());
    }

}

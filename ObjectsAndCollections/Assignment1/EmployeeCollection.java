package ObjectsAndCollections.Assignment1;

import java.util.ArrayList;
import java.util.List;

public class EmployeeCollection {
    List<Employee> employees = new ArrayList<>();

    public List<Employee> getEmployees() {
        return employees;
    }

    public boolean addEmployee(String Name, String Address) {
        return employees.add(new Employee(Name, Address));
    }

    public boolean addEmployee(Employee emp) {
        return employees.add(emp);
    }

    // public void sortEmployee() {
    // Collections.sort(employees); //Causing problem here because it's thinking
    // Employee as generic type
    // }
}

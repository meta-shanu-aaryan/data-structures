package AlgorithmanalysisAndDesign1.assignment2;

public class Employee implements Comparable<Employee> {
    private String name;
    private int salary;
    private int age;

    public Employee(String name, int salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", salary=" + salary + ", age=" + age + "]";
    }

    public int getAge() {
        return age;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + salary;
        result = prime * result + age;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (salary != other.salary)
            return false;
        if (age != other.age)
            return false;
        return true;
    }

    @Override
    public int compareTo(Employee o) {
        if (this.salary > o.salary) {
            return 1;
        } else if (this.salary == o.salary && this.age < o.age) {
            return 1;
        } else {
            return -1;
        }
    }

}

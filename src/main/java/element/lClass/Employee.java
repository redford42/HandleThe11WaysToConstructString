package element.lClass;

import java.util.Objects;
import java.util.Random;

/**
 * @author Hanz
 * @date 2019/7/31
 */
public class Employee implements Comparable<Employee>,Cloneable {

    private static int nextId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getId() == employee.getId() &&
                Double.compare(employee.getSalary(), getSalary()) == 0 &&
                Objects.equals(getName(), employee.getName());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSalary());
    }

    private int id;
    private String name = "";
    private double salary;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    static {
        Random generator = new Random();
        nextId = generator.nextInt(10000);
    }

    {
        id = nextId;
        nextId++;
    }


    public Employee() {
        this.name = "";
        this.salary = 0;
    }

    public Employee(double salary) {
        this.salary = salary;
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }


    @Override
    public int compareTo(Employee other) {
        return Double.compare(salary, other.salary);
    }
}


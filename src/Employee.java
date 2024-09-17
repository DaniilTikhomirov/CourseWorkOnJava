import java.util.Objects;

public class Employee {
    private String fullName;
    private int department;
    private int salary;
    private int id;

    public static int counter = 1;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && salary == employee.salary && id == employee.id && Objects.equals(fullName, employee.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, department, salary, id);
    }

    public Employee(String fullName, int department, int salary){
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
        this.id = counter++;

    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName){
        this.fullName = fullName;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getDepartment() {
        return department;
    }

    public int getId(){
        return id;
    }
    public void setDepartment(int department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }


    @Override
    public String toString(){
        return "full name -> " + fullName + " department -> "
                + department + " salary -> "
                + salary + " id -> " + id;
    }
}

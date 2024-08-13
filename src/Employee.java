public class Employee {
    private String fullName;
    private int department;
    private int salary;
    private int id;

    public static int counter = 1;

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

    public boolean equals(Employee employee){
        return fullName.equals(employee.getFullName()) &&
                department == employee.getDepartment() &&
                salary == employee.getSalary() &&
                id == employee.getId();
    }

    public int hashCode(){
        return java.util.Objects.hashCode(fullName) +
                java.util.Objects.hashCode(department) +
                java.util.Objects.hashCode(salary) +
                java.util.Objects.hashCode(id);

    }

    public String toString(){
        return "full name -> " + fullName + " department -> "
                + department + " salary -> "
                + salary + " id -> " + id;
    }
}

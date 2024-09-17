import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    public static Employee[] fullEmployee() {
        Employee[] employees = new  Employee[10];

        for (int i = 0; i < employees.length; i++) {
            Employee Jhon = new Employee(String.format("Jhon%s", i), i % 5 + 1, 12_000 * (i + 1));
            employees[i] = Jhon;
        }
        return employees;
    }

    public static void printInfoEmployee(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }

    public static int sumSalary(Employee[] employees){
        int sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum;
    }

    public static int maxSalary(Employee[] employees){
        int max = Integer.MIN_VALUE;
        int salary;
        for (Employee employee : employees) {
            salary = employee.getSalary();
            if (salary > max){
                max = salary;
            }
        }
        return max;
    }

    public static int minSalary(Employee[] employees){
        int min = Integer.MAX_VALUE;
        int salary;
        for (Employee employee : employees){
            salary = employee.getSalary();
            if (salary < min){
                min = salary;
            }
        }
        return min;
    }

    public static float averageSalary(Employee[] employees){
        int sum = sumSalary(employees);
        return (float) sum / employees.length;
    }

    public static void printFullNameInList(Employee[] employees){
        for (Employee employee : employees){
            System.out.println(employee.getFullName());
        }
    }

    public static void indexSalary(Employee employee, double percent){
        int salary = employee.getSalary();
        employee.setSalary((int) (salary + salary * percent));
    }

    public static void indexationSalary(Employee[] employees, double percent){
        for (int i = 0; i < employees.length; i++) {
            indexSalary(employees[i], percent);
        }
    }

    public static Employee[] getEmployeesForDepartment(Employee[] employees, int department){
        return Arrays.stream(employees).
                filter(employee -> employee.getDepartment() == department).toArray(Employee[]::new);
    }

    public static int minSalaryForDepartment(Employee[] employees, int department){
        Employee[] employee = getEmployeesForDepartment(employees, department);
        return minSalary(employee);
    }

    public static int maxSalaryForDepartment(Employee[] employees, int department){
        Employee[] employee = getEmployeesForDepartment(employees, department);
        return maxSalary(employee);
    }

    public static int sumSalaryForDepartment(Employee[] employees, int department){
        Employee[] employee = getEmployeesForDepartment(employees, department);
        return sumSalary(employee);
    }

    public static double averageSalaryForDepartment(Employee[] employees, int department){
        Employee[] employee = getEmployeesForDepartment(employees, department);
        return (double) sumSalary(employee) / employee.length;
    }

    public static void indexationSalaryForDepartment(Employee[] employees, int department, double percent){
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == department) {
                indexSalary(employees[i], percent);
            }
        }
    }

    public static void printInfoForDepartment(Employee[] employees, int department){
        Employee[] employees1 = getEmployeesForDepartment(employees, department);
        for (Employee employee : employees1) {
            System.out.println("full name -> " + employee.getFullName() +  " salary -> "
                    + employee.getSalary() + " id -> " + employee.getId());
        }

    }



    public static void main(String[] args) {
        Employee[] employees = fullEmployee();
        printInfoEmployee(employees);
        System.out.printf("sum -> %s max -> %s min -> %s average -> %s\n",
                sumSalary(employees), maxSalary(employees), minSalary(employees), averageSalary(employees));
        printFullNameInList(employees);

        indexationSalary(employees, 0.5);
        printInfoEmployee(employees);
        System.out.println("-------");
        printInfoForDepartment(employees, 2);
        indexationSalaryForDepartment(employees, 2, 0.5);
        printInfoForDepartment(employees, 2);
        System.out.println(averageSalaryForDepartment(employees, 2));
        System.out.println(sumSalaryForDepartment(employees, 2));
        System.out.println(minSalaryForDepartment(employees, 2));
        System.out.println(maxSalaryForDepartment(employees, 2));
        System.out.println("-------");


    }
}
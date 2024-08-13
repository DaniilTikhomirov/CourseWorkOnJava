public class Main {

    public static Employee[] fullEmployee() {
        Employee[] employees = new  Employee[10];

        for (int i = 0; i < employees.length; i++) {
            Employee Jhon = new Employee(String.format("Jhon%s", i), i, 12_000 * (i + 1));
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

    public static void main(String[] args) {
        Employee[] employees = fullEmployee();
        printInfoEmployee(employees);
        System.out.printf("sum -> %s max -> %s min -> %s average -> %s\n",
                sumSalary(employees), maxSalary(employees), minSalary(employees), averageSalary(employees));
        printFullNameInList(employees);

    }
}
import java.util.Arrays;

public class EmployeeBook {
    private Employee[] employees = new Employee[10];

    public boolean addEmployee(Employee e) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = e;
                return true;
            }
        }
        return false;
    }

    public boolean removeEmployee(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id) {
                employees[i] = null;
                return true;
            }
        }
        return false;
    }

    public Employee searchEmployee(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getId() == id) {
                return employees[i];
            }
        }
        return null;
    }

    public Employee[] getEmployees() {
        return employees;
    }


    public void printInfoEmployee() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i].toString());
            }
        }
    }

    public int sumSalary() {
        int sum = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public int sumSalary(Employee[] employees) {
        int sum = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public int maxSalary() {
        int max = Integer.MIN_VALUE;
        int salary;
        for (Employee employee : employees) {
            if (employee != null) {
                salary = employee.getSalary();
                if (salary > max) {
                    max = salary;
                }
            }
        }
        return max;
    }

    public int maxSalary(Employee[] employees) {
        int max = Integer.MIN_VALUE;
        int salary;
        for (Employee employee : employees) {
            if (employee != null) {
                salary = employee.getSalary();
                if (salary > max) {
                    max = salary;
                }
            }
        }
        return max;
    }

    public int minSalary() {
        int min = Integer.MAX_VALUE;
        int salary;
        for (Employee employee : employees) {
            if (employee != null) {
                salary = employee.getSalary();
                if (salary < min) {
                    min = salary;
                }
            }
        }
        return min;
    }

    public int minSalary(Employee[] employees) {
        int min = Integer.MAX_VALUE;
        int salary;
        for (Employee employee : employees) {
            if (employee != null) {
                salary = employee.getSalary();
                if (salary < min) {
                    min = salary;
                }
            }
        }
        return min;
    }

    public float averageSalary() {
        int sum = sumSalary();
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                count += 1;
            }
        }
        return (float) sum / count;
    }

    public float averageSalary(Employee[] employees) {
        int sum = sumSalary();
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                count += 1;
            }
        }
        return (float) sum / count;
    }

    public void printFullNameInList() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i].getFullName());
            }
        }
    }

    public void indexSalary(Employee employee, double percent) {
        int salary = employee.getSalary();
        employee.setSalary((int) (salary + salary * percent));
    }

    public void indexationSalary(double percent) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                indexSalary(employees[i], percent);
            }
        }
    }

    public Employee[] getEmployeesForDepartment(int department) {
        return Arrays.stream(employees).
                filter(employee -> employee != null && employee.getDepartment() == department).toArray(Employee[]::new);
    }

    public int minSalaryForDepartment(int department) {
        Employee[] employee = getEmployeesForDepartment(department);
        return minSalary(employee);
    }

    public int maxSalaryForDepartment(int department) {
        Employee[] employee = getEmployeesForDepartment(department);
        return maxSalary(employee);
    }

    public int sumSalaryForDepartment(int department) {
        Employee[] employee = getEmployeesForDepartment(department);
        return sumSalary(employee);
    }

    public double averageSalaryForDepartment(int department) {
        Employee[] employee = getEmployeesForDepartment(department);
        return (double) sumSalary(employee) / employee.length;
    }

    public void indexationSalaryForDepartment(int department, double percent) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                indexSalary(employees[i], percent);
            }
        }
    }

    public void printInfoForDepartment(int department) {
        Employee[] employees1 = getEmployeesForDepartment(department);
        for (Employee employee : employees1) {
            System.out.println("full name -> " + employee.getFullName() + " salary -> "
                    + employee.getSalary() + " id -> " + employee.getId());
        }

    }
}

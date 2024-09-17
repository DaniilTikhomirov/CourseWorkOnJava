public class Main {

    public static void fullEmployee(EmployeeBook book) {
        for (int i = 0; i < book.getEmployees().length; i++) {
            Employee Jhon = new Employee(String.format("Jhon%s", i), i % 5 + 1, 12_000 * (i + 1));
            book.addEmployee(Jhon);
        }
    }

    public static void main(String[] args) {
        EmployeeBook book = new EmployeeBook();
        fullEmployee(book);
        System.out.println("-------------");
        book.printInfoEmployee();
        book.indexationSalary(0.5);
        book.printInfoEmployee();
        System.out.println("-------------");
        book.removeEmployee(2);
        book.printInfoEmployee();
        book.addEmployee(new Employee("Sergey", 3, 35_000));
        book.printInfoEmployee();
        System.out.println("-------------");
        System.out.println(book.searchEmployee(11));
        System.out.println(book.sumSalary());
        System.out.println(book.maxSalary());
        System.out.println(book.minSalary());
        System.out.println(book.averageSalary());
        System.out.println("-------------");
        book.printFullNameInList();
        System.out.println("-------------");
        System.out.println(book.maxSalaryForDepartment(2));
        System.out.println(book.minSalaryForDepartment(2));
        System.out.println(book.averageSalaryForDepartment(2));
        System.out.println(book.sumSalaryForDepartment(2));
        book.printInfoForDepartment(2);
        book.indexationSalaryForDepartment(2, 0.5);
        book.printInfoForDepartment(2);

    }
}
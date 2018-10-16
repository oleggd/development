class TestNew {
    public static void main(String[] args) {
        Employee [] employees = MockEmployeesGenerator.generate(5);
        Employee employee = new Employee();
        employee.id = 10;
        employee.firstName = "Ivan";
        employee.lastName = "Vetrov";
        employee.salary = 550;

        EmployeeService employeeService = new EmployeeService(employees);
        employeeService.print();
        //---
        System.out.println("Salary of all employees :" + employeeService.calculateSalary());
        System.out.println("-----------------------------------------------------------------");
        //---
        System.out.println("Remove employee 2:");
        employeeService.removeEmployee(2);
        employeeService.print();
        //---
        System.out.println("Add employee :");
        employeeService.addEmployee( employee);
        employeeService.print();
        //---
        System.out.println("Sort by last name:" );
        employees =  employeeService.sortByLastName(employeeService.employees);
        employeeService.print();
    }
}
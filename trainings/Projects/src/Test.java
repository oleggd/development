class Test {
    public static void main(String[] args) {
        Employee [] employees = MockEmployeesGenerator.generate(4);
        Employee employee = ;
        EmployeeService employeeService = new EmployeeService(employees);
        employeeService.print();
        //---
        System.out.println("Salary of all employees :" + employeeService.calculateSalary());
        //---
        employeeService.removeEmployee(2);
        employeeService.print();
        //---
        employeeService.addEmployee();
        employeeService.print();
        //System.out.println("Salary of all employees :" + employeeService.calculateSalary());
    }
}
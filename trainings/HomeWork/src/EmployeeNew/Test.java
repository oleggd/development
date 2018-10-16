class TestNew {
    public static void main(String[] args) {
        EmployeeNew [] employees = MockEmployeesGeneratorNew.generate(5);
        EmployeeNew employee = new Developer();
        employee.id = 10;
        employee.name = "Sidorova";
        employee.age = 30;
        employee.gender = 'F';
        employee.salary = 1550;

        EmployeeServiceNew employeeService = new EmployeeServiceNew(employees);
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
        System.out.println("Sort by name:" );
        employees =  employeeService.sortByName(employeeService.employees);
        employeeService.print();
    }
}
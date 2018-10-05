public class EmployeeService {
    Employee[] employees;

    EmployeeService (Employee [] pEmployees) {
        employees = pEmployees;
    }
    void setEmployee(Employee[] newEmployees) {
        employees = newEmployees;
    }

    void  print(){
        for (int i=0; i < employees.length; i++ ) {
            System.out.println("Employee id[" + employees[i].id + "], name : " + employees[i].firstName + " " + employees[i].lastName +
                    "; salary : " + employees[i].salary);
            System.out.println("-----------------------------------------------------------------");
        }
    }

    double calculateSalary(){
        double salarySum = 0;

        for (int i=0; i < employees.length; i++ ) {
            salarySum += employees[i].salary;
        }
        //System.out.println("Employee id[" + employees[i].id + "], name : " + employees[i].firstName + " " + employees[i].lastName +
        //        "; salary : " + employees[i].salary);
        //System.out.println("Employees salary sum :" + salarySum);
        //System.out.println("-----------------------------------------------------------------");
        return salarySum;
    }

    void removeEmployee(int id) {
        Employee[] lEmployees = new Employee[employees.length-1];
        int index= 0;
        for (int i=0; i < employees.length; i++ ) {
            if (employees[i].id != id ) {
                lEmployees[index] = employees[i];
                index++;
            }
        }
        employees = lEmployees;
    }

    void addEmployee(Employee employee){
        Employee[] lEmployees = new Employee[employees.length+1];

        for (int i=0; i < employees.length; i++ ) {
            lEmployees[i] = new Employee();
            lEmployees[i] = employees[i];
        }
        lEmployees[lEmployees.length+1] = new Employee();
        lEmployees[lEmployees.length] = employee;

        setEmployee(lEmployees);
    }

//    Employee[]  sortByLastName(){
//
//    }

//    Employee[]  sortByLastFirstName(){
//
//    }
}

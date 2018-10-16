public class EmployeeServiceNew {
    EmployeeNew[] employees;

    EmployeeServiceNew(EmployeeNew[] pEmployees) {
        employees = pEmployees;
    }

    void setEmployee(EmployeeNew[] newEmployees) {
        employees = newEmployees;
    }

    void print() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] instanceof Manager) {
                Manager lManager = (Manager) employees[i];
                System.out.println("Manger id[" + lManager.id + "], name : " + lManager.name + ", age : " + lManager.age +
                        ", salary : " + lManager.salary + ", gender : " + lManager.gender);
            } else if (employees[i] instanceof Developer) {
                Developer lDeveloper = (Developer) employees[i];
                System.out.println("Developer id[" + lDeveloper.id + "], name : " + lDeveloper.name + ", age : " + lDeveloper.age +
                        ", salary : " + lDeveloper.salary + ", gender : " + lDeveloper.gender + ", fixed bugs : " + lDeveloper.fixedBugs);
            } else if (employees[i] instanceof Cleaner) {
                Cleaner lCleaner = (Cleaner) employees[i];
                System.out.println("Cleaner id[" + lCleaner.id + "], name : " + lCleaner.name + ", age : " + lCleaner.age +
                        ", salary : " + lCleaner.salary + ", gender : " + lCleaner.gender + ", rate : " + lCleaner.rate + ", worked days : " + lCleaner.workedDays);
            }
            System.out.println("-----------------------------------------------------------------");
        }
    }

    double calculateSalary() {
        double salarySum = 0;

        for (int i = 0; i < employees.length; i++) {
            salarySum += employees[i].salary;
        }
        System.out.println("");
        return salarySum;
    }

    void removeEmployee(int id) {

        int index = 0;

        for (int i = 0; i < employees.length; i++) {
            if (employees[i].id != id) {
                index++;
            }
        }

        EmployeeNew[] lEmployees = new EmployeeNew[index];
        index = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].id != id) {
                lEmployees[index] = employees[i];
                index++;
            }
        }
        employees = lEmployees;
    }

    void addEmployee(EmployeeNew NewEmployee) {

        EmployeeNew[] lEmployees = new EmployeeNew[employees.length + 1];

        for (int i = 0; i < employees.length; i++) {
            lEmployees[i] = new EmployeeNew();
            lEmployees[i] = employees[i];
        }
        lEmployees[lEmployees.length - 1] = new EmployeeNew();
        lEmployees[lEmployees.length - 1] = NewEmployee;

        setEmployee(lEmployees);
    }


    EmployeeNew[] sortByName(EmployeeNew[] inEmployees) {

        EmployeeNew[] lEmployees = new EmployeeNew[0];
        EmployeeNew lEmployee;

        for (int i = 0; i < inEmployees.length; i++) {
            for (int j = i + 1; j < inEmployees.length; j++) {

                if (inEmployees[i].name.compareTo(inEmployees[j].name) > 0) {
                    lEmployee = inEmployees[i];
                    inEmployees[i] = inEmployees[j];
                    inEmployees[j] = lEmployee;
                }

            }
        }
        return inEmployees;

    }

}

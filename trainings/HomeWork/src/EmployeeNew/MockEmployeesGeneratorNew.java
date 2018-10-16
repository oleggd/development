import java.util.Random;

public class MockEmployeesGeneratorNew {

    static EmployeeNew[] generate(int size) {
        EmployeeNew[] randomEmployees = new EmployeeNew[size];
        String[] employeeType   = {"Manager","Developer","Cleaner"};
        String[] firstNameArray = {"Oleg", "Sergey", "Ivan", "Anna", "Petr"};
        String[] lastNameArray  = {"Ivanov", "Petrov", "Stecenko", "Procenko","Fedorov","Krivoruchko"};

        Random random = new Random();
        //System.out.println(randomEmployees[0]);
        //System.out.println(randomEmployees.length);

        for (int i =0; i < randomEmployees.length; i++) {
            int index = random.nextInt(3);
            if ( employeeType[index] == "Manager" ) {
                Manager lManager = new Manager();
                lManager.id = i + 1;
                lManager.name = lastNameArray[i] ;
                lManager.age = i * 20;
                lManager.gender = random.nextInt(2) == 1 ? 'M' : 'F';
                lManager.salary = random.nextInt(i+1*1000);
                randomEmployees[i] = lManager;

            } else if (employeeType[index] == "Developer" ) {
                Developer lDeveloper = new Developer();
                lDeveloper.id = i + 1;
                lDeveloper.name = lastNameArray[i] ;
                lDeveloper.age = i * 20;
                lDeveloper.gender = random.nextInt(2) == 1 ? 'M' : 'F';
                lDeveloper.salary = random.nextInt(i+1*1000);
                lDeveloper.fixedBugs = random.nextInt(i+1*100);
                randomEmployees[i] = lDeveloper;

            } else if ( employeeType[index] == "Cleaner" ) {
                Cleaner lCleaner = new Cleaner();
                lCleaner.id = i + 1;
                lCleaner.name = lastNameArray[i] ;
                lCleaner.age = i * 20;
                lCleaner.gender = random.nextInt(2) == 1 ? 'M' : 'F';
                lCleaner.salary = random.nextInt(i+1*1000);
                lCleaner.rate = random.nextInt(i+1*8);
                lCleaner.workedDays = random.nextInt(10);
                randomEmployees[i] = lCleaner;
            }

            //System.out.println(randomEmployees[i].name);
        }

        return randomEmployees;
    }
}

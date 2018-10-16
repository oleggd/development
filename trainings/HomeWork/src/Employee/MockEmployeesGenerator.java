import java.util.Random;

public class MockEmployeesGenerator {
    static Employee[] generate(int size) {
        Employee[] randomEmployees = new Employee[size];

        String[] firstNameArray = {"Oleg", "Sergey", "Ivan", "Anna"};
        String[] lastNameArray  = {"Ivanov", "Petrov", "Stecenko", "Procenko"};

        Random random = new Random();
        //System.out.println(randomEmployees[0]);
        //System.out.println(randomEmployees.length);

        for (int i =0; i < randomEmployees.length; i++) {
            int salary = random.nextInt(i+1*1000);
            randomEmployees[i] = new Employee();
            randomEmployees[i].id = i;
            randomEmployees[i].firstName = firstNameArray[(int)Math.floor(i%4)];
            randomEmployees[i].lastName = lastNameArray[(int)Math.floor(i%4)];
            randomEmployees[i].salary = salary;

        }

        return randomEmployees;
    }
}

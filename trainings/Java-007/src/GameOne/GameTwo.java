import java.util.Random;
import java.util.Scanner;

class GameTwo {
    public static void main (String[] args) {
        Random random = new Random();
        
        int value = random.nextInt(100);
        int previousValue = 0;
       
        System.out.println("Guess my number");
        
        Scanner scanner = new Scanner (System.in);
        while (true) {
            
            System.out.println(value);
            
            String str = scanner.nextLine();
            
            if (str.equals("Bigger")) {
                System.out.println("My value is greater.");
                value = value + (int)Math.floor(value) / 2;
                previousValue = value;

            } else if (str.equals("Smaller")) {
                System.out.println("My value is smaller.");
                value = value - (int)Math.floor((value) / 2);
            } else if (str.equals("OK")) {
                System.out.println("You got it.");
                break;
            }
            System.out.println(value);
            
        }
    }
}
import java.util.Random;
import java.util.Scanner;

class GameTwo {
    public static void main (String[] args) {
        Random random = new Random();
        
        int upperValue = 100;
        int lowerValue = 0;
        int value      = random.nextInt(upperValue);
       
        System.out.println("Guess my number - from 0 to 100" );
        
        Scanner scanner = new Scanner (System.in);
        while (true) {
            
            System.out.println(value);
            String str = scanner.nextLine();
            
            if (str.equals(">")) {
                System.out.println("My value is greater.");
                lowerValue = value;
                value += (int)Math.floor((upperValue - lowerValue) / 2);                

            } else if (str.equals("<")) {
                System.out.println("My value is smaller.");
                upperValue = value;
                value = value - (int)Math.floor((upperValue - lowerValue) / 2);

            } else if (str.equals("OK")) {
                System.out.println("You got it.");
                break;
            } else if (str.equals("Exit")) {
              return; 
            }
            System.out.println(value);
            
        }
    }
}
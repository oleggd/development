import java.util.Random;
import java.util.Scanner;

class GameOne {
    public static void main (String[] args) {
        Random random = new Random();
        
        int value = random.nextInt(100);
        //System.out.println(value);
        
        value = random.nextInt(100);
        System.out.println("Guess my number");
        
        Scanner scanner = new Scanner (System.in);
        while (true) {
            String str = scanner.nextLine();
            int value_str = Integer.parseInt(str);
            //System.out.println(str);
            //System.out.println(value_str);
            
            if (value > value_str) {
                System.out.println("My value is greater.");
            } else if (value < value_str) {
                System.out.println("My value is smaller.");
            } else if (value == value_str) {
                System.out.println("You got it.");
                break;
            } 
        }
    }
}
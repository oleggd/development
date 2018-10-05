import java.util.Scanner;

public class PrimitiveArrays {
    

    public static void main(String[] args) {
		char [] charArray   = {'a','b','c'};
		String outputString;
        int [] intArray     = {1,4,6,7,8,2,10,23,7,0};
        byte [] byteArray   = {9,1,6,7,8,2,10,23,5,0};
        int searchValue;
        
        Scanner scanner = new Scanner (System.in);
        //--
        outputString = charArrayToString(charArray);
		System.out.println("char to string :" + outputString);
		
        //--
        System.out.println("Enter number to search in array from start");
        String str = scanner.nextLine();
        searchValue = Integer.parseInt(str);
        System.out.println("Position value "+ searchValue + " in array from start: " + intInIntArrayStart(intArray,searchValue));
        //--
        System.out.println("Enter number to search in array from end");
        str = scanner.nextLine();
        searchValue = Integer.parseInt(str);
        System.out.println("Position value "+ searchValue + " in array from end: " + intInIntArrayEnd(intArray,searchValue));
        //--
        System.out.println("Enter number to search mod in array");
        str = scanner.nextLine();
        searchValue = Integer.parseInt(str);
        System.out.println("Position value "+ searchValue + " in array from end: " + intModValue(intArray,searchValue));
        //--
        System.out.println("Sort array :");
        printArray(intArray);
        System.out.println("Sorted array : ");
        printArray(sortArray(intArray));
        // --
        System.out.println("Are there any duplicates in array :");
        printArrayByte(byteArray);
        System.out.println("Result : " + duplicatedBytesArray(byteArray));
        
        
    }
	
    static void printArray(int[] array){
		for(int i = 0; i < array.length; i++){
			//int value = array[i];
			//System.out.print(value + ',');
			 System.out.print(array[i] + ", ");
		}
        System.out.println(' ');
	}
    static void printArrayByte(byte[] array){
		for(int i = 0; i < array.length; i++){
			//int value = array[i];
			//System.out.print(value + ',');
			 System.out.print(array[i] + ", ");
		}
        System.out.println(' ');
	}
	static String charArrayToString (char[] array){
        
        String localString = "";
		for(int i = 0; i < array.length; i++){
			localString = localString + array[i];
		}
        return localString;
	}
	
    static int intInIntArrayStart (int[] array, int value){
        
		for(int i = 0; i < array.length; i++){
			if ( array[i] == value) {
                return i;
            }
		}
        return -1;
	}
    static int intInIntArrayEnd (int[] array, int value){
        
		for(int i = array.length -1; i > 0; i--){
			if ( array[i] == value) {
                return i;
            }
		}
        return -1;
	}
    static int intModValue (int[] array, int value){
        
		for(int i = 0; i < array.length; i++){
			if ( array[i]%value == 0  ) {
                System.out.println(array[i]);
            }
		}
        return -1;
	}
    
    static int[] sortArray (int[] array){
        
        int a = 0;
        
		for(int i = 0; i < array.length; i++){
            for (int j = i+1; j < array.length; j++){
                if ( array[i] > array[j] ) {
                   a = array[i];
                   array[i] = array[j];
                   array[j] = a;
                }
            }
		}
        return array;
	}
    static boolean duplicatedBytesArray (byte[] array){
        
        byte a = 0;
        
		for(int i = 0; i < array.length; i++){
            for (int j = i+1; j < array.length; j++){
                if ( array[i]  == array[j] ) {
                   return true;
                }
            }
		}
        return false;
	}
    
    static boolean compareByteArrays (byte[] array1, byte array2){
        
        byte a = 0;
        
		for(int i = 0; i < array.length; i++){
            for (int j = i+1; j < array.length; j++){
                if ( array[i]  == array[j] ) {
                   return true;
                }
            }
		}
        return false;
	}
	/*static int[] generateArray (int n){
		int [] array = new int[n];
		for(int i = 0; i < n; i++){
			array[i] = i + 1;
		}
		
		return array;
	}*/
	
	
}
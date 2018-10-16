import java.util.Scanner;

public class PrimitiveArrays {


    public static void main(String[] args) {
        char[] charArray = {'a', 'b', 'c'};
        String outputString;
        int[] intArray = {1, 4, 6, 7, 8, 2, 10, 23, 7, 0};
        byte[] byteArray = {9, 1, 6, 7, 8, 2, 10, 23, 5, 0, 6};
        int searchValue;
        String[] stringArray = {"AABBCC", "AAABBBCCC", "AAAABBBBCCCC", "BBCCAA", "BBBCCCAAA", "CCAABB", "CCCAAABBB", "CCCCAAAABBBB"};
        String searchString;
        String[][] multiArray = {
                {"1-1", "1-2", "1-3", "1-4", "1-5"},
                {"2-1", "2-2", "2-3", "2-4", "2-5"},
                {"3-1", "3-2", "3-3", "3-4", "3-5"}
        };
        int[][] intMultiArray = {
                {65, 66, 67, 68, 69},
                {70, 71, 72, 73, 74},
                {75, 76, 77, 78, 79}
        };

        char [] charArray1 = {'A','B','C','D','E','F','G','H','D','E','G','K'};
        char [] charArray2 = {'D','E','G'};

        String separator = "--------------------------------------------------------------";

        Scanner scanner = new Scanner(System.in);
        //-- task 1
        outputString = charArrayToString(charArray);
        System.out.println("char to string :" + outputString);

        //-- task 2
        System.out.println(separator);
        System.out.println("Enter number to search in array from start");
        printArray(intArray);
        System.out.println("Enter number to search in array from start");
        String str = scanner.nextLine();
        searchValue = Integer.parseInt(str);
        System.out.println("Position value " + searchValue + " in array from start: " + intInIntArrayStart(intArray, searchValue));
        //-- task 3
        System.out.println(separator);
        System.out.println("Enter number to search in array from end");
        str = scanner.nextLine();
        searchValue = Integer.parseInt(str);
        System.out.println("Position value " + searchValue + " in array from end: " + intInIntArrayEnd(intArray, searchValue));
        //-- task 5
        System.out.println(separator);
        System.out.println("Enter number to search 0 mod in array");
        str = scanner.nextLine();
        System.out.println("------");
        searchValue = Integer.parseInt(str);
        System.out.println("Values in array  for which  mod(" + searchValue + ")  = 0  : ");
        intModValue(intArray, searchValue);
        //-- task 6
        System.out.println(separator);
        System.out.println("Sort array :");
        printArray(intArray);
        System.out.println("------");
        System.out.println("Sorted array : ");
        printArray(sortArray(intArray));
        // -- task 7
        System.out.println(separator);
        System.out.println("Are there any duplicates in array :");
        printByteArray(byteArray);
        System.out.println("Result : " + duplicatedBytesArray(byteArray));
        // -- task 8
        System.out.println(separator);
        System.out.println("Enter string for filtering array :");
        printStringArray(stringArray);
        System.out.println("------");
        searchString = scanner.nextLine();
        System.out.println("Array with element contained search value :");
        String [] resultArray = filterArray(stringArray,searchString);
        printStringArray(filterArray(stringArray, searchString));
        // -- task 9
        System.out.println(separator);
        printStringMultiArray(multiArray);
        // -- task 10
        System.out.println(separator);
        printCharMultiArray(intArrayToCharArray(intMultiArray));
        // -- task 11
        System.out.println(separator);
        printIntMultiArray(intNegativeArray(intMultiArray));
        // -- task 12
        System.out.println(separator);
        System.out.println("Array charArray2 : ");
        printCharArray(charArray2);
        System.out.println("Array charArray1 : ");
        printCharArray(charArray1);
        System.out.println("Array charArray2 in charArray1 : " + isArrayInArray(charArray1,charArray2));
    }

    //-------------------------------------------------------------------------  
    static void printArray(int[] array){
        for(int i : array){
           System.out.print(i + ", ");
        }
        System.out.println(' ');
    }
    //-------------------------------------------------------------------------
    static void printByteArray(byte[] array){
        for(byte element : array) {
           System.out.print(element + ", ");
        }
        System.out.println(' ');
    }
    //-------------------------------------------------------------------------
    static void printStringArray(String[] array){
        
        for(String element : array) {
           System.out.print(element + ", ");
        }
        System.out.println(' ');
    }
    //-------------------------------------------------------------------------
    static void printCharArray(char[] array){
        for(char element : array) {
            System.out.print(element + ", ");
        }
        System.out.println(' ');
    }
    //-------------------------------------------------------------------------    
    static void printStringMultiArray(String[][] array){
        System.out.println("printStringMultiArray");

        for(String [] row: array) {
            for (String element : row) {
                System.out.print(element + ", ");
            }
            System.out.println(' ');
        }
        System.out.println(' ');
    }
    //-------------------------------------------------------------------------
    static void printCharMultiArray(char[][] array){
        System.out.println("printCharMultiArray");

        for(char [] row: array) {
            for (char element : row) {
                System.out.print(element + ", ");
            }
            System.out.println(' ');
        }
        System.out.println(' ');
    }
    //-------------------------------------------------------------------------
    static void printIntMultiArray(int[][] array){
        System.out.println("printIntMultiArray");

        for(int [] row: array) {
            for (int element : row) {
                System.out.print(element + ", ");
            }
            System.out.println(' ');
        }
        System.out.println(' ');
    }
    //-------------------------------------------------------------------------
    static String charArrayToString (char[] array){
          
        String localString = "";
        for(char element : array){
           localString = localString + element;
        }
        return localString;
    }
    //-------------------------------------------------------------------------  
    static int intInIntArrayStart (int[] array, int value){
        
        for(int i = 0; i < array.length; i++){
            if ( array[i] == value) {
                return i;
            }
        }
        return -1;
    }
    //-------------------------------------------------------------------------
    static int intInIntArrayEnd (int[] array, int value){
        
        for(int i = array.length -1; i > 0; i--){
            if ( array[i] == value) {
                return array.length-i;
            }
        }
        return -1;
    }
    //-------------------------------------------------------------------------
    static int intModValue (int[] array, int value){
        
        for(int i = 0; i < array.length; i++){
            if ( array[i]%value == 0  ) {
                System.out.println(array[i]);
            }
        }
        return -1;
    }
    //-------------------------------------------------------------------------    
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
    //-------------------------------------------------------------------------    
    static boolean duplicatedBytesArray (byte[] array){
        
        for(int i = 0; i < array.length; i++){
            for (int j = i+1; j < array.length; j++){
                return (array[i]  == array[j]);
                }
        }
        return false;
    }
    //-------------------------------------------------------------------------    
    static String [] filterArray (String[] array, String filterValue){
        
        int j = 0;
        
        for(int i = 0; i < array.length; i++){
            if ( array[i].contains(filterValue) ) {
                j ++;
            }
        }
        String [] filteredArray = new String[j];
        j = 0;
        for(int i = 0; i < array.length; i++){
            if ( array[i].contains(filterValue) ) {
                filteredArray[j] = array[i];
                j ++;
            }
        }
        
        return filteredArray;
    }
    //-------------------------------------------------------------------------    
    static char [][] intArrayToCharArray (int[][] array){
        
        char[][] charArray = new char[array.length][];

        for(int i = 0; i < array.length; i++){
            charArray[i] = new char [array[i].length];
            for(int j = 0; j < array[i].length; j++){
                charArray[i][j] = (char)array[i][j];
            }
        }
        return charArray;
    }
    //-------------------------------------------------------------------------
    /*static int [][] intNegativeArray (int[][] array){

        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                array[i][j] = -array[i][j];
            }
        }
        return array;
    } */

    static int [][] intNegativeArray (int[][] array) {

        for(int[] row : array) {
            for(int value : row) {
                value = -value;
            }
        }
        return array;
    }
    //-------------------------------------------------------------------------
    static boolean isArrayInArray (char[] array1, char[] array2) {

        boolean result = false;

        for(int i = 0; i < array1.length; i++){
            int ii = i;
            for(int j = 0; j < array2.length; j++){
                if ( array1[ii] == array2[j] ) {
                     result = true;
                     ii++;
                } else {
                     result = false;
                     j = array2.length;
                }
            }
            if (result) {
                return result;
            }
        }
        return result;
    } 
}
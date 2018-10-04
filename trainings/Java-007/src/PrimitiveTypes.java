class PrimitiveTypes {

    public static void main (String[] args) {
    byte b = 100;  //declare & init
    int i;       //declare 
    i = 100000;    //init
    i = 100;       // reassign
    long l = 111111111111L;
        float f = 10.5f;
        double d = 155.5;
        
        char c = 'A';
        String s = "I am String !!!";
        boolean bool1 = true;
        boolean bool2 = f > d;
        
        System.out.println("l : " +l );
        System.out.println("f : " +f );
        System.out.println("d : " +d);
        System.out.println("c : " +c);
    System.out.println("s : " +s);
        System.out.println("bool1 : " +bool1);
        System.out.println("bool2 : " +bool2);
        
    System.out.println("i value = " +i);
    String str = "Hello world";
    System.out.println(str);

    }

}
class PrimitiveMethods {
    public static void main (String[] args) {
        byte b1 = 100;
        byte b2 = 50;
        
        byte b3 = 30;
        byte b4 = (byte)(b1 + b2);
        System.out.println(b3);
        System.out.println(b4);
        int letterCode = 65;
        int lettersCount = 'Z' - 'A' + 1;
        
        for (int i = 0; i < lettersCount; i++) {
            char c = (char)letterCode;
            System.out.print(c);
            letterCode++;
        }
        System.out.println();
        
        for (char c ='A'; c<='Z'; c++) {
            System.out.print(c);
        }
        System.out.println();
    }        
}


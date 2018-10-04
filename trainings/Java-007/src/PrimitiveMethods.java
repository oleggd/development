class PrimitiveMethods {
  
  public static void main(String[] args) {
    printHello();
    // logic
    
    printCustomHello("Tolik");
    // logic
    printCustomHello("John", 5);
    
    int a = 10;
    int b = 30;
    int result = sum(10, 30);
	boolean logic_result;
	
    printCustomHello("sum " + result);
    result = max(5,2);
    printCustomHello("max from 2 value: " + result);
    result = max(5,2,8);
    printCustomHello("max from 3 value: " + result);
	result = max(5,2,8,25,-111);
    printCustomHello("max from 5 value: " + result);
	result = factorial(5);
    printCustomHello("factorial value: " + result);
	logic_result = isYearHigh(2000);
    printCustomHello("is year "+2000+" high : " + logic_result);
	result = fibonachi(10);
    printCustomHello("fibonachi for 10 : " + result);
	
  } 
    
  static int sum (int a, int b){ // a = 10, b = 30
    int result = a + b;
    return result;
  }
    
  static void printCustomHello(String name, int count) {
    for(int i = 0; i < count; i++){
      printCustomHello(name);
    }
  }
  
  static void printHello(){
    String helloMessage = "Hello";
    System.out.println(helloMessage);
  }
  
  static void printCustomHello(String name) {
    System.out.println("Hello " + name);
  }
  
  static int max (int a, int b) {
    int result = 0;
    if ( a > b) {
      result = a;
    } else {
      result = b;
    }
    return result;
  }

  static int max (int a, int b, int z) {
    int result = 0;
    if ( a > b) {
      if ( a > z ) {
          result = a;
      } else {
          result = z;
      };
    } else if (b > z) {
      result = b;
    } else {
    result = z;
    }

    return result;
   }
   
   static int max (int a, int b, int d, int e, int f) {
    int result = 0;
    if ( a > result) {
      result = a;
	}
	if ( b > result) {
      result = b;
	}
	if ( d > result) {
      result = d;
	}
	if ( e > result) {
      result = e;
	}
	if ( f > result) {
      result = f;
	}
	
    return result;
   }
   
   static int factorial (int n) {
	   int result = 1;
	   
	   for (int i = 1; i <= n; i++) {
	       result = result * i;
	   }
	   return result;
   }
   
   static boolean isYearHigh (int year) {
	   boolean result;
	   
	   if (year%4 == 0 && year%400 !=0 ) {
		   result = true;
	   } else {
	       result = false;
	   }
	   return result;
   }
   
   static int fibonachi (int n) {
	   int result = 0;
	   
	   for (int i = 1; i <= n; i++) {
	       result = result + i;
	   }
	   return result;
   }
}
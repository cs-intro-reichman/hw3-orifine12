// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {  	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3 = 5
	    System.out.println(minus(7,2));  // 7 - 2 = 5
   		System.out.println(minus(2,7));  // 2 - 7 = -5
 		System.out.println(times(3,4));  // 3 * 4 = 12
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2 = 10
   		System.out.println(pow(5,3));      // 5^3 = 125
   		System.out.println(pow(3,5));      // 3^5 = 243
   		System.out.println(div(12,3));   // 12 / 3 = 4   
   		System.out.println(div(5,5));    // 5 / 5  = 1
   		System.out.println(div(25,7));   // 25 / 7 = 3
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  
	// Returns x1 + x2
	public static int plus(int x1, int x2)
	 {
		 int result = x1;

    if (x2 > 0) {
        while (x2 > 0) {
            result++;   // move result right
            x2--;       // move x2 toward 0
        }
    } else if (x2 < 0) {
        while (x2 < 0) {
            result--;   // move result left
            x2++;       // move x2 toward 0
        }
    } 
    return result;
	 }

	// Returns x1 - x2
	public static int minus(int x1, int x2) 
	{
		int min = x1;
		if (x2 > 0)
		{
		    for(int i=0; i<x2; i++)
			 {
		 	  min --;
		     }
	    }
		else 
		if (x2 < 0)
		{
           for (int i = x2; i < 0; i ++)
		   {
			min ++;
		   }
		}
			
		return min;
	}

	// Returns x1 * x2 
	
    public static int times(int x1, int x2) {
	  // quick zero check
    if (x1 == 0 || x2 == 0) {
        return 0;
    }

    int a = x1;
    int b = x2;
    boolean negative = false;

    // make a positive, track sign
    if (a < 0) {
        negative = !negative;
        a = minus(0, a);    // a = |a|
    }

    // make b positive, track sign
    if (b < 0) {
        negative = !negative;
        b = minus(0, b);    // b = |b|
    }

    int total = 0;
    for (int i = 0; i < b; i++) {
        total = plus(total, a);
    }

    // apply final sign
    if (negative) {
        total = minus(0, total);   // make negative
    }

    return total;	
	 }

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int power = 1;
		for (int i=0 ;i<n ;i++)
		{
			power = times(power,x);
		}
		return power;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) 
	{
       if (x2 == 0) {
        return 0;
    }

    // 0 divided by anything is 0
    if (x1 == 0) {
        return 0;
    }

    int a = x1;
    int b = x2;
    boolean negative = false;

    // handle sign of a (dividend)
    if (a < 0) {
        negative = !negative;
        a = minus(0, a);   // a = |a|
    }
	// handle sign of b (divisor)
    if (b < 0) {
        negative = !negative;
        b = minus(0, b);   
    }

    int up = a;
    int down = b;
    int count = 0;


    while (up >= down) {
        up = minus(up, down);
        count++;          
    }

    if (negative) {
        count = minus(0, count);
    }

    return count;
    }

// Returns x1 % x2
    public static int mod(int x1, int x2)
	 {
	int up = x1;
	  int down = x2;
	  if (down <= 0)
	   {
	   return 0;
	   }
	  while (up >= down)
	   {
		up = minus (up, down);
	   }
	   return up;
     }



// Returns the integer part of sqrt(x) 
    public static int sqrt(int x) 
	    {
		 if (x < 0) {  
        return 0;    
    }
    if (x == 0) {
        return 0;
    }
    int count = 0;
    while (times(count, count) <= x) {
        count++;
    }

    count--;    // step back one

    return count;
		}
}
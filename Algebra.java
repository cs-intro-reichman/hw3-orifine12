// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {  	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  
	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int sum = 0;
		for(int i=0; i<=x2; i++) {
			sum = x1++;
		}
		return sum;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int min = 0;
		for(int i=0; i<=x2; i++) {
			min = x1--;
		}
		return min;
	}

	// Returns x1 * x2 
	public static int times(int x1, int x2) {
		int total=0;
	for (int i=0; i<x2; i++)
	{
		total = plus(total,x1);
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
	public static int div(int x1, int x2) {
    int count = 0;
    int rest = x1;

    for (int i = 0; rest >= x2; i++) {
        rest = minus(rest, x2);
        count++;
    }
    return count;
}

// Returns x1 % x2
public static int mod(int x1, int x2)
	 {
    int count = 0;
    int rest = x1;

    for (int i = 0; rest >= x2; i++) 
	{
        rest = minus(rest, x2);
        count++;
    }

    return rest;
}
	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
	int guess = 0;
	int square = 0;

	while (square <= x) {
		guess = plus(guess, 1);
		square = times(guess, guess);
	}
	return minus(guess, 1);
	}	  	  
}
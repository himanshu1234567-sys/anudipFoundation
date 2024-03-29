package Assdignment_16;

import java.util.Scanner;

public class ExceptionHandlingConcept {
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		
	    
	    try{
	    	System.out.println("Enter the 2 numbers : ");
			int a = sc.nextInt();
		    int b = sc.nextInt();
		    divideNumbers(a, b);
		    
	    } catch (ArithmeticException e) {
            System.out.println("DivideByZeroException caught");
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input. Please enter integers for a and b.");
        } finally {
            System.out.println("Inside finally block");
            
        }
		
	}
	
	private static void divideNumbers(int a, int b) {
        try {
            int quotient = a / b;
            System.out.println("The quotient of " + a + "/" + b + " = " + quotient);
        } catch (ArithmeticException e) {
            System.out.println("DivideByZeroException caught");
        }
    }
}

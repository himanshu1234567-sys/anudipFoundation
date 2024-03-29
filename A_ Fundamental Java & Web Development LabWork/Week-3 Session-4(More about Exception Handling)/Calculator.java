package ExcptionHanding;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		boolean startAgain = true;

		while (startAgain) {
			int a, b, c;
			try {

				System.out.println("Enter first numbers: ");
				while(true) {
					try {
				    a = sc.nextInt();
				    break;
					}catch(InputMismatchException in) {
						System.out.println("Invalid input");
						sc.next();
					}
				}
				
				System.out.println("Enter your operator :");
				b = sc.next().charAt(0);

				System.out.println("Enter second operator :");
				while(true) {
					try {
				    c = sc.nextInt();
				    break;
					}catch(InputMismatchException in) {
						System.out.println("Invalid input");
						sc.next();
					}
				}

				double res;

				switch (b) {
				case '+':
					res = a + c;
					System.out.println("Output " + res);
					break;
				case '-':
					res = a - c;
					System.out.println("Output " + res);
					break;
				case '*':
					res = a * c;
					System.out.println("Output " + res);
					break;
				case '/':
					if (c == 0) {
						System.out.println("Number cannot be divisible by zero");
					} else {
						res = a / c;
						System.out.println("Output " + res);
					}
					break;
				default:
					System.out.println("Input Invalid");
               }
			
				System.out.println("Perform another? (y/n)");
                char ch;
                while (true) {
                    try {
                        ch = sc.next().charAt(0);
                        break;
                    } catch (InputMismatchException inp) {
                        System.out.println("Error: Invalid input");
                        sc.next(); 
                    }
                }

                startAgain = (ch == 'y');

            } catch (Exception ex) {
                System.out.println("Oops! Something went wrong.");
                sc.next(); 
            }
        }

        sc.close(); 
    }
}


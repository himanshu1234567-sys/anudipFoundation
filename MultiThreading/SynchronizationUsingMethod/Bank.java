package synchronizationeg_method;

import java.util.Scanner;

public class Bank {

	// volatile prohibit modification/change data
	private volatile double balance = 40000.0;
	private double depositAmt;

	public synchronized void deposit() {
        System.out.println("Current balance before deposit :" + balance);
		Scanner s = new Scanner(System.in);
		System.out.println("Enter amount to deposit: ");
        int amt = s.nextInt();
        
        balance = balance + amt;
        
        System.out.println("Balance after deposit = " + balance);
	}

	public synchronized void withdraw() {
		System.out.println("Current balance before withdraw :" + balance);
		Scanner s = new Scanner(System.in);
		System.out.println("Enter amount to deposit: ");
        int amt = s.nextInt();
        
        balance = balance - amt;
        
        System.out.println("Balance after withdraw = " + balance);
	    
	}

}

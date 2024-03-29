package synchronization_block;

import java.util.Scanner;

public class WifeThread extends Thread{
	
private Bank bank;
	
	Scanner s = new Scanner(System.in);
	
	public WifeThread(Bank bank) {
		this.bank = bank;
		start();
	}

	public void run() {
		
		synchronized(bank) {
			System.out.println("------------------------------------------------------------------------");
			System.out.println("Original Balance :" + bank.currentBalance());
			
			System.out.println("Enter amount to withdraw: ");
			int amt = s.nextInt();
			
			bank.deposit(amt);
			System.out.println("Balance after withdraw: " +  bank.currentBalance()) ;
			
			
		}
		
	}
}
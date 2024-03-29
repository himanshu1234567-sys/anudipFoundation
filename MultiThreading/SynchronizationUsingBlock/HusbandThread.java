package synchronization_block;

import java.util.Scanner;

public class HusbandThread extends Thread{
	
	private Bank bank;
	
	Scanner s = new Scanner(System.in);
	
	public HusbandThread(Bank bank) {
		this.bank = bank;
		start();
	}

	public void run() {
		
		synchronized(bank) {
			System.out.println("Original Balance :" + bank.currentBalance());
			
			System.out.println("Enter amount to deposit: ");
			int amt = s.nextInt();
			
			bank.deposit(amt);
			System.out.println("Balance after deposition: " +  bank.currentBalance()) ;
			
			
		}
		
	}
}

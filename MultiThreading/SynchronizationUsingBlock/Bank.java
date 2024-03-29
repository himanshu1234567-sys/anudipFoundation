package synchronization_block;

public class Bank {

	int balance = 40000;
	
	public void deposit(int amount) {
		balance = balance + amount;
	}
	
	public void withdraw(int amount) {
		balance = balance - amount;
	}
	
	public double currentBalance() {
		return balance;
	}
}

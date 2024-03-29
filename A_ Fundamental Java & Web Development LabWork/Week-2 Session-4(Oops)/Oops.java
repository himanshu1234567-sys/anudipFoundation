Q)  

● Create a BankAccount class that 
● BankAccount class should have three fields accoundHolderName (String), bankName(String), accountBalance(double).
● Create a constructor that takes account holder’s name, bankname and initial balance.
● Add three methods to the interface - getBalance(), deposit() and withdraw(). 
● Implement all three methods. 
● In the main method create three bank accounts withdifferent account holders names and ICICI, HDFC and SBI as banknames. 
● Deposit and withdraw money for each account. Displaytheaccount


package oops;

interface Bank
{
	void getBalance();
	void deposit(double d); 
	void withdraw(double d);
}


class BankAccount implements Bank {
	String accountHolderName , bankName; 
	double accountBalance;
	

	public BankAccount(String accountHolderName, String bankName, double accountBalance) {
		this.accountHolderName = accountHolderName;
		this.bankName = bankName;
		this.accountBalance = accountBalance;
	}

	 public void getBalance()
	{
		 
		System.out.println(accountBalance);
    }
	 
	
	public void deposit(double d) 
	{
		accountBalance+=d;
	}
	
	public void  withdraw(double w)
	{
	
		if(w<=accountBalance)
		{
		   accountBalance=accountBalance-w;
		}
		else
		{
			System.out.println("Insufficient Amount left in your Account");
		}
		
		
	}
	
	
	public String toString() {
		return "BankAccount [accountHolderName=" + accountHolderName + ", bankName=" + bankName + ", accountBalance="
				+ accountBalance + "]";
	}

	public static void main(String[] args) {
		
		BankAccount ba1=new BankAccount("Divya","ICICI",1000);
		BankAccount ba2=new BankAccount("Shanu","HDFC",1000);
		BankAccount ba3=new BankAccount("Pranjal","SBI",1000);
		ba1.deposit(2000);
		ba1.withdraw(1000);
		ba2.deposit(5000);
		ba2.withdraw(2000);
		ba3.deposit(4000);
		ba3.withdraw(2000);
		System.out.println(ba1);
		System.out.println(ba2);
		System.out.println(ba3);
		}

}
package synchronizationeg_method;

public class HusbandThread extends Thread{

	private Bank bank;
	
	public HusbandThread(Bank bank) {
		this.bank=bank;
		start();
	}

	@Override
	public void run() {
		bank.deposit();
	}

}

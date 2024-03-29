package synchronizationeg_method;

public class WifeThread extends Thread{

	private Bank bank;
	
	public WifeThread(Bank bank) {
		this.bank=bank;
		start();
	}

	@Override
	public void run() {
		bank.withdraw();
	}

}

package synchronizationeg_method;

public class TestSynchronization {

	public static void main(String[] args) {
		Bank b = new Bank();
		new HusbandThread(b);
		new WifeThread(b);
	}
	
}

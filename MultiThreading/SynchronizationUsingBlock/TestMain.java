package synchronization_block;

public class TestMain {

	public static void main(String[] args) {
		
		Bank b = new Bank();
		new HusbandThread(b);
		new WifeThread(b);
	}
}

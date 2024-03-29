package lab;

public class AverageThread extends Thread {

	private AverageSquareBoth avgsqrt;
	
	public AverageThread(AverageSquareBoth avgsqrt) {
		this.avgsqrt = avgsqrt;
		start();
	}

    public void run() {
		AverageSquareBoth.average();
	}
}

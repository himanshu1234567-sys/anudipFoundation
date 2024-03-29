package lab;

public class SquareThread extends Thread{

private AverageSquareBoth avgsqrt;
	
	public SquareThread(AverageSquareBoth avgsqrt) {
		this.avgsqrt = avgsqrt;
		start();
	}

    public void run() {
		AverageSquareBoth.square();
	}
}

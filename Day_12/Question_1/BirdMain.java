package Assignment_12;

public class BirdMain {

	public static void main(String[] args) {
		
		Bird b1 = new Parrot();
		b1.fly();
		Parrot p = (Parrot) b1;
		p.sing();
	}

}

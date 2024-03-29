
/* Create two thread.one thread is finding the average of the 
 first 10 numbers and another thread is printing the square of 
 the number stored in array arr={1,20,50,15,30} and make sure both
 threads can execute one by one.  */

package lab;

public class MainThread {
	
	public static void main(String[] args) {
		AverageSquareBoth asb = new AverageSquareBoth();
		new AverageThread(asb);
		new SquareThread(asb);
	}
}

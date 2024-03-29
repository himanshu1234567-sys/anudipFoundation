
/* Create three threads in Java to simulate a race among them. 
Each thread should have a name and display its name and current 
iteration number. Use Thread.sleep() to introduce a delay between
iterations. Also, set different priorities for the threads */

package lab;

public class ThreadRace implements Runnable{

	String name;
	
	// constructor  
	public ThreadRace(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		
		for(int i = 0; i <= 10; i++) {
			System.out.println( name +" iteration " + i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public static void main(String args[]) {
		
		//creating thread objects 
		Thread t1 = new Thread(new ThreadRace("Thread-1"));
		Thread t2 = new Thread(new ThreadRace("Thread-2"));
		Thread t3 = new Thread(new ThreadRace("Thread-3"));
		
		//setting priority
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.NORM_PRIORITY);
		t3.setPriority(Thread.MIN_PRIORITY);
		
		//starting thread
		t1.start();
		t2.start();
		t3.start();
	}
	
}
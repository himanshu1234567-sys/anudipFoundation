package lab;

public class AverageSquareBoth {

	// to calculate average of first 10 numbers
	public synchronized static void average() {
		int sum = 0;   
		int c = 10;

		for (int i = 1; i <= c; i++) {
			sum += i;

		}
		
		double avg = (double)sum / c;
		System.out.println("Average of first 10 numbers: " + avg);
	}

	// To calculate square of given array elements
	public synchronized static void square() {

		int arr[] = { 1, 20, 50, 15, 30 };

		System.out.print("Square of given numbers: ");
		for (int num : arr) {
			System.out.print(num * num + " ");
		}
		System.out.println();
	}

}

package _2DMatrix;

import java.util.Scanner;

public class _2DArray_DiagonalsPrint {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of rows & coloumns: ");
		int n = sc.nextInt();
		int rows = sc.nextInt();
		int cols = sc.nextInt()
;
		int mat[][] = new int[rows][cols];
		
		// input 
		System.out.println("Enter the array elements :" + " ");
		for(int i =0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				mat[i][j] = sc.nextInt();
			}
		}
		
		// Output 
		for(int i =0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				System.out.print(mat[i][j] + " "); 
			}
			System.out.println();
		}
		
		// Diagonal 1
		System.out.println("Diagonal 1: " + " ");
		for(int i =0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				if(i==j) {
					System.out.print(mat[i][j] + " ");
				}
			}
		}
		
		System.out.println();
		// Diagonal 2
		System.out.println("Diagonal 2: " + " ");
		for(int i=0; i<rows; i++) {
			for(int j=n-1; j>=0; j--) {
				if(i+j==n-1) {
					System.out.print(mat[i][j] + " ");
				}
			}
		}
		
		
	}

}

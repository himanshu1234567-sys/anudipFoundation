package _2DMatrix;

import java.util.Scanner;

public class _2DArray_XTraversal {
    public static void main(String[] args) {
        
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.println("Enter the number of rows & columns: ");
    	
	       int raw  = sc.nextInt();
	       int col  = sc.nextInt();
	       
	     int[][] twoDArray = new int[raw][col]; 
	     
	     
	     System.out.println("Enter the matrix elements: ");
	   //Input
	     for(int i = 0; i<raw ;i++) {
	    	 for ( int j=0; j<col ;j++) {
	    		 twoDArray[i][j]  = sc.nextInt();
	    	 }
	     }
        int numRows = twoDArray.length;
        int numCols = twoDArray[0].length;

        // Traverse the 2D array in an N pattern
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (i == j || j == numCols - 1 - i) {
                    System.out.print(twoDArray[i][j] + " ");
                } else {
                    System.out.print("  "); // Print spaces for non-N elements
                }
            }
            System.out.println(); // Move to the next row
        }
    }
}

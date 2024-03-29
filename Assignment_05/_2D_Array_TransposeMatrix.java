package _2DMatrix;

import java.util.Scanner;

public class _2D_Array_TransposeMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        int n = scanner.nextInt(); 
        int m = scanner.nextInt(); 

        int[][] matrix = new int[n][m];

        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Transpose the matrix and print the result
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(); 
        }

        scanner.close();
    }
}

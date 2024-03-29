package _2DMatrix;

public class _2DArray_DiamondTraversal {
    public static void main(String[] args) {
        int n = 3; // Size of the matrix
        int middleMan = (n - 1) / 2;

        int mat[][] = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // Print elements in a diamond pattern
        for (int i = middleMan, j = n - 1; i >= 0 && j >= middleMan; i--, j--) {
            System.out.print(mat[i][j] + " ");
        }

        for (int i = 1, j = middleMan - 1; i <= middleMan && j >= 0; i++, j--) {
            System.out.print(mat[i][j] + " ");
        }

        for (int i = middleMan + 1, j = 1; i < n && j <= middleMan; i++, j++) {
            System.out.print(mat[i][j] + " ");
        }

        for (int i = n - 2, j = middleMan + 1; i >= middleMan && j < n - 2; i--, j++) {
            System.out.print(mat[i][j] + " ");
        }
    }
}

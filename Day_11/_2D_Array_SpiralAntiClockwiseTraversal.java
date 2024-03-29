package _2DMatrix;

public class _2D_Array_SpiralAntiClockwiseTraversal {

	public static void main(String[] args) {
		
		int[][] mat = {{1,2,3,4}, 
				       {5,6,7,8},
				       {9,10,11,12}};
	    
		int n = mat.length;
		int m = mat[0].length;
		
		SpiralTraverse(mat, n, m);
	}
	
	public static void SpiralTraverse(int[][] mat, int n, int m) {
		
		int top = 0;
		int bottom = n-1;
		
		int left = 0;
		int right = m-1;
		
		int count = 0;
		int k = m*n;
		
		while(count<k) {
		
		for(int i = top; i<=bottom && count<k; i++) {
			System.out.print(mat[i][left] + " ");
			count++;
		}
		
		left++;     // left become 1 from 0
		
		for(int i = left; i<=right && count<k; i++) {
			System.out.print(mat[bottom][i] + " ");
			count++;
		}
		
		bottom--;
		
		for(int i = bottom; i>=top && count<k; i--) {
			System.out.print(mat[i][right] + " ");
			count++;
		}
		
		right--;
		
		for(int i = right; i>=left && count<k; i--) {
			System.out.print(mat[top][i] + " ");
			count++;
		}
		
		top++;
	}
		
		
	}

}

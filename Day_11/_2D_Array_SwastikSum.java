package _2DMatrix;

public class _2D_Array_SwastikSum {
	
	public static void main(String[] args) {
		
		
		int row = 3;
		int col = 5;
		
		int mat[][] = {{1,2,3,4,5}, 
				       {6,7,8,9,10}, 
				       {11,12,13,14,15}
				      };
		
		int sum1 = 0;
		int sum2 = 0;
		
		// sum1
		
		for( int j =0 ; j <= (col-1)/2 ; j++ ){
			sum1 = sum1 + mat[row-1][j] ;
			
		}
		
		
		for( int i = row-2 ; i>=0  ; i-- ){
			sum1 = sum1 + mat[i][(col-1)/2 ] ;
			
		}
		
		for( int j =((col-1)/2 )+1  ;j < col  ; j++){
			sum1 = sum1 + mat[0][j] ;
		}
		
	    System.out.println(sum1);
	   
	    
	    
	    // sum2
	   
	    for( int i =0 ; i <= (row-1)/2 ; i++ ){
			sum2 = sum2 + mat[i][0] ;
		}
		
		for( int j = 1 ; j<col ; j++){
			sum2 = sum2 + mat[(row-1)/2 ][j] ;
		}
		
		for( int i =((row-1)/2 )+1 ;i < row  ; i++){
			sum2 = sum2 + mat[i][col-1] ;
		}
		
		System.out.println(sum2);
		
		int difference = sum1 - sum2;
		int ans = Math.abs(difference);
		
		System.out.println(ans);
	   
	}

}

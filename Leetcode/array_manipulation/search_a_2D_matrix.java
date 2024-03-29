package array_manipulation;

public class search_a_2D_matrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr={1,2,3,4,5,6,7};
		int[][] matrix=new int[5][5];
		int m=1;
		for(int i=0;i<=4;i++){
			for(int j=0;j<=4;j++){
				matrix[i][j]=m;
				
				m++;
			}
		}
		
		boolean result=search_matrix(matrix, 26);
		
		System.out.println(result);
	}
	
	
	public static boolean search_matrix(int[][] matrix,int key){
		int a=0;
		int b=matrix.length-1;
		while(a<=b){
			int mid=(a+b)/2;
			if(key<matrix[mid][0]){
					b=mid-1;
			}else if(key>matrix[mid][0]){
					a=mid+1;
					System.out.println("a value "+a);
			}else
					return true;
		}
		// when out the loop, a is the next row of the valid row(the row we wish to perform binary search)
		
		//these are two situations that when the process ends, one is finish the first dimension, the 
		//other is somewhere in the middle.
		if(a==matrix.length  ||matrix[a][0]>key)
			a--;
		

		return binary_search(matrix[a],key,0, matrix[a].length-1);
	}
	
	
	public static boolean binary_search(int[] arr,int key, int a, int b){
		int mid=(a+b)/2;
		
//		System.out.println("len is "+len+" n is "+n);
		
		if(a>b){
			return false;
		}
		else if (key==arr[mid]) {
			return true;
		}
		
		else if(key<=arr[mid]){
			return binary_search(arr, key, a, mid-1);
		}
		else{
			return binary_search(arr, key, mid+1, b);
		}	
		
	}

}

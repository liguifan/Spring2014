package array_manipulation;

public class array_in_loop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int[] arr={1,2,3,4,5};
		
		for(int i=0;i<=4;i++){
			System.out.println(arr[i]);
		}
		int j=arr.length-1;
		while(j>=0){
			System.out.println(arr[j--]);
		}
		System.out.println("++ "+j);
		// when <=, ++ is in the front, the array will be out of boundary. j++ safe.
		// when get out the second time, it will be out of boundary.
	}

}

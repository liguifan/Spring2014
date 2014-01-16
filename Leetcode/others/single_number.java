package others;

public class single_number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={1,2,5,2,3,1,5};
		System.out.println(singleNumber(a));
	}
	
	
	public static int singleNumber(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        int result=0;
		for(int x:A){
			result=result^x;
			
		}
		return result;
		
    }

}

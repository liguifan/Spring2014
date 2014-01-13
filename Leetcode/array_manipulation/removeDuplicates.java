package array_manipulation;

public class removeDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int[] a={1,2,2,2,2,2,2,3,4};
			System.out.println(removeDuplicates(a));
	}
	
	
	public static int removeDuplicates(int[] A){
		 if(A.length==0)
	            return 0;
	        if(A.length==1)
	            return 1;
	        int len=0;
			int i=1;
	        while(i<A.length){
	        	if(A[len]==A[i]){
	        		i++;
	        	}
	        	else
	        	{
	        		A[len+1]=A[i];
	        			len++;
	        			i++;
	        	}
		}
	        
	        return len+1;
	}
	

}

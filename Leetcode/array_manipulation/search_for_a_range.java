package array_manipulation;

import java.util.ArrayList;

public class search_for_a_range {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={1,2,3,4,4,4,5};
		int[] r=new int[2];
		r=search(a, 4);
		System.out.println(r[0]+" and "+r[1]);
	}
	
	
	
	public static int[] search(int[] A, int target){
		ArrayList<Integer> pocket=new ArrayList<Integer>();
		int low=0;
		int high=A.length-1;
		int[] range={-1,-1};
		while(low<=high){
			int mid=(low+high)/2;
			if(A[mid]==target){
				if(mid==0 || A[mid-1]<target){
					range[0]=mid;
					low=mid;
					high=A.length-1;
					
				}
				
				if(mid==A.length-1 || A[mid+1]>target){
					range[1]=mid;
					low=0;
					high=mid;
				}
				
				if(range[0]>-1 && range[1]>-1) return range;
				if(range[0]<0)  high=mid-1;
				else	low=mid+1;
				
			}else if (A[mid]<target){
					low=mid+1;
			}else{
					high=mid-1;
			}
		}
		
		return range;
	}

}

package array_manipulation;

import java.util.ArrayList;
import java.util.Arrays;

public class three_sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={1,2,3,4,5,6,1,8,9};
		ArrayList<ArrayList<Integer>> set=sum3(a,6);
		for(ArrayList<Integer> x:set){
			System.out.println(x);
		}
	}
	
	
	
	
	public static ArrayList<ArrayList<Integer>> sum3(int[] arr,int target){
		int len=arr.length;
		Arrays.sort(arr);
		ArrayList<ArrayList<Integer>> set=new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<=len-2;i++){
			int rest=target-arr[i];
			
			int j=i+1;
			int k=len-1;
			while(j<k){
				if(arr[j]+arr[k]==rest){
					ArrayList<Integer> path=new ArrayList<Integer>();
					path.add(arr[i]);
					path.add(arr[j]);
					path.add(arr[k]);
					if(!set.contains(path)){
						set.add(path);
					}
					j++;
					k--;
				}
				else if(arr[j]+arr[k]<rest){
					j++;
				}else{
					k--;
				}
			}
		
			
		}
			return set;
	}
		
		
}



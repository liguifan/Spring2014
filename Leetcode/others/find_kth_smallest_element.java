package others;

import java.util.Collections;
import java.util.PriorityQueue;

import datastructure.ListNode;

public class find_kth_smallest_element {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		PriorityQueue<Integer> queue=new PriorityQueue<Integer>();
		int[] arr={8,41,52,2,7,95,12,45,27,1,4,3,5,78,55,61};
		int[] re=find_kth_largest(arr, 5);
		for(int x:re){
			System.out.println(x);
		}
	}
	
	

	
	public static int[] find_kth_smallest(int[] arr,int k){
		PriorityQueue<Integer> queue=new PriorityQueue<Integer>(k,Collections.reverseOrder());
		for(int i=0;i<=k-1;i++){
			queue.add(arr[i]);
		}
		for(int i=k;i<=arr.length-1;i++){
			if(arr[i]>queue.peek()){
				System.out.println("peek "+queue.peek());
				i++;
			}else
			{
				queue.poll();
				queue.add(arr[i]);
			}
		}
		int[] b=new int[k];
		for(int i=k-1;i>=0;i--){
			b[i]=queue.poll();
		}
		return b;
	}
	
	public static int[] find_kth_largest(int[] arr,int k){
		PriorityQueue<Integer> queue=new PriorityQueue<Integer>();
		for(int i=0;i<=k-1;i++){
			queue.add(arr[i]);
		}
		for(int i=k;i<=arr.length-1;i++){
			if(arr[i]<queue.peek()){
				i++;
			}else
			{
				queue.poll();
				queue.add(arr[i]);
			}
		}
		int[] b=new int[k];
		for(int i=k-1;i>=0;i--){
			b[i]=queue.poll();
		}
		return b;
		
		
	}

}

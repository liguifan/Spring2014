package heap_manipulation;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.lang.*;


public class heap_implementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> queue=new PriorityQueue<Integer>();
		int[] arr={8,41,52,2,7,95,12,45,27,1,4,3,5,78,55,61};
		int[] re=find_kth_largest(arr, 5);
		for(int x:re){
			System.out.println(x);
		}
		
		
	}
	
	
	
	
	
	
	
	public static void pushHeap_min(int[] arr,int last, int item){
		int currPos,parentPos;
		
		currPos=last;
		parentPos=(currPos-1)/2;
		
		while(currPos!=0){
			
			if(item<arr[parentPos]){
				arr[currPos]=arr[parentPos];
				currPos=parentPos;
				parentPos=(currPos-1)/2;
			}
			else{
				break;
			}
			arr[currPos]=item;
		}
	}
	
	public static void pushHeap_max(int[] arr,int last, int item){
		int currPos,parentPos;
		
		currPos=last;
		parentPos=(currPos-1)/2;
		
		while(currPos!=0){
			
			if(item>arr[parentPos]){
				arr[currPos]=arr[parentPos];
				currPos=parentPos;
				parentPos=(currPos-1)/2;
			}
			else{
				break;
			}
			arr[currPos]=item;
		}
	}
	
	public static void adjustHeap(int[] arr,int first,int last){
		
		int currentPos,childPos;
		int target;
		currentPos=first;
		target=arr[first];
		
		childPos=2*currentPos+1;
		while(childPos<last	){
			if((childPos+1<last) && arr[childPos +1]<arr[childPos]){
				childPos=childPos+1;
			}
			if(arr[childPos]<target){
				arr[currentPos]=arr[childPos];
				currentPos=childPos;
				childPos=2*currentPos+1;
			}
			else
			{
				break;
			}
		}
		arr[currentPos]=target;
	}
	
	
	public static void make_heap(int[] arr){
		int heapPos, lastPos;
		lastPos=arr.length;
		heapPos=(lastPos-2)/2;
		while(heapPos>0){
			System.out.println("heappos"+heapPos);
			adjustHeap(arr, heapPos, lastPos);
			heapPos--;
		}
	}
	
	public static int pop_heap(int[] arr,int last){
		int temp=arr[0];
		arr[0]=arr[last-1];
		arr[last-1]=temp;
		adjustHeap(arr, 0, last-1);
		return temp;
	}
	
	

}

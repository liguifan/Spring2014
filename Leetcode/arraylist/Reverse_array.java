package arraylist;

import java.util.ArrayList;
import java.util.Stack;

import datastructure.ListNode;

public class Reverse_array {
	public static void main(String[] args) {
		ListNode list=new ListNode(0);
		ListNode list_p=list;
		for(int i=1;i<6;i++){
			list.next=new ListNode(i);
			list=list.next;
		}
		
		list=list_p;
		ListNode result=reverseList(list);
		
		//Why the list is changed by the function? How to avoid this situation?
		
		list=list_p;
		while(list!=null){
			System.out.println("after r "+result.val);
			list=list.next;
		}
	
		//reverseList reture value is OK!
		while(result!=null){
			System.out.println("reverse "+result.val);
			result=result.next;
		}
		}

	
	
	
	
	public static ListNode reverseList(ListNode head){
		ListNode start=new ListNode(0);
		start.next=head;
		
		ListNode prev=null;
		ListNode curr=head;
		ListNode next=curr.next;
		while(curr!=null){
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		
		return prev;
	}
	
}

package arraylist;

import java.util.ArrayList;
import java.util.Stack;

import datastructure.ListNode;

public class Reverse_array {
	public static void main(String[] args) {
		
		ListNode l2=new ListNode(Integer.MIN_VALUE);
		ListNode l2_start=l2;
		
		l2.next=new ListNode(2);
		l2=l2.next;
		l2.next=new ListNode(4);
		l2=l2.next;
		l2.next=new ListNode(6);
		l2=l2.next;
		l2.next=new ListNode(8);
		l2=l2.next;
		l2.next=new ListNode(10);
		l2=l2.next;
		l2.next=new ListNode(15);
		l2=l2.next;
		l2.next=new ListNode(17);
		l2=l2_start;
		
		ListNode result=reverseBetween_practice(l2.next,1,5);
		while(result!=null){
			System.out.println("reverse "+result.val);
			result=result.next;
		}
		/*ListNode list=new ListNode(0);
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
		}*/
		}
	public static ListNode reverseBetween_practice(ListNode head, int m, int n) {
		
		ListNode p=new ListNode(Integer.MIN_VALUE);
		p.next=head;
		int i=0;
		while(i<m-1){ // this does not include m
			p=p.next;
			i++;
		}
		
		ListNode a=p.next;
		ListNode b=a.next;
		
		ListNode mark=p.next;
		i=0;
		while(i<(n-m)){ // this include n-m
			p.next=b.next;
			b.next=a;
			a=b;
			b=p.next;
			i++;
		}
		mark.next=p.next;
		p.next=a;
		
		//This two lines are very critical! Also it is the foundation of boundary case'
		if(p.val == Integer.MIN_VALUE) return p.next;  
		else return head;  
		
		//return head;
		}
		
		
		
		
		
		
		
		
		
		
	
	
	public ListNode reverseBetween(ListNode head, int m, int n) {  
        // Start typing your Java solution below  
        // DO NOT write main() function  
        ListNode p = new ListNode(Integer.MIN_VALUE);  
        p.next = head;  
        int index = 1;  
        while(index < m){  
            p = p.next;  
            index++;  
        }  
        ListNode c = p.next;  
        ListNode ne = c.next;  
        ListNode mark = c;  
        while(index < n){  
            p.next = ne;  
            ne = ne.next;  
            p.next.next = c;  
            c = p.next;  
            index++;  
        }  
        mark.next = ne;  
        if(p.val == Integer.MIN_VALUE) return p.next;  
        else return head;  
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

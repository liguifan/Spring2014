package linked_list_creation_SAMPLE;

import datastructure.ListNode;

public class sample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Two different length linked list l1 and l2;
		ListNode l1=new ListNode(Integer.MIN_VALUE);
		ListNode l2=new ListNode(Integer.MIN_VALUE);
		ListNode l3=new ListNode(Integer.MIN_VALUE);
		
		ListNode l1_start=l1;
		ListNode l2_start=l2;
		ListNode l3_start=l3;
		// l1={ 1,3,5,7,9} l2={2,4,6,8,10,15,17}
		l1.next=new ListNode(1);
		l1=l1.next;
		l1.next=new ListNode(3);
		l1=l1.next;
		l1.next=new ListNode(5);
		l1=l1.next;
		l1.next=new ListNode(7);
		l1=l1.next;
		l1.next=new ListNode(9);
		l1=l1.next;
		l1=l1_start;
		
		
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
		
		// 4,2,5,1,8,6,0 for sorting
		
		l3.next=new ListNode(4);
		l3=l3.next;
		l3.next=new ListNode(2);
		l3=l3.next;
		l3.next=new ListNode(5);
		l3=l3.next;
		l3.next=new ListNode(1);
		l3=l3.next;
		l3.next=new ListNode(8);
		l3=l3.next;
		l3.next=new ListNode(6);
		l3=l3.next;
		l3.next=new ListNode(0);
		l3=l3.next;
		l3=l3_start;
		// TODO Their printing function;
	}

}

package linked_list;

import datastructure.ListNode;

public class partition_list {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l3=new ListNode(Integer.MIN_VALUE);
	
		ListNode l3_start=l3;
		
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
		
		
		
		ListNode result=partition(l3.next, 4);
		while(result!=null){
			System.out.println(result.val);
			result=result.next;
		}
	}

	
	public static ListNode partition(ListNode head,int x){
		ListNode p_less=new ListNode(Integer.MIN_VALUE);
		ListNode p_big=new ListNode(Integer.MIN_VALUE);
		ListNode first_p=p_less;
		ListNode second_part=p_big;
		ListNode p=head;
		
		while(p!=null){
			if(p.val<x){
				p_less.next=new ListNode(p.val);
				p_less=p_less.next;
			}
			else
			{
				p_big.next=new ListNode(p.val);
				p_big=p_big.next;
			}
			p=p.next;
		}
		
		p_less.next=second_part.next;
		return first_p.next;
		
	}
}

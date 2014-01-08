package linked_list;

import datastructure.ListNode;

public class reversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1=new ListNode(Integer.MIN_VALUE);
		ListNode l1_start=l1;
		
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
		
		ListNode result=reversion(l1.next);
		
		while(result!=null){
			System.out.println(result.val);
			result=result.next;
		}
			
	}
	
	public static ListNode reversion(ListNode head){
		if(head==null)
			return null;
		if(head.next==null)
			return head;

		ListNode p=new ListNode(Integer.MIN_VALUE);
		p.next=head;
		ListNode a=p.next;
		ListNode b=a.next;
		a.next=null;
		
		while(b!=null){
			p.next=b;
			b=b.next;
			p.next.next=a;
			a=p.next;
		}	
		return p.next;	
	}

}

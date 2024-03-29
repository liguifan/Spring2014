package linked_list;

import datastructure.ListNode;

public class insertion_sort_list {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			ListNode test=new ListNode(Integer.MIN_VALUE);
			ListNode head=test;
			test.next=new ListNode(4);
			test=test.next;
			test.next=new ListNode(19);
			test=test.next;
			test.next=new ListNode(14);
			test=test.next;
			test.next=new ListNode(5);
			test=test.next;
			test.next=new ListNode(-3);
			test=test.next;
			test.next=new ListNode(1);
			test=test.next;
			test.next=new ListNode(3);
			
			ListNode re=insertion_sort(head.next);
			
			while(re!=null){
				System.out.println(re.val);
				re=re.next;
			}
	}



	public static ListNode insertion_sort(ListNode s){
		if(s.next==null)	return s;
		
		ListNode prev=new ListNode(Integer.MIN_VALUE);
		ListNode curr=new ListNode(Integer.MIN_VALUE);
		ListNode first=new ListNode(Integer.MIN_VALUE);
		ListNode head=first;
		
		first.next=s;
		prev=s;
		curr=s.next;
		
		while(curr!=null){
			first=head;
			if(curr.val<prev.val){
				
				while(first.next!=null && first.val<curr.val){
					if(first.next.val>curr.val){
						break;
					}
					first=first.next;
				}

				prev.next=curr.next;
				curr.next=first.next;
				first.next=curr;

			}
			if(prev.next!=null){
				curr=prev.next;
				if(curr.val>=prev.val){
					prev=prev.next;
					curr=curr.next;
				}
			}
			else
				break;
		}
	
			return head.next;
	}

}

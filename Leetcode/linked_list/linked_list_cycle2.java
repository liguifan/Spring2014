package linked_list;

import java.util.HashSet;

import datastructure.ListNode;

public class linked_list_cycle2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head=new ListNode(Integer.MIN_VALUE);
		ListNode p=head;
		head.next=new ListNode(1);
		head=head.next;
		head.next=new ListNode(2);
		ListNode mark=head.next;
		head=head.next;
		head.next=new ListNode(3);
		head=head.next;
		head.next=new ListNode(4);
		head=head.next;
		head.next=null;
		
		
		ListNode result=hasCycle2(p.next);
		System.out.println(result.val);
	}
	
	public static ListNode hasCycle2(ListNode head) {
        HashSet<ListNode> set=new HashSet<ListNode>();
        ListNode p=head;
        while(true){
            if(p==null)
                return null;
                
            else if(set.contains(p)){
                return p;
            }
            else{
                set.add(p);
            }
            p=p.next;
        }
    }

}

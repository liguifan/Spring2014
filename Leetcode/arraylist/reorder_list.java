package arraylist;

import datastructure.ListNode;

public class reorder_list {

	public static void main(String[] args) {
		ListNode list=new ListNode(0);
		ListNode list_p=list;
		for(int i=1;i<7;i++){
			list.next=new ListNode(i);
			list=list.next;
		}
		list=list_p.next;
		while(list!=null){
			System.out.println(list.val);
			list=list.next;
		}
		list=list_p.next;
		ListNode re=reorderList(list);
		while(re!=null){
			//System.out.println("re "+re.val);
			re=re.next;
		}
		
		
	}

	
	public static ListNode reorderList(ListNode head) {
        if(head==null)
             return null;
        if(head.next==null)
             return head;
        
        int size=0;
        ListNode tra=new ListNode(0);
        tra.next=head;
        head=tra;
        tra=tra.next;
        ListNode tra2=tra;
        
        
        while(tra!=null){
        	System.out.println("dddd "+tra.val);
            size++;
            tra=tra.next;
        }
        System.out.println("size "+size);
        //Silly mistakes for counting the size of a linked list;
        tra=head.next;
        while(tra!=null){
        	System.out.println("aaa "+tra.val);
            tra=tra.next;
        }
        tra=head.next;
        //System.out.println("tra+"+tra.next.val);
        ListNode reverse=new ListNode(0);
        reverse.next=reverseList(tra.next);
        
        ListNode newlist=new ListNode(0);
        ListNode x=newlist;
        int n=1;
        tra=head.next;
        
       

        
        if(size%2==0){
            while(n<=size/2){
            	System.out.println("n1 "+n);
            	newlist.next=new ListNode(tra.next.val);
            	newlist=newlist.next;
            	tra=tra.next;
            	newlist.next=new ListNode(reverse.next.val);
            	reverse=reverse.next;
            	newlist=newlist.next;
            	n++;
            	}
        }
        else
        {
             while(n<=size/2+1){
            	 System.out.println("n2 "+n);
                 newlist.next=new ListNode(tra.next.val);
                 newlist=newlist.next;
                 tra=tra.next;
                 newlist.next=new ListNode(reverse.next.val);
                 reverse=reverse.next;
                 newlist=newlist.next;
                 n++;
        }
        }
        return x.next;
        
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

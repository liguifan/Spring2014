import datastructure.ListNode;


public class MergeS {
	public static void main(String[] args) {
	
		
		
		ListNode head3=new ListNode(4);
		ListNode tra3=head3;
		head3.next=new ListNode(8);
		head3=head3.next;
		head3.next=new ListNode(2);
		head3=head3.next;
		head3.next=new ListNode(6);
		head3=head3.next;
		head3.next=new ListNode(7);
		head3=head3.next;
		head3.next=new ListNode(7);
		head3=head3.next;
		
		ListNode head4=new ListNode(1);
		ListNode tra4=head4;
		head4.next=new ListNode(3);
		head4=head4.next;
		head4.next=new ListNode(5);
		head4=head4.next;
		head4.next=new ListNode(7);
		head4=head4.next;
		
		
		ListNode head5=new ListNode(3);
		ListNode tra5=head5;
		head5.next=new ListNode(2);
		head5=head5.next;
		head5.next=new ListNode(4);
		

		
		ListNode sortList=MergeSort(tra3);
		
		System.out.println("sort List");
		while(sortList!=null){
			System.out.println(sortList.val);
			sortList=sortList.next;
		}
		
		}
	
	
	
	public static ListNode MergeSort(ListNode original){
		//System.out.println("get into Mergesort"+a.val);
    	if((original==null)||(original.next==null))
    		return original;
    	ListNode first=original;
    	ListNode second=original.next;
    	
    	
    	
    	while(second!=null&&second.next!=null){
    		first=first.next;
    		//original=original.next;
    		second=(second.next).next;
    		
    	}
    	second=first.next;
    	first.next=null;
    	System.out.println("seconde value "+second.val);
    	
    
    	ListNode left=MergeSort(original);
    	ListNode right=MergeSort(second);
    	
    	return Merge(left,right);
    }
    public static ListNode FindMiddle(ListNode head){
    	ListNode headc=head;
    	while(headc!=null){
			System.out.print(headc.val);
			headc=headc.next;
		}
    	
    	ListNode slow=head;
    	ListNode fast=head;
    	if(head==null)
    		return null;
    	if(head.next==null)
    		return head;
    	if(head.next.next==null)
    		return head;
    		
    	while(fast!=null){
    		System.out.println("last1");
	    		fast=fast.next;
	    		if(fast==null)
	    			System.out.println("luck");
	    		//System.out.println("last");
	    		if(fast!=null){
	    			System.out.println("last2");
	    			//System.out.println("liguifan" +fast.val);
    				slow=slow.next;
    				fast=fast.next;
	    		}
	    		System.out.println("luck2");
	    		//System.out.println("last");
		    	//System.out.println("secon" +fast.val);
	    		if(fast==null)
	    			System.out.println("luck4");
    	}
    	
    	System.out.println("slow" +slow.val);
    	
    	return slow;
    }
    /*
    public static ListNode Merge(ListNode a,ListNode b){
    	ListNode list;
    	
    	if(a==null)
    			return b;
    	if(b==null)
    			return a;
    	
    	if(a.val<=b.val){
    		  list=a;
    		  list.next=Merge(a.next,b);
    	}
    	else{
    		list=b;
    		list.next=Merge(a,b.next);
    	}
    		return list;
    }*/
    public static ListNode Merge(ListNode h1, ListNode h2) {
        ListNode tmp;
        if (h2.val < h1.val) {// make sure, h2.val < h1.val
            tmp = h2;
            h2 = tmp.next;
             tmp.next = h1;
            h1 = tmp;
        }
         
        ListNode preNode = h1;
        while (h2 != null) {
            tmp = h2;
            h2 = tmp.next;
            while (preNode.next != null && preNode.next.val < tmp.val)
                preNode = preNode.next;
            tmp.next = preNode.next;
            preNode.next = tmp;
        }
        return h1;
    }
}

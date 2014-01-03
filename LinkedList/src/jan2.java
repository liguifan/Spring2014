
import java.util.ArrayList;
import java.util.Stack;

import datastructure.ListNode;
public class jan2 {
	static ArrayList<ArrayList<Integer>> set=new ArrayList<ArrayList<Integer>>();
	public static void main(String[] args) {
		//ArrayList<Integer> list=new ArrayList<Integer>();
		ArrayList<Integer> arraylist=new ArrayList<Integer>();
		arraylist.add(1);
		arraylist.add(2);
		arraylist.add(3);
		
		//permutation(list,arraylist);
		
			
			
			
		int[] array={1,2,3,4,5};
		//array={1,2,3,4,5};
		for(int x:array){
		//System.out.println(x);
		}
		
		Stack<Integer> s=new Stack<Integer>();
		s.push(2);
		s.push(4);
		s.push(6);
		
		ListNode list=new ListNode(0);
		ListNode list_p=list;
		for(int i=1;i<6;i++){
			list.next=new ListNode(i);
			list=list.next;
		}
		
		list=list_p;
		while(list!=null){
			//System.out.println("test linklist"+list.val);
			list=list.next;
		}
		
		list=list_p;
		ListNode result=reverseList(list);
		
		
		//ListNode result=reverseBetween(list, 1, 6);
		while(result!=null){
			System.out.println("reverse "+result.val);
			result=result.next;
		}
		}
	
	public static ListNode reverseBetween(ListNode head, int m, int n) {
		
		ListNode start=new ListNode(0);
		start.next=head;
		ListNode cut=new ListNode(0);
		ListNode cut_s=cut;
		
		ListNode s1=new ListNode(0);
		ListNode s2=new ListNode(0);
		
		ListNode n1=new ListNode(0);
				n1.next=head;
				
				
				
		if(head==null)
			return null;
		
		
		int counter=0;
		Stack<Integer> s=new Stack<Integer>();
		while(n1!=null){
			
			if(counter==m-1){
				System.out.println("s1.next"+counter);
				 s1.next=n1;
			}
			if(counter<=n && counter>=m){
				System.out.println("debug"+n1.val);
				s.push(n1.val);
				
				if(counter==n){
					s2.next=n1.next;
				}
			}
			n1=n1.next;
			counter++;
		}		
		while(!s.isEmpty()){
			cut.next=new ListNode(s.pop());
			cut=cut.next;
		}	
		//System.out.println(s1.next.next.val);
		s1.next.next=cut_s.next;
		cut.next=s2.next;	
		if(m==1)
			return s1.next.next;
		
		return head;
    
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
		
		
		
		
	
	
	
	
	public static void permutation(ArrayList<Integer> prefix, ArrayList<Integer> rest){
		ArrayList<Integer> list=new ArrayList<Integer>();
		if(rest.size()==0)
            set.add(prefix);
		else{
        for(int i=0;i<rest.size();i++){
        	prefix.add(rest.get(i));
        	System.out.println("prefix"+prefix+"ite"+i);
        	//rest.remove(i);
        	System.out.println("rest"+rest);
            permutation(prefix,rest);
            //refix.remove(rest.get(i));      
        }
		}

    }
}

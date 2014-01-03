import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import datastructure.ListNode;


public class Dp {
	
	
public static void main(String[] args) {
	
		
		
		ListNode head3=new ListNode(2);
		ListNode tra3=head3;
		head3.next=new ListNode(3);
		head3=head3.next;
		head3.next=new ListNode(4);
		head3=head3.next;
		head3.next=new ListNode(5);
		head3=head3.next;
		head3.next=new ListNode(6);
		head3=head3.next;
		head3.next=new ListNode(7);
		head3=head3.next;
		
		ListNode head4=new ListNode(1);
		ListNode tra4=head4;
		head4.next=new ListNode(5);
		head4=head4.next;
		head4.next=new ListNode(8);
		head4=head4.next;
		head4.next=new ListNode(9);
		head4=head4.next;
		head4.next=new ListNode(10);
		head4=head4.next;
		head4.next=new ListNode(15);
		head4=head4.next;
		
		
		ListNode test1=new ListNode(0);
		ListNode test2=new ListNode(0);
		
		//tra3 and tra4 is ok
		//System.out.print(tra3.val);
		
		ArrayList<Integer> m=new ArrayList<Integer>();
		m.add(5);
		m.add(6);
		
		System.out.println("try"+m.get(0));
		
		ArrayList<ListNode> mm=new ArrayList<ListNode>();
		mm.add(test1);
		mm.add(test2);
		ListNode ss11=mergeKLists(mm);
		
		if(ss11==null)
			System.out.print("null");
		while(ss11!=null){
			System.out.print(ss11.val);
			ss11=ss11.next;
			}
}
	public static ListNode deleteDuplicates(ListNode head) {

        ListNode traverse=head;
        if(head==null)
            return head;
            
     while(traverse.next!=null){   
        while(traverse.val==traverse.next.val){
        		if(traverse.next.next!=null)
        			traverse.next=traverse.next.next;
        		else{
        			traverse.next=null;
        			return head;
        		}
            }
        	
            traverse=traverse.next;
        }
        
        return head;
    }
	
	
	public static int[] plusOne(int[] digits) {
        int len_s=digits.length;
        int len=len_s;
        
        if(digits==null)
            return null;
        int[] new1=new int[len+1];
        int[] new2=new int[len];
        
        digits[len-1]=digits[len-1]+1;
        
    
        
        if(len==1){
        	if( digits[0]==10){
            new1[0]=1;
            new1[1]=0;
            return new1;
        	}
        	else{
        		new2[len-1]=digits[len-1];
        		return new2;
        	}
        		
        }
   
        while(len>1){
                    if(digits[len-1]==10){
                        digits[len-2]=digits[len-2]+1;
                        digits[len-1]=0;
                     //   System.out.println("li"+digits[len-2]);
                    }
                    len--;
                }
                
       if(digits[0]==10){
                    new1[0]=1;
                    digits[0]=0;
                    for(int i=1;i<len_s+1;i++){
                        new1[i]=digits[i-1];
 
                    }
                    return new1;
                }
                else{
          
                	for(int i=0;i<len_s;i++){
                        new2[i]=digits[i];
 
                    }
                	return new2;
                }
    }
	
	 public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
	        ArrayList<ArrayList<Integer>> set = new ArrayList<ArrayList<Integer>>();
	        HashSet<ArrayList<Integer>> test= new HashSet<ArrayList<Integer>>();
	        Arrays.sort(num);
	         for(int i=0; i<num.length-2; i++){
	                int target=num[i];
	                int j=i+1;
	                int k=num.length-1;
	                while(j<k){
	                    if(num[k]+num[j]==-target){
	                        ArrayList<Integer> subset=new ArrayList<Integer>();
	                        subset.add(i);
	                        subset.add(j);
	                        subset.add(k);
	                        if(!test.add(subset)){
	                            set.add(subset);
	                        }
	                    }
	                    else if(num[k]+num[j]>target)
	                        j++;
	                    else
	                        k--;
	                    
	                    j++;
	                    k--;
	                }
	        }
	        
	        return set;
	    }
	 
	 
	 
	 public static ListNode mergeKLists(ArrayList<ListNode> lists) {
	        int i=1;
	        if(lists.isEmpty())
	            return null;
	            
	        ListNode newlist=lists.get(0);
	        if(newlist==null)
	            return null;
	            
	        if(lists.size()==1){
	            return newlist;
	        }
	        
	        
	        //This is for at least the Arraylist contains two subsets   
	        while(i<lists.size()){
	        newlist=mergeTwo(newlist, lists.get(i));
	        i++;
	        }
	        return newlist;
	    }

	public static ListNode mergeTwo(ListNode a,ListNode b){
	        ListNode list=new ListNode(0);
	        ListNode head=list;
	        ListNode start=list;

	        while(a!=null && b!=null){
	            if(a.val<=b.val){
	                list.next=new ListNode(a.val);
	                System.out.println("if "+list.val);
	                list=list.next;
	                a=a.next;
	            }
	            else{
	                list.next=new ListNode(b.val);
	                System.out.println("else "+list.val);
	                list=list.next;
	                b=b.next;
	                
	            }
	        }
	        
	        if(a==null){
	            list.next=b;
	        }
	        else
	            list.next=a;
/*
	        while(head!=null){
				System.out.print("before reture "+head.val);
				head=head.next;
				}
	        head=start;*/
	        
	        
	        return head.next;
	 }
}

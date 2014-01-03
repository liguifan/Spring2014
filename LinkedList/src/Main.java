import java.util.*;

import datastructure.ListNode;
import static java.lang.Math.pow;
public class Main {

	/**
	 * @param args
	 * @return 
	 */
	
	
	public static void main(String[] args) {
		//ArrayList<Integer> 
		int x=reverse(901)	;
		//System.out.println(x);
		int[] num={1,2,3};
		//System.out.println(num.length);
		
		
		ListNode head1=new ListNode(0);
		ListNode head2=new ListNode(0);
		ListNode tra=head1;
		ListNode tra2=head2;
		for(int i=1;i<10;i++){
			head1.next=new ListNode(10-i);
			head2.next=new ListNode(i);
			head1=head1.next;
			head2=head2.next;
		}
		head1=tra;
		head2=tra2;
		ListNode mid=FindMiddle(tra);
		
		
		ListNode head3=new ListNode(2);
		ListNode tra3=head3;
		head3.next=new ListNode(4);
		head3=head3.next;
		head3.next=new ListNode(6);
		head3=head3.next;
		head3.next=new ListNode(8);
		head3=head3.next;
		
		ListNode head4=new ListNode(1);
		ListNode tra4=head4;
		head4.next=new ListNode(3);
		head4=head4.next;
		head4.next=new ListNode(5);
		head4=head4.next;
		head4.next=new ListNode(7);
		head4=head4.next;
		
		
		head3=tra3;
		ListNode merge=Merge(tra3,tra4);
		System.out.println("before find mid Tra3");
		while(tra3!=null){
			System.out.println(tra3.val);
			tra3=tra3.next;
		}
		tra3=head3;
		ListNode sortList=MergeSort(tra3);
		
		System.out.println("after find mid Tra3");
		while(sortList!=null){
			System.out.println(sortList.val);
			sortList=sortList.next;
		}
		
		System.out.println("Tra3");
		
		while(tra3!=null){
			System.out.println(tra3.val);
			tra3=tra3.next;
		}
		}

	
	    public static boolean isPalindrome(String s) {
	        if(s.length()==0)
	            return true;
	            
	        //get rid of the non-alphabeta staff
	        String s_non=s.replaceAll("[^A-Za-z]", "");
	        String s_new=s_non.toLowerCase();
	        int len=s_new.length();
	        for(int i=0;i<len;i++){
	        	//System.out.print(s.charAt(i));
	            if(s_new.charAt(i)!=s_new.charAt(len-1-i)){
	                return false;}
	        }
	        return true;
	        
	        }
	    public class TreeNode {
	    	      int val;
	    	     TreeNode left;
	    	     TreeNode right;
	    	      TreeNode(int x) { val = x; }
	    	  }
	    public boolean hasPathSum(TreeNode root, int sum) {  
	    	   if (root == null) return false;  
	    	   if (root.left == null && root.right == null) // get to a leaf 
	    	     return (sum == root.val);  
	    	   return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);  
	    	 }  
	    public static int lengthOfLongestSubstring(String s) {
	    		HashMap<Character, Integer> set=new HashMap<Character,Integer>();
	    		int j=0,max=0;
	    		set.clear();
	    		for(int i=0;i<s.length();i++){
	    			if(!set.containsKey(s.charAt(i))){
	    				set.put(s.charAt(i), j);
	    				j++;
	    				//System.out.println(s.charAt(i));
	    				//System.out.println(set);
	    				//System.out.println(j);
	    			}
	    			else{
	    				 //hashmap empty
	    				if(max<j)
	    					max=j;	
	    				j=0;
	    				set.clear();
	    				set.put(s.charAt(i), j);
	    				j++;
	    				//System.out.println(set);
	    				}
	    			}
	    		if(max<j)
					max=j;	
	    		return max;
	    }	
	    
	    public static double lookup(int m, double[] a){
	        for(int i=0; i<a.length;i++){
	            if(m<pow(i,2))
	                return a[i-1]*lookup(m-2^(i-1),a);
	            if(m==pow(i,2))
	                return a[i];
	        }
	        		return 0;
	    }
	    public static double pow1(double x, int n) {
	        int i=1,j=0;
	        double ans=0;
	        double p_ans=x;
	        double[] a;
	        a=new double[10];
	        while(i<n){
	        	System.out.println("e");
	            a[j]=p_ans;
	            System.out.println(p_ans);
	            System.out.println(i);
	            p_ans=p_ans*p_ans;
	            j++;
	            i=i*2;
	        }
	         
	         return a[j-1]*lookup(n-i/2,a);
	    }
	    public static double pow2(double x, int n) {
	    	if(n%2==0)
	            return pow(x, n/2)*pow(x,n/2);     
	        else
	            return x*pow(x, n/2)*pow(x,n/2);
	    }
	    public static boolean isPalindrome1(int x) {
	        int div=1;
	        int most,least;
	        if(x/10==0)
	            return true;
	        while(x/div>=10){
	        	//System.out.println(div);
	            div=div*10;
	        }
	        
	        while(x!=0){
	        least=x%10;
	        most=x/div;
	        System.out.println(most);
        	System.out.println(least);
	        if(least!=most){
	        	
	            return false;
	        }
	        x=x%div;
	        x=x/10;  //get rid of the last
	        div=div/100;
	        }
	        return true;
	    }
	    static int depth=0;
	    public static int maxDepth(TreeNode root) {
	        if(root==null)
	            return 0;
	        depth++;
	        if(root.left==null && root.right==null)
	                return depth;
	                
	        else
	                return Math.max(maxDepth(root.left),maxDepth(root.right));
	    }
	    
	    public static int reverse(int x) {
	        int[] first_d={0,0};
			int rest=0;
			
	        if(Math.abs(x)<10)
	            return x;
	        first_d=firstdigit(x);
	        rest=x%first_d[1];
	        System.out.println(first_d[0]);
	        return 10*reverse(rest)+first_d[0];
	    }
	    
	    public static int[] firstdigit(int x){
	         int div=1;
	        while(x/div!=0){
	            div=div*10;
	        }
	        div=div/10;
	        //System.out.println(div);
	        return new int[]{x/div,div};
	    }
	    
	    public static ListNode MergeSort(ListNode a){
	    	
	    	if((a==null)||(a.next==null))
	    		return a;
	    	ListNode first=a;
	    	ListNode mid=FindMiddle(a);
	    	ListNode second=mid.next;
	    	mid.next=null;
	    	ListNode left=MergeSort(first);
	    	ListNode right=MergeSort(second);
	    	mid.next=null;
	    	
	    	return Merge(left,right);
	    }
	    public static ListNode FindMiddle(ListNode head){
	    	ListNode slow=head;
	    	ListNode fast=head;
	    	if(head==null)
	    		return null;
	    	if(head.next==null)
	    		return head;
	    	while(fast!=null){
	    		// second.next.next is illegal because second.next is null
	    		//System.out.println("first" +slow.val);
		    	//System.out.println("secon" +fast.val);
		    		fast=fast.next;
		    		if(fast!=null){
	    				slow=slow.next;
	    				fast=fast.next;
		    		}
	    	}
	    	ListNode mid=slow;
	    	//slow=null;
	    	return mid;
	    }
	    
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
	    }
	    
}
	    


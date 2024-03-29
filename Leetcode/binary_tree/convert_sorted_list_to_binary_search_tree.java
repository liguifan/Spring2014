package binary_tree;

import datastructure.ListNode;
import datastructure.TNode;
import datastructure.TreeNode;

public class convert_sorted_list_to_binary_search_tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode test=new ListNode(Integer.MIN_VALUE);
		ListNode head=test;
		test.next=new ListNode(1);
		test=test.next;
		test.next=new ListNode(2);
		test=test.next;
		test.next=new ListNode(3);
		test=test.next;
		test.next=new ListNode(4);
		test=test.next;
		test.next=new ListNode(5);
		test=test.next;
		test.next=new ListNode(6);
		test=test.next;
		test.next=new ListNode(7);
		int len=0;
		ListNode temp=head.next;
		while(temp!=null){
			temp=temp.next;
			len++;
		}
		
		TreeNode tree= build_tree2(head.next, 0,len-1);
		
		System.out.println(tree.val);
	
	}
	
	

	public static TreeNode build_tree2(ListNode head,int start,int end){
		if(start> end)
			return null;
		
		int mid=start+ (end-start)/2;
		ListNode temp=head;
		for(int i=0;i<=mid-1;i++){
			temp=temp.next;
		}
		
		TreeNode root =new TreeNode(temp.val);
		root.left=build_tree2(head,0,mid-1);
		root.right=build_tree2(head, mid+1, end);
		
		return root;
	}
	
	
	public static void build_tree(ListNode head, TNode<Integer> root){
		ListNode left=head;
		ListNode slow=head;
		ListNode fast=head;
		
		if(head==null)
			return;
		
		while(fast!=null && fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
		}
		if(fast!=null){
			slow=slow.next;
		}
		root=new TNode<Integer>(slow.val);
		
		build_tree(left,root.left);
		build_tree(slow.next,root.right);
	}
	
	
	
	
	
	
	public static ListNode find_link_list_mid(ListNode head){
		ListNode fast=head;
		ListNode slow=head;
		
		while(fast!=null && fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
		}
		
		if(fast!=null){
			slow=slow.next;
		}
		return slow;
	}
	
	
	

}

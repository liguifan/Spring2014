package path_recursion;

import datastructure.ListNode;
import datastructure.TreeNode;

public class flatten_binary_tree_to_linked_list {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root=new TreeNode(5);
		root.left=new TreeNode(6);
		root.left.left=new TreeNode(19);
		root.right=new TreeNode(7);
		
		ListNode list=flatten(root);
		while(list!=null){
		System.out.println(list.val);
		list=list.next;
		}
		
	}
	public static ListNode flatten(TreeNode root){
		/*if(root.left==null && root.right==null){
			return null;// this doesnt add the leave, unlike the main program ,add everynode when get into the function.
		*/
		
		if(root.left==null && root.right==null){
			
			return new ListNode(root.val);
			//the main program execuate the add to the list function (list.next= return())
		}
		ListNode list=new ListNode(root.val);
		ListNode head=list;
		if(root.left!=null)
			list.next=flatten(root.left);
		
		ListNode p=list;
		
		while(p.next!=null){
			p=p.next;
		}
		if(root.right!=null)
			p.next=flatten(root.right);
		
		return head;
	
  }
}

package binary_tree;

import datastructure.ListNode;
import datastructure.TreeNode;

public class flatten_binary_tree_to_linked_list {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root=new TreeNode(5);

		root.left=new TreeNode(6);
		root.left.left=new TreeNode(19);
		root.left.right=new TreeNode(3);
		root.right=new TreeNode(2);

		TreeNode result=flatten3(root);

		while(result!=null){
			System.out.println("test "+result.val);
			result=result.right;
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
//using test null leave method.
	public static TreeNode flatten2(TreeNode root){
		//		if(root.left==null && root.right==null)
		//		return new TreeNode(root.val);
		if(root==null)
			return null;
		TreeNode left=flatten2(root.left);
		TreeNode right=flatten2(root.right);
		// let see how the good example deal with this case.
		TreeNode p=new TreeNode(Integer.MIN_VALUE);
		p.right=left;

		while(p.right!=null){
			p=p.right;
		}
		p.right=right;

		if(left==null){
			root.right=p.right;
		}else
		{
			root.right=left;
		}
		root.left=null;
		return root;
	}
// using test leave method.
	public static TreeNode flatten3(TreeNode root){
		if(root.left==null && root.right==null)
					return new TreeNode(root.val);
		
		TreeNode left=null;
		TreeNode right=null;
		if(root.left!=null){
			left=flatten3(root.left);
			System.out.println("imporv");
		}
		if(root.right!=null){
			right=flatten3(root.right);
		}
		TreeNode p=new TreeNode(Integer.MIN_VALUE);
		p.right=left;

		while(p.right!=null){
			p=p.right;
		}
		p.right=right;
		

		if(left==null){
			root.right=flatten3(root.right);
			System.out.println("liguifan");
		}
		else{
			root.right=left;
		}
		root.left=null;
		return root;
	}
}



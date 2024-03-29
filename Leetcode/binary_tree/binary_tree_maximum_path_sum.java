package binary_tree;

import datastructure.TreeNode;

public class binary_tree_maximum_path_sum {
	static int max=Integer.MIN_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode root=new TreeNode(-2);
		root.left=new TreeNode(-1);
		root.right=new TreeNode(3);
		
		int result=max_path(root);
		System.out.println("Max value is "+max);
		
		
	}
	
	public static int max_path(TreeNode root){
        if(root.left==null && root.right==null){
           
           return root.val;
           }
       int left=Integer.MIN_VALUE;
       int right=Integer.MIN_VALUE;
       if(root.left!=null)
           left=max_path(root.left);
       if(root.right!=null)
           right=max_path(root.right);
       
       int m=root.val;
       if(left>=0)
           m=m+left;
       if(right>=0)
           m=m+right;
       
       
       if(m>max)
           max=m;
       if(left>max)
           max=left;
       if(right>max){
           max=right;
           }
return Math.max(left,right)>0?(root.val+Math.max(left,right)):root.val;
  
   
}

}

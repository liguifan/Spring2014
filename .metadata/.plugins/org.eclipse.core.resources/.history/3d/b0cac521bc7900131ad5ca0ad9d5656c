package path_recursion;

import java.util.ArrayList;

import datastructure.TreeNode;

public class path_sum2 {
	public static ArrayList<ArrayList<Integer>> set;
    public static ArrayList<Integer> list;
	
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	set=new ArrayList<ArrayList<Integer>>();
        list=new ArrayList<Integer>();
        
        
        
        TreeNode root=new TreeNode(1);
		//root.left=new TreeNode(2);
		//root.right=new TreeNode(-3);
		
		getPath(root, 0);
		System.out.println(set);
	}
    public static void getPath(TreeNode current, int sum){
        // in recursion, how to deal with the new variable problme like "list" in this case.
      
        if(current.left==null && current.right==null){
            /*if(current.val==sum){
                    list.add(current.val);
	                ArrayList<Integer> list2=new ArrayList<Integer>();
	                list2.addAll(list);
	                set.add(list2);
            }*/
            // This is because we didn't remove the node in list so that makes the error
            if(current.val==sum){
                    
	                ArrayList<Integer> list2=new ArrayList<Integer>();
	                list2.addAll(list);
	                list2.add(current.val);
	                set.add(list2);
            }
        }else{
            list.add(current.val);
            if(current.left!=null)
                getPath(current.left,sum-current.val);
            if(current.right!=null)
                getPath(current.right,sum-current.val);
            list.remove(list.size()-1);
            
        }
    }
}

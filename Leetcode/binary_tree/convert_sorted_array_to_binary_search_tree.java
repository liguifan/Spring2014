package binary_tree;

import datastructure.ListNode;
import datastructure.TreeNode;

public class convert_sorted_array_to_binary_search_tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array={1,2,3,4,5,6,7};
		int len=array.length;
		TreeNode tree= build_tree1(array, 0,len-1);
		System.out.println(tree.val);
	}
	
	
	public static TreeNode build_tree1(int[] array,int start,int end){
		if(start>end)	return null;
		
		int mid=start+(end-start)/2;
		TreeNode root=new TreeNode(array[mid]);
		
		root.left=build_tree1(array,start,mid-1);
		root.right=build_tree1(array,mid+1,end);
		
		return root;
		
	}

}

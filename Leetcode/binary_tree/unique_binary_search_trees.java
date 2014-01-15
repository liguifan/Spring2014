package binary_tree;

public class unique_binary_search_trees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int result=numTrees(3);
		System.out.println(result);
		
		
	}
	
	public static int numTrees(int n){
		if(n<=1)
			return 1;
		int sum=0;
		for(int i=0;i<n;i++){
			sum+=numTrees(n-i-1)*numTrees(i);
		}
		
		
		
		return sum;
		
	}

}

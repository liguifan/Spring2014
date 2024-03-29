package recursion;

import java.util.ArrayList;

public class triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> triangle=new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> path1 =new ArrayList<Integer>();
		ArrayList<Integer> path2 =new ArrayList<Integer>();
		ArrayList<Integer> path3 =new ArrayList<Integer>();
		ArrayList<Integer> path4 =new ArrayList<Integer>();
		path1.add(2);
		
		path2.add(1);
		path2.add(4);
		
		path3.add(1);
		path3.add(5);
		path3.add(7);
		
		path4.add(24);
		path4.add(1);
		path4.add(8);
		path4.add(3);
		triangle.add(path1);
		triangle.add(path2);
		triangle.add(path3);
		triangle.add(path4);
		ArrayList<Integer> route =new ArrayList<Integer>();
		int r=find_path_DP(triangle);
		System.out.println("r is "+r);
		
		System.out.println(1d);
	}
	
	
	
	public static void minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        
    }
	
	
	
	public static int find_path(ArrayList<ArrayList<Integer>> triangle, int col,int row,int sum ){
		if(row==triangle.size()-1){
				return triangle.get(row).get(col);
		}else{
		int left=find_path(triangle,col,row+1, sum);
		int right=find_path(triangle,col+1,row+1, sum);

		sum+=triangle.get(row).get(col)+Math.min(left, right);	
		return sum;
		}
	}
	
	
	// Dynamic Programming method. Bottom up method.
	
	public static int find_path_DP(ArrayList<ArrayList<Integer>> triangle){
		
		for(int i=triangle.size()-2;i>=0;i--){
			ArrayList<Integer> curr=triangle.get(i);
			ArrayList<Integer> next=triangle.get(i+1);
			for(int j=0;j<=curr.size()-1;j++){
				int temp=curr.get(j)+Math.min(next.get(j), next.get(j+1));
				curr.set(j, temp);
				System.out.println(temp);
			}
			
		}	
		return triangle.get(0).get(0);
	}

}

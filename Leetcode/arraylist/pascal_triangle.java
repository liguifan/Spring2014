package arraylist;

import java.util.ArrayList;

public class pascal_triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ArrayList<Integer> a=new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> result=generate(5);
		
		for(ArrayList<Integer> x:result ){
			System.out.println(x);
		}
		
	}
	
	public static ArrayList<ArrayList<Integer>> generate(int n) {
		ArrayList<ArrayList<Integer>> set=new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> last= new ArrayList<Integer>();
		ArrayList<Integer> first= new ArrayList<Integer>();
		ArrayList<Integer> second= new ArrayList<Integer>();
		first.add(1);
		second.add(1);
		second.add(1);
		
		last.add(1);
		last.add(2);
		last.add(1);
		if(n==0)  return set;
		else if(n==1){
			
			set.add(first);
			return set;
		}
		else if(n==2)
		{
			
			set.add(first);
			set.add(second);
			return set;
		}else{
			set.add(first);
			set.add(second);
			set.add(last);
			int j=3;
			while(j<=n-1){
				ArrayList<Integer> path= new ArrayList<Integer>();
				path.add(1);
				for(int i=0;i<=last.size()-2;i++){
					path.add(last.get(i)+last.get(i+1));
				}
				path.add(1);
				set.add(path);
				last=path;
				j++;
			}
		}		
		return set;
    }

}

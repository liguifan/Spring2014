package recursion;
import java.util.ArrayList;
import java.util.Collections;

public class combinations {
	//static ArrayList<ArrayList<String>> set  =new ArrayList<ArrayList<String>>();
	static ArrayList<ArrayList<Integer>> set2=new ArrayList<ArrayList<Integer>>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String a="james";
			ArrayList<String> path=new ArrayList<String>();
			
			set2=combine(5,2);
//			ArrayList<String> path2=new ArrayList<String>();
			ArrayList<ArrayList<String>> set  =new ArrayList<ArrayList<String>>();
			
			combination(a,3,0,path,set);
			for(ArrayList<String> x:set){
				System.out.println(x);
			}
			
			for(ArrayList<Integer> x:set2){
				System.out.println(x);
			}
	}
	
	
	
	public static void combination(String str,int k,int index,ArrayList<String> path,ArrayList<ArrayList<String>> set ){
		
		if(path.size()==k){

			set.add(path);
		}else if(path.size()>k){
			return;
		}
		else{
	
		for(int i=index; i<=str.length()-k+path.size();i++){
			ArrayList<String> path_s=new ArrayList<String>(path);
			path_s.add(Character.toString(str.charAt(i)));
			combination(str,k,i+1,path_s,set);
// doesn't matter we put set as static or argument, it is the same;
		}
		}
		
	}
	
	
//	public class Solution {
	    public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
	        ArrayList<ArrayList<Integer>> sol = new ArrayList<ArrayList<Integer>>();
	        recursion(n,k,new ArrayList<Integer>(), sol);
	        return sol;
	    }
	     
	    private static void recursion(int n, int k, ArrayList<Integer> partial,
	        ArrayList<ArrayList<Integer>> sol) {
	        if(partial.size() == k && !sol.contains(partial)) {
	            Collections.sort(partial);
	            sol.add(partial);
	        } else if(partial.size() > k) {
	            return;
	        } else {
	            for(int i = n; i >= 1; --i) {
	                ArrayList<Integer> partial_sol = new ArrayList<Integer>();
	                partial_sol.addAll(partial);
	                partial_sol.add(i);
	                recursion(i-1, k, partial_sol, sol);
	            }
	        }
	    }
	}
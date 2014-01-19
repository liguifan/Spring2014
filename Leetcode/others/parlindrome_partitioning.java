package others;

import java.util.ArrayList;
import java.util.HashSet;

import linked_list.isPalindrome_linkedList;

public class parlindrome_partitioning {

	private static final int ArrayList = 0;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        ArrayList<String> list = new ArrayList<String>();
		String str="aab";
		partition(0, str, list, res);
		for(ArrayList<String> x:res){
			System.out.println(x);
		}
	}
	
	public static void partition(int start, String str, ArrayList<String> list,ArrayList<ArrayList<String>> res){
		int len=str.length();
		if(start==len){
			ArrayList<String> list2=new ArrayList<String>(list);
			res.add(list2);
			return;
		}
		for(int i=start+1;i<=len;i++){
			String temp=str.substring(start,i);
			System.out.println(temp);
			if(isParlindrome(temp)){
				list.add(temp);
				partition(i,str,list,res);
				list.remove(list.size()-1);
			}
		}
}
	
	
//	public static boolean isParlindrome(String str){
//		int len=str.length();
//		int left=0;
//		int right=len-1;
//		
//		while(left<=right){
//			
//			if(str.charAt(left)!=str.charAt(right)){
//				return false;
//			}
//			left++;
//			right--;
//		}
//		return true;
//	}
	public static boolean isParlindrome(String s) {
        int left = 0, right = s.length() - 1;
        while(right >= left) {
            if(s.charAt(right) != s.charAt(left)) {
                return false;
            }
            right--;
            left++;
        }
        return true;
    }
}

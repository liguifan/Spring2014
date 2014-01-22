package others;

import java.util.ArrayList;

public class decode_ways {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> path=new ArrayList<String>();
		ArrayList<ArrayList<String>> res=new ArrayList<ArrayList<String>>();
		String str="a6065812287883668764831544958683283296479682877898293612168136334983851946827579555449329483852397155";
		int sum=0;
		
		
		String newstr=str.replaceAll("[^a-z]", "");
		System.out.println(newstr);
		

	}
	public static void decode_ways(String str,int start,ArrayList<String> path,ArrayList<ArrayList<String>> res){
		if(start==str.length()){
			res.add(new ArrayList<String>(path));
		}

		for(int i=start+1;i<=str.length();i++){
			String sub=str.substring(start,i);
			if(string_to_num(sub)){
				path.add(sub);
				decode_ways(str,i,path,res);
				path.remove(path.size()-1);
			}
		}
		
	}
	
	
	public static void decode_ways2(String str,int start,int sum){
		if(start==str.length()){
			sum++;
			return;
		}

		for(int i=start+1;i<=str.length();i++){
			String sub=str.substring(start,i);
			if(string_to_num(sub)){
				decode_ways2(str,i,sum);
			}
		}
//		System.out.println(sum);
		
	}
	public static boolean string_to_num(String str){
		int sum=0;
		for(int i=0;i<=str.length()-1;i++){
			sum=10*sum+((int)str.charAt(i)-48);
		}
		if(sum<=26)
			return true;
		else
			return false;
	}
}

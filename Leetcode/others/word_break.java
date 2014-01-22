package others;

import java.util.HashSet;
import java.util.Set;

public class word_break {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="aaaaaaa";
		Set<String> set=new HashSet<String>();
		set.add("aaaa");
		set.add("aaa");
//		set.add("e");
		
		System.out.println(wordBreak(s, set));
	}
	
	
	
	
	public static boolean wordBreak(String s,Set<String> dict){
	
	boolean[] word=new boolean[s.length()+1];
	word[0]=true;
	for(int i=0; i<=s.length();i++){
		for(int j=0;j<=i-1;j++){
			if(word[j] && dict.contains(s.substring(j,i))){
				word[i]=true;
			}
		}
	}
	return word[s.length()];
}
}

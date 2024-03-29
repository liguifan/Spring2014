package DP;

public class longest_palindromic_substring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="bb";
		
		String re=longest_palindrome(s);
		System.out.println(re);
	}
	
	
	
	public static String longest_palindrome(String s){
		if(s.length()<=1)
			return s;
		
		
		String longest_s="";
		int len=s.length();
		int max=0;
		
		
		for(int i=0;i<=len-1;i++){
			int l=i;
			int r=i+1;
			int lw=i;
			int rw=i+2;
			
			while(l>=0 && r<=len-1){
				// this is very easily to get out of range, so if be careful with this 
				if(s.charAt(l)!=s.charAt(r)){
					break;
				}
				l--;
				r++;
			}
			
			while(lw>=0 && rw<=len-1){
				
				if(s.charAt(lw)!=s.charAt(rw)){
					break;
				}
				lw--;
				rw++;
			}
			
			if(r-l>max){
				max=r-l;
				longest_s=s.substring(l+1,r);
			}
			
			if(rw-lw>max){
				max=rw-lw;
				longest_s=s.substring(lw+1,rw);
			}
		}
		return longest_s;
	}

}

package string_manipulation;

public class longest_palindromic_substring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static String longest_string(String s){
		int len=s.length();
		String result="";
		int max=0;
		int left=0;
		int right=len-1;;
		for(int i=0;i<=len-1;i++){
			left=i;
			right=i+1;
		String temp=s.substring(left,right);
		
			if(right-left>max){
				max=right-left;
				result=new String(s.substring(left,right));
			}
		}
		
	}
	
	
	
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

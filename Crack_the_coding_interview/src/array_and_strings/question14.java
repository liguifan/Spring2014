package array_and_strings;

public class question14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input="Mr John Smith    ";
		// String to char[] 
		char[] input2=input.toCharArray();
		System.out.println(add20(input2,17));
		char a='4';
		int b=a-48;
		System.out.println(b);
		char c=(char)(b+48);
		System.out.println(c);
	}
	
	public static char[] add20(char[] input,int n){
		char[] result=new char[n];
		int i=0;
		int j=0;
		while(i<input.length-4){
			
			
			if(input[i]==' '){
				result[j]='%';
				j++;
				result[j]='2';
				j++;
				result[j]='0';
				i++;
				j++;
			}
			
			result[j++]=input[i++];
			
			
			
			
		}
		return result;
	}

}

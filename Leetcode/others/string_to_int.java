package others;

public class string_to_int {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String str="123";
		
		int result=string_to_num(str);
		System.out.println(result);
	}
	
	
	
	
	public static int string_to_num(String str){
		int sum=0;
		for(int i=0;i<=str.length()-1;i++){
			sum=10*sum+((int)str.charAt(i)-48);
		}
		return sum;
	}

}
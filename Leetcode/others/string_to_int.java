package others;

public class string_to_int {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="-1";
		
		int re=string_to_num(str);
		System.out.println(re);
	}
	
	
	
	
	public static int string_to_num(String str){
		int j=0;
		while(str.charAt(j)==' '){
			str.replace(" ", "");
			j++;
		}
		str=str.substring(j);
		int sign=1;
		int sum=0;
		if(str.charAt(0)=='-'){
			sign=-1;
			str=str.substring(1);
		}
		else if(str.charAt(0)=='+'){
			sign=1;
			str=str.substring(1);
		}
		else{}
		System.out.println(str);
		int count=0;
		for(int i=0;i<=str.length()-1;i++){
			if(Character.isDigit(str.charAt(i))){
				if(sign==1 && sum==214748364 && (int)str.charAt(i)-48 >7){
					sum=Integer.MAX_VALUE;
					break;
				}
				
				if(sign==-1 && sum==214748364 && (int)str.charAt(i)-48 >8){
					sum=Integer.MIN_VALUE;
					break;
				}
				
				count++;
				System.out.println(count);
				if(count>10 && sign==1){
					sum=Integer.MAX_VALUE;
					break;
				}
				if(count>10 && sign==-1){
					sum=Integer.MIN_VALUE;
					break;
				}
				else{}
				
				sum=10*sum+((int)str.charAt(i)-48);
			}
			else
				break;
		}

		return sum*sign;
	}

}

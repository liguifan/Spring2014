package array_manipulation;

import java.util.Arrays;

public class array_manipulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr=new int[10];
		char[] arr2={'a','b','c','d'};
		for(int i=0;i<10;i++){
			arr[i]	=i;
		}
		//Method of converting char[] to String
		char[] a={'a','b','c'};
		String a_s=new String(a);
		System.out.println(a_s);
		char[] c=a_s.toCharArray();
		System.out.println(c);
		
		//Method of converting int[] to its corresponding String
		char[] b=new char[10];
		for(int i=0;i<10;i++){
			b[i]=(char) (arr[i]+48);
		}
		
		//Method of converiting Sting to int[]
		String test="123456";
		int[] test_int=new int[test.length()];
		for(int i=0;i<test.length();i++){
			test_int[i]=test.charAt(i)-48;
			System.out.println(test_int[i]);
		}
	}
	
	
	

}

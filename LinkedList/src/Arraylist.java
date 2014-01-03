import java.util.*;
public class Arraylist {
	static Scanner reader= new Scanner(System.in);
	static ArrayList<Integer> array= new ArrayList<Integer>();
	
	public static void main(String[] args){
		System.out.println("Please enter some number");
		int in=reader.nextInt();
		while(in!=0){
			array.add(in);
			in=reader.nextInt();
		}
		
		System.out.println("-----------");
		
		for(int i: array){
			System.out.println(i);
		}
	}
	
	
	
	
}

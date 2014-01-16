package array_manipulation;

public class swap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=5;
		int b=6;
		
		
		int[] result=swap1(a,b);
		a=result[0];
		b=result[1];
		
		System.out.println(a+" "+b);
		
	}
	// becasue Java is passed by value, so there are lots of problems associated with it.
	public static int[] swap1(int a, int b){
		
		return new int[]{b,a};
	}

}

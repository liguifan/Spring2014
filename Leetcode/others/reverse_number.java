package others;

public class reverse_number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int x=123;
			int re=reverse_int(x);
			System.out.println(re);
	}
	
	public static int reverse_int(int x){
		int r=0;
		
		while(x!=0){
			r=10*r+x%10;
			x=x/10;
		}
		
		
		return r;
	}

}

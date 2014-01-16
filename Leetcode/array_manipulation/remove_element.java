package array_manipulation;

public class remove_element {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int[] a={0,4,4,0,4,4,4,0,2};
		int[] b={1,2,2,2,4,5,6,7};
		int result=remove_element(a, 4);
		System.out.println(result);
	}
	
	
	public static int remove_element(int[] A,int element){
		int back=A.length-1;
		int mark=0;
		if(A.length==0) return 0;
		if(A.length==1){
			if(A[0]==element) return 0;
			else return 1;
		}
		
// if ,else if , else make sure every while loop, only one type of thing can be done;	
		while(mark<back){
			if(A[back]==element){
				back--;
			}
			else if(A[mark]==element){
				int temp=A[mark];
				A[mark]=A[back];
				A[back]=temp;
				mark++;
				back--;
				}
			else{
				mark++;
			}	
		}
		if(A[mark]==element) return mark;
		else	return mark+1;
	}
	
	public static void swap(int a,int b){
		int temp=a;
		a=b;
		b=temp;
		
	}

}

package FOUNDATION;

public class quick_sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int[] A={5,4,3,2,1,3};
			quicksort(A, 0, A.length-1);
			for(int x:A){
				System.out.println(x);
			}
	}
	
	
	
	public static void quicksort(int[] A,int p,int r){
		
		if(p<r){
		int q=partition(A, p, r);
		quicksort(A,p,q-1);
		quicksort(A,q+1,r);
		}
	}
	
	
	
	public static int partition(int[] A,int p,int r){
		int i=p-1;
		int x=A[r];
		int j=p;
		for(j=p;j<=r-1;j++){
			if(A[j]<=x){
				i++;
				int temp=A[i];
				A[i]=A[j];
				A[j]=temp;
			}
		}
		int temp=A[i+1];
		A[i+1]=A[r];
		A[r]=temp;
		
		return i+1;
	}
}

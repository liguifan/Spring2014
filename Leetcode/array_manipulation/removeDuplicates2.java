package array_manipulation;

public class removeDuplicates2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int[] a={1,2,2,2};
			int[] result=remove_dup(a);
			
			for(int x:result){
				System.out.println(x);
	}
	}
	
	public static int[] remove_dup(int a[]){
		int m=0;
		int s=1;
		int count=0;
		while(s<=a.length-1){
			if(a[m]==a[s]){
				count=1;
				m++;
				a[m]=a[s];
			}
			
			while(s<=a.length-1 ){
				if(a[s]==a[m]){
					s++;
				}
				else
					break;
			}
			if(m+1<=a.length-1 && s<=a.length-1){
			a[m+1]=a[s];
			m++;
			s++;
			count=0;
			}
			
		}
		
		return a;
		}
	}


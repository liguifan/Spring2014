package DP;

public class longest_increasing_sequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			int[] a={5,3,4,8,6,7};
		
			int result=LIS(a);
			System.out.println(result);
	}
	
	
	public static int LIS(int a[]){
		int len=0;
		int[] d=new int[a.length];
		for(int i=0;i<a.length;i++){
			d[i]=1;
			for(int j=0;j<i;j++){
				if(a[j]<=a[i] && d[i]<d[j]+1){
					d[i]=d[j]+1;
				}
			if(d[i]>len) len=d[i];
			}
		}
		return len;
		
	}
}

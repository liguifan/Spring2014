import java.util.ArrayList;
import java.util.Arrays;


public class MondyJava {
	public static void main(String[] args){
		
		int n=0;
		while(test(n,3)!=true){
			n++;
			//System.out.println(n);
		}
		//System.out.println(n);
		String t="liguifan";
		//System.out.println(t.charAt(3));
		//System.out.println(t.substring(0, 3));
		
		//permutation("","abc");
		//String m=getPermutation(3,3);
		Permu("","123");
		//System.out.println(list);
		
		//int[] arr=new int[n];
        
       
        
        int arr=12345;
        String s=Integer.toString(arr);
        System.out.println(s);
	}
	
	static ArrayList<String> list=new ArrayList<String>();
    
    public static String getPermutation(int n, int k) {
        int[] arr=new int[n];
        
        for(int i=0;i<n;i++){
            arr[i]=i;
        }
        String s=Arrays.toString(arr);
        Permu("", s);
        
        return list.get(k);
    }
    
    
    public static void Permu(String prefix,String str){
        if(str.length()==0){
            list.add(prefix);
            //System.out.println(prefix);
        }
        
        for(int i=0;i<str.length();i++){
            
            Permu(prefix+str.charAt(i),str.substring(0,i)+str.substring(i+1,str.length()));
            
        }
    }
	public static int steps(int n){
		return steps(n-1);
	}
	public static boolean test(int n, int day){
		if(day==1){
			if(n==1)
				return true;
			else 
				return false;
		}
		
		return test(n-(n/2+1),day-1);
	}
			
}

package arraylist;

import java.util.ArrayList;

public class permutation {
public static void main(String[] args){
		
		Permu("","abc");
		System.out.println(list);
        
       
	}
	static ArrayList<String> list=new ArrayList<String>();
	public static void Permu(String prefix,String str){
        if(str.length()==0){
            list.add(prefix);
            //System.out.println(prefix);
        }
        
        for(int i=0;i<str.length();i++){
            
            Permu(prefix+str.charAt(i),str.substring(0,i)+str.substring(i+1,str.length())); 
        }
    }

}
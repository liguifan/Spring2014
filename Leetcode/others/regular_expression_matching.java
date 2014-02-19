package others;

public class regular_expression_matching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public static boolean is_matching(String s, String p){
		
		if(p.length()==0) return s.length()==0;
		
		if(p.length()==1){
			if(s.length()!=1 || (p.charAt(0)!=s.charAt(0) && p.charAt(0)!='.'))
				return false;
			else
				return is_matching(s.substring(1), p.substring(1));
		}
		
		if(p.charAt(1)!='*'){
			if(s.length()<1 || p.charAt(0)!=s.charAt(0) && p.charAt(0)!='.')
				return false;
			return is_matching(s.substring(1), p.substring(1));
		}
		else
		{
			int i=-1;
			int len=s.length();
			while(i<len && ( i<0 || p.charAt(0)=='.'|| p.charAt(0)==s.charAt(i))){
				if(is_matching(s.substring(i+1), p.substring(2))){
					return true;
				}
				i++;
			}
			
			return false;
		}
		
		
		
	}

}

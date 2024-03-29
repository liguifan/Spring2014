package DP;

public class distinct_subsequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S="rabbbiit";
		String T="rabbit";
		int c=distinct_seqs_dp(S, T);
		System.out.println(c);
	}
	
	
	public static int distinct_seqs(String S,String T){
		int count=0;
		if(S.length()==0){
			if(T.length()==0) return 1;
			else return 0;
		}
		
		if(T.length()==0)	return 1;
		
		
		for(int i=0;i<=S.length()-1;i++){
			if(S.charAt(i)==T.charAt(0)){
				count+=distinct_seqs(S.substring(i+1), T.substring(1));
			}
		}
		
		return count;
	}
	
	public static int distinct_seqs_dp(String s, String t){
		if(s.length()==0 || t.length()==0)	return 0;
		
		int[][] dp=new int[t.length()+1][s.length()+1];
		for(int i=0;i<=s.length();i++){
			dp[0][i]=1;
		}
		
		for(int i=1;i<=t.length();i++){
			for(int j=1;j<=s.length();j++){
				dp[i][j]=dp[i][j-1]+((s.charAt(j-1)==t.charAt(i-1))?dp[i-1][j-1]:0);
			}
		}
		return dp[t.length()][s.length()];
	}

}

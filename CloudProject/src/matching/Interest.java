package matching;

public class Interest {

	/**
	 * @param args
	 */
	public static String strMatch(String s1, String s2){
		String[] ss1=s1.split(",");
		String[] ss2=s2.split(",");
		String same="";
		if(ss1.length==0){
			return same;
		}
		else {
			int num1=ss1.length;
			int num2=ss2.length;
			for (int i=0;i<num1;i++){
				for (int j=0;j<num2;j++){
					if (ss1[i].equals(ss2[j])){
						same=same+ss1[i]+",";
					}
				}
			}
		}
		return same;
	}
	
	public static String match_interest(String[] user1, String[] user2){ // return the total matched interests
		// 0 is musician, 1 is movie, 2 is teams, 3 is athlete 
		return "Musician: "+strMatch(user1[0],user2[0])+"_Movie: "+strMatch(user1[1],user2[1])+"_Teams: "+strMatch(user1[2],user2[2])+"_Athletes: "+strMatch(user1[3],user2[3]);		
		
	}
	
	public static int match_score(String str){ // return the match score
		String[] s=str.split("_");
		int value=0;
		for (int i=0;i<4;i++){;
			String[] ss=s[i].split(": ");
			String sss=ss[1];
			String[] s1=sss.split(",");
			value=value+s1.length;
		}
		return value;
	}
	
	public String ML_matching(String Userid){
		String mate="599813130";
		
		return mate;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s1={"ruichi", "ring,king","rockets,lakes","kobe,james"};
		String[] s2={"ruichi,yu,liguifan", "ring,king","rockets,lakes","kobe,james"};
		
		System.out.println(match_interest(s1,s2));
		System.out.println(match_score(match_interest(s1,s2)));
		

	}

}

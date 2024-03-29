package others;

public class longest_palindromic_substring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String test="esbtzjaaijqkgmtaajpsdfiqtvxsgfvijpxrvxgfumsuprzlyvhclgkhccmcnquukivlpnjlfteljvykbddtrpmxzcrdqinsnlsteonhcegtkoszzonkwjevlasgjlcquzuhdmmkhfniozhuphcfkeobturbuoefhmtgcvhlsezvkpgfebbdbhiuwdcftenihseorykdguoqotqyscwymtjejpdzqepjkadtftzwebxwyuqwyeegwxhroaaymusddwnjkvsvrwwsmolmidoybsotaqufhepinkkxicvzrgbgsarmizugbvtzfxghkhthzpuetufqvigmyhmlsgfaaqmmlblxbqxpluhaawqkdluwfirfngbhdkjjyfsxglsnakskcbsyafqpwmwmoxjwlhjduayqyzmpkmrjhbqyhongfdxmuwaqgjkcpatgbrqdllbzodnrifvhcfvgbixbwywanivsdjnbrgskyifgvksadvgzzzuogzcukskjxbohofdimkmyqypyuexypwnjlrfpbtkqyngvxjcwvngmilgwbpcsseoywetatfjijsbcekaixvqreelnlmdonknmxerjjhvmqiztsgjkijjtcyetuygqgsikxctvpxrqtuhxreidhwcklkkjayvqdzqqapgdqaapefzjfngdvjsiiivnkfimqkkucltgavwlakcfyhnpgmqxgfyjziliyqhugphhjtlllgtlcsibfdktzhcfuallqlonbsgyyvvyarvaxmchtyrtkgekkmhejwvsuumhcfcyncgeqtltfmhtlsfswaqpmwpjwgvksvazhwyrzwhyjjdbphhjcmurdcgtbvpkhbkpirhysrpcrntetacyfvgjivhaxgpqhbjahruuejdmaghoaquhiafjqaionbrjbjksxaezosxqmncejjptcksnoq";
		String re=longest_palindrome(test);
		System.out.println(re);
		
	}
	
	
	public static String longest_palindrome(String s){
		if(s.length()==0)	return "";
		int max=0;
		String longest="";
		for(int i=0;i<=s.length()-1;i++){
			for(int j=i+1;j<=s.length();j++){
				String temp=s.substring(i, j);
//				System.out.println(temp);
				if(palindrome(temp)){
					if(temp.length()>max){
						max=temp.length();
						longest=temp;
					}
				}
			}
		}
		
		return longest;
		
	}
	
	public static boolean palindrome(String s){
		int i=0;
		int j=s.length()-1;
		while(i<=j){
			if(s.charAt(i)!=s.charAt(j)){
				return false;
				
			}
			i++;
			j--;
		}
		return true;
	}
	
	
	public static String longest_palin(String s, int index){
		int i=index;
		int j=index;
		String longest="";
		while(i>=0 && j<=s.length()-1){
			if(s.charAt(i)!=s.charAt(j)){
				longest=s.substring(i,j+1);
				break;
			}
			i--;
			j++;
		}
		if(s.charAt(index)==s.charAt(index+1)){
			i=index;
			j=index+1;
		}
		while(i>=0 && j<=s.length()-1){
			if(s.charAt(i)!=s.charAt(j)){
				longest=s.substring(i,j+1);
				break;
			}
			i--;
			j++;
		}
		
		return longest;
		
	}

}

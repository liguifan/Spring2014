import java.io.IOException;
import java.io.StringReader;


public class test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String name="liguifan";
		StringReader s = new StringReader(name);
		
		while(true){
			System.out.println(s.read());
		}
	}
	
	
	

}

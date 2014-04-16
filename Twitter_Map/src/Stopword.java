import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Stopword {
	static String PATH="/Users/liguifan/Desktop/Twitter/";
	public static void main(String[] args) throws IOException {


		//pre_process("/Users/liguifan/Desktop/Twitter_File/LIWC.txt");
		String input = PATH+"original_input.txt";
		String output= PATH+"final_output.txt";
		String re=stop_word_string("liguifan text a book accordingly", PATH+"source/stopwords.txt");
		System.out.println(re);
		
		
		
		String m=stem_words_string("books books");
		System.out.println(m);
	}
	
	
	public static String batch_pro(String text) throws IOException{
		String step1=stop_word_string(text, PATH+"source/stopwords.txt");
		String step2=stem_words_string(step1);
		return step2;	
	}

	public static String stop_word_string(String text, String stopword_path ) throws IOException{
		BufferedReader sc=new BufferedReader(new FileReader(stopword_path));
		Set<String> stops = new HashSet<String>();
		String temp="";
		while ((temp=sc.readLine()) != null) {
			stops.add(temp);
		}
		sc.close();

		String result="";
		String[] text_arr=text.split(" ");

		for(String x:text_arr){
			System.out.println(x);
			if(!stops.contains(x)){
				result=result+x+" ";
			}
		}
		return result;
	}


	public static void batch_process(String input, String output) throws IOException{
		stop_words(input ,PATH+"source/stopwords.txt");
		stem_words(PATH+"after_stem.txt", PATH+"after_stop.txt");
		important_word(PATH+"after_stem.txt", PATH+"source/impdict.txt",output);
		System.out.println("Successfull!");
	}

	// This funciton just get rid of the stopword from original file and store it into a new file call after_file.txt
	public static void stop_words(String file_path, String stopword_path) throws IOException{
		BufferedReader sc=new BufferedReader(new FileReader(stopword_path));
		Set<String> stops = new HashSet<String>();
		String temp="";
		while ((temp=sc.readLine()) != null) {
			stops.add(temp);
			System.out.println(temp);
		}
		sc.close();
		// Save to the file
		String reg=" ";
		BufferedReader or_file=new BufferedReader(new FileReader(file_path));
		// output will be written into after_stop.txt
		BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/liguifan/Desktop/Twitter_File/after_stop.txt",true));
		String line="";
		while ((line=or_file.readLine()) != null) {
			String[] res = line.split(reg);
			System.out.println("the first is "+res[0]);
			for(String comp:res){
				try{
					if(!stops.contains(comp)){
						System.out.println(comp);
						// write into the file 
						bw.write(comp);
						bw.write(" ");
						bw.flush();
					}
				}catch(IOException ex) {
				}

			}
			bw.write("\n");


		}
		bw.close();
	}



	public static void pre_process(String file_path) throws IOException{

		BufferedReader or_file=new BufferedReader(new FileReader(file_path));
		BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/liguifan/Desktop/Twitter_File/dict.txt",true));

		String temp="";
		while ((temp=or_file.readLine()) != null) {
			if(temp.length()!=0){
				//				String temp1=temp.replaceAll("[0-9]", "");
				//				String temp2=temp1.replaceAll("\\*", "");
				//				String temp3=temp2.replace("[ \t]+$", "");
				String [] result=temp.split("\t");
				//				System.out.println((int)result[0].charAt(1));
				String temp1=result[0];
				String temp2=temp1.replaceAll("\\*", "");
				bw.write("\n");
				bw.write(temp2);
				bw.flush();
			}
		}
		bw.close();
	}
	// this keep the important words in another file (read the file from twitter after stopword processing)
	public static void important_word(String file_path, String impword_path, String output)throws IOException{
		BufferedReader sc=new BufferedReader(new FileReader(impword_path));
		Set<String> impword = new HashSet<String>();
		String temp="";

		while ((temp=sc.readLine()) != null) {
			String[] words=temp.split(" ");
			for(String word:words){
				impword.add(word);
			}
		}
		sc.close();

		BufferedReader twitter=new BufferedReader(new FileReader(file_path));
		BufferedWriter bw = new BufferedWriter(new FileWriter(output,true));
		temp="";
		while ((temp=twitter.readLine()) != null) {
			String[] words=temp.split(" ");
			for(String word:words){
				if(impword.contains(word)){
					bw.write(word);
					bw.flush();
				}
			}
			bw.write("\n");
		}
		bw.close();


	}


	public static void stem_words(String after_path, String input_path) throws IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter(after_path,true));
		char[] w = new char[501];
		Stemming s = new Stemming();
		//this for loop is for files 
		for (int i = 0; i < 1; i++)
		try
		{
				File m=new File(input_path);

				FileInputStream in = new FileInputStream(m);

				try
				{ 
					while(true){  

						int ch = in.read();
						//						System.out.println(ch);
						if (ch ==10){
							System.out.print("\n");
							bw.write("\n");
						}

						if (Character.isLetter((char) ch))
						{
							//System.out.println("the letter is "+(char) ch);
							int j = 0;
							while(true)
							{  
								//System.out.println("liguifan1");
								ch = Character.toLowerCase((char) ch);
								w[j] = (char) ch;
								if (j < 500) j++;
								ch = in.read();
								if (!Character.isLetter((char) ch))
								{
									/* to test add(char ch) */
									for (int c = 0; c < j; c++) s.add(w[c]);
									s.stem();
									{  
										String u;
										u = s.toString();
										System.out.print(u);
										bw.write(u);
										bw.flush();
									}

									break;
								}

							}
							bw.write(" ");
						}
						if (ch < 0) break;

					}

				}
				catch (IOException e)
				{  
					break;
				}

		}
		catch (FileNotFoundException e)
		{  
			System.out.println("file  not found");
			break;
		}
		bw.close();
	}


	public static String stem_words_string(String text) throws IOException{
		char[] w = new char[501];
		Stemming s = new Stemming();
		StringReader text1 = new StringReader(text);
		String result = "";
			while(true){  

				int ch = text1.read();
				//						System.out.println(ch);
				if (ch ==10){
					System.out.print("\n");
				}
				if (Character.isLetter((char) ch))
				{
					//System.out.println("the letter is "+(char) ch);
					int j = 0;
					while(true)
					{  
						ch = Character.toLowerCase((char) ch);
						w[j] = (char) ch;
						if (j < 500) j++;
						ch = text1.read();
						if (!Character.isLetter((char) ch))
						{
							/* to test add(char ch) */
							for (int c = 0; c < j; c++) s.add(w[c]);
							s.stem();
							{  
								String u = s.toString();
								result=result+u+" ";
								//System.out.print(u+" ");
							}

							break;
						}

					}
				}
				if (ch < 0) break;

			}
			return result;
			
		}
}

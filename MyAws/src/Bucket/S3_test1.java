package Bucket;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

import com.amazonaws.services.s3.AmazonS3Client;

public class S3_test1 {

	public static void main(String[] args) {
		final String PATH = "/Users/liguifan/Desktop/music/taomagan.mp3";             
		try{
			
		File song = new File(PATH); 
	    FileInputStream file1 = new FileInputStream(song); 
	    
		File trashedSong = new File("trashed.mp3"); 
		FileOutputStream trash1 = new FileOutputStream(trashedSong); 
		
		System.out.println("done");
		} catch (Exception e) { 
		            System.out.println("Error — " + e.toString()); 
		        }
		
		
		
	
	}

}

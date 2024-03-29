package DP;

import java.util.ArrayList;
import java.util.Hashtable;

import datastructure.Point;

public class find_a_path {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Point> path1=new ArrayList<Point>();
		Hashtable<Point,Boolean> cache=new Hashtable<Point,Boolean>();
		
		getPath(4,5,path1,cache);
		
		for(Point p:path1){
			System.out.println(p.x+" y "+p.y);
		}
		return;
	}

	
	public static boolean getPath(int x, int y, ArrayList<Point> path, Hashtable<Point,Boolean> cache){
		Point p=new Point(x,y);
		if(cache.containsKey(p)){
			return cache.get(p);
		}
		
		if(x==0 && y==0){
			System.out.println("why");
			return true;
		}
		
		boolean success =false;
		if(x>=1 && x!=0){
			success=getPath(x-1,y,path,cache);
		}
		if(!success && y>=1 && y!=0){
			success=getPath(x,y-1,path,cache);
		}
		if(success){
			System.out.println("test");
			path.add(p);
		}
		cache.put(p, success);
		return success;
	}
}

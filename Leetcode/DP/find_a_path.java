package DP;

import java.util.ArrayList;
import java.util.Hashtable;

import datastructure.Point;

public class find_a_path {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	public boolean getPath(int x, int y, ArrayList<Point> path, Hashtable<Point,Boolean> cache){
		Point p=new Point(x,y);
		if(cache.containsKey(p)){
			return cache.get(p);
		}
		
		if(x==0 && y==0){
			return true;
		}
		
		boolean success =false;
		if(x>=1 && x-1!=0){
			success=getPath(x-1,y,path,cache);
		}
		if(!success && y>=1 && y-1!=0){
			success=getPath(x,y-1,path,cache);
		}
		if(success){
			path.add(p);
		}
		cache.put(p, success);
		return success;
	}
}

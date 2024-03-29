package DP;

import java.util.HashMap;

import datastructure.Point;

public class unique_path_sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m=14,n=10;
		int MAX_X=100;
		int MAX_Y=100;
		 int sum=factorial(5);
		 HashMap<Point,Integer> cache=new HashMap<Point,Integer>();
		 int[][] mat=new int[MAX_X+2][MAX_Y+2];
		 for(int i=0;i<MAX_X+2;i++){
			 for(int j=0;j<MAX_Y+2;j++){
				 mat[i][j]=-1;
			 }
		 }
		 System.out.println(mat[50][50]);
		 int result=pathcal3(m,n,1,1,mat);
	    System.out.println(result);
	}
	
	public static int pathcal(int m,int n,int x,int y){
        if(x==m && y==n)
            return 1;
        if(x>m || y>n) // this means it already out of the boundary, so there is no path.
        	return 0;
           
        
            return pathcal(m,n,x+1,y)+pathcal(m,n,x,y+1);
    }
	
	 public static int factorial(int n){
         int fac=1;
     for(int i=1;i<n+1;i++){
         fac=fac*i;
     }
     return fac;
 }
	 
	 public static int pathcal2(int m, int n, int x,int y,HashMap<Point,Integer> cache){
		 Point p=new Point(x,y);
		 
		 int  sum=0;
		 if(x==m && y==n){
			 return 1;
		 }
		 
		 if(cache.containsKey(p)){
			 return cache.get(p);
		 }
		 
		 
		 if(x==m){
			 sum+=pathcal2(m,n,x,y+1,cache);
		 }
		 if(y==n){
			 sum+=pathcal2(m,n,x+1,y,cache);
		 }else{
		 sum+=pathcal2(m,n,x+1,y,cache)+pathcal2(m,n,x,y+1,cache);
		 }
		 cache.put(p, sum);
		 //System.out.println(sum);
		 return sum;
	 }
	 
	 public static int pathcal3(int m,int n,int x,int y,int mat[][]){
		 if(x==m && y==n)
	            return 1;
	        if(x>m || y>n) // this means it already out of the boundary, so there is no path.
	        	return 0;
	        
	      if(mat[x][y+1]==-1){
	    	  
	    	  mat[x][y+1]=pathcal3(m,n,x,y+1,mat);
	      }
	    	 
	      if(mat[x+1][y]==-1){
	    	  
	    	  mat[x+1][y]=pathcal3(m,n,x+1,y,mat);
	      }
	    	  
	      return mat[x+1][y]+mat[x][y+1];
	        
	 }
	
	 
}

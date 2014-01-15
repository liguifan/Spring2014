package others;

import java.util.ArrayList;

import datastructure.Interval;

public class merge_intervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	
	public static ArrayList<Interval> merge(ArrayList<Interval> intervals){
		
		
		if
			//merge this element with the first one.
		else
			//check next element 
		
		
	}
	
	public static Interval merge_interval(Interval a,Interval b){
		Interval new_interval=new Interval();
		if(a.start<b.end && a.end>=b.start){
			new_interval.start=a.start;
			new_interval.end=b.end;
		}
		
		return new_interval;
	}
}

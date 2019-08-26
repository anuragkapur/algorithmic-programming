package com.anuragkapur.misc;

import java.util.ArrayList;
import java.util.Arrays;

public class SumSet {
	
	public static int count = 0;
	
    static void sum_up_recursive(ArrayList<Integer> numbers, int target, ArrayList<Integer> partial) {
    	//System.out.println(count++);
       int s = 0;
       
       for (int x: partial) 
    	   s += x;
       
       if (s == target)
            System.out.println("sum("+Arrays.toString(partial.toArray())+")="+target);
       
       if (s >= target)
            return;
       
       for(int i=0;i<numbers.size();i++) {
             ArrayList<Integer> remaining = new ArrayList<Integer>();
             int n = numbers.get(i);
             for (int j=i+1; j<numbers.size();j++) 
            	 remaining.add(numbers.get(j));
             ArrayList<Integer> partial_rec = new ArrayList<Integer>(partial);
             partial_rec.add(n);
             sum_up_recursive(remaining,target,partial_rec);
       }
    }
    static void sum_up(ArrayList<Integer> numbers, int target) {
        sum_up_recursive(numbers,target,new ArrayList<Integer>());
    }
    public static void main(String args[]) {
        Integer[] numbers = {2,4,1,3,8,4,6};
        int target = 11;
        sum_up(new ArrayList<Integer>(Arrays.asList(numbers)),target);
    }
}
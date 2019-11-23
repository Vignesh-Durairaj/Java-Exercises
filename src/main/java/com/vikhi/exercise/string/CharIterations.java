package com.vikhi.exercise.string;

public class CharIterations {
	public void permutation(char[] outArr, char[] inputArr, int pos) {
	    if (pos == outArr.length) {
	        System.out.println(new String(outArr));
	    } else {
	        for (int i = 0 ; i < inputArr.length ; i++) {
	            outArr[pos] = inputArr[i];
	            permutation(outArr, inputArr, pos+1);
	        }
	    }
	}	
	 
	public static void main (String[] args) throws Exception {
		CharIterations ci = new CharIterations();
		char[] inputArr = new char[] {'a', 'b', 'c'};
		ci.permutation(new char[inputArr.length] , inputArr , 0);
	}
}

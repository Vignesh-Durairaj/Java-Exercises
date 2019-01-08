package com.vikhi.exercise;
import java.util.Stack;

public class MessageProcessor {

	public int getTopMostNumber(final String str) {
		Stack<Integer> myStack = new Stack<>();
		
		for (String inStr : str.split(" ")) {
			int len = myStack.size();
			
			if (inStr.equals("DUP")) {
				if (len > 0) {
					myStack.push(myStack.peek());
				} else {
					throw new IllegalArgumentException("Input Stack is empty");
				}
			} else if (inStr.equals("POP")) {
				if (len > 0) {
					myStack.pop();
				} else { 
					throw new IllegalArgumentException("Input Stack is empty");
				}
			} else if (inStr.equals("+")) {
				if (len >= 2) {
					int firstEle = myStack.pop();
					int nextEle = myStack.pop();
					myStack.push(firstEle + nextEle);
				} else {
					throw new IllegalArgumentException("Not enough elements to process");
				}
			} else if (inStr.equals("-")) {
				if (len >= 2) {
					int firstEle = myStack.pop();
					int nextEle = myStack.pop();
					myStack.push(firstEle - nextEle);
				} else {
					throw new IllegalArgumentException("Not enough elements to process");
				}
			} else {
				try {
					myStack.push(Integer.valueOf(inStr));
				} catch (NumberFormatException e) {
					throw new IllegalArgumentException("Invalid input to process");
				}
			}
		}
		
		return myStack.peek();
	}
}

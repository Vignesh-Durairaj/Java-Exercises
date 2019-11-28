package com.vikhi.exercise.string;
import java.util.ArrayDeque;
import java.util.Deque;

public class MessageProcessor {

	public int getTopMostNumber(final String str) {
		Deque<Integer> myStack = new ArrayDeque<>();
		
		for (String inStr : str.split(" ")) {
			int len = myStack.size();
			
			if ("DUP".equals(inStr)) {
				if (len > 0) {
					myStack.push(myStack.peek());
				} else {
					throw new IllegalArgumentException("Input Stack is empty");
				}
			} else if ("POP".equals(inStr)) {
				if (len > 0) {
					myStack.pop();
				} else { 
					throw new IllegalArgumentException("Input Stack is empty");
				}
			} else if ("+".equals(inStr)) {
				if (len >= 2) {
					int firstEle = myStack.pop();
					int nextEle = myStack.pop();
					myStack.push(firstEle + nextEle);
				} else {
					throw new IllegalArgumentException("Not enough elements to process");
				}
			} else if ("-".equals(inStr)) {
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

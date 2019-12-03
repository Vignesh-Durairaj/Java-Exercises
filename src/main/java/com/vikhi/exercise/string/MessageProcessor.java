package com.vikhi.exercise.string;
import static com.vikhi.util.ConstantsHelper.MSG_EMPTY_INPUT_STACK;
import static com.vikhi.util.ConstantsHelper.MSG_INSUFFICIENT_INPUT_DATA;
import static com.vikhi.util.ConstantsHelper.MSG_INVALID_NUMBER_STRING;

import java.util.ArrayDeque;
import java.util.Deque;

public class MessageProcessor {

	private Deque<Integer> myStack = new ArrayDeque<>();
	
	public int getTopMostNumber(final String str) {
		for (String inStr : str.split(" ")) {
			if ("DUP".equals(inStr)) {
				pushDuplicate();
			} else if ("POP".equals(inStr)) {
				popItem();
			} else if ("+".equals(inStr)) {
				addLastTwoItems();
			} else if ("-".equals(inStr)) {
				subtractLastTwoItems();
			} else {
				pushRandomElement(inStr);
			}
		}
		
		return myStack.peek();
	}
	
	private void pushDuplicate() {
		if (!myStack.isEmpty()) {
			myStack.push(myStack.peek());
		} else {
			throw new IllegalArgumentException(MSG_EMPTY_INPUT_STACK);
		}
	}
	
	private void popItem() {
		if (!myStack.isEmpty()) {
			myStack.pop();
		} else {
			throw new IllegalArgumentException(MSG_EMPTY_INPUT_STACK);
		}
	}
	
	private void addLastTwoItems() {
		if (myStack.size() >= 2) {
			int firstEle = myStack.pop();
			int nextEle = myStack.pop();
			myStack.push(firstEle + nextEle);
		} else {
			throw new IllegalArgumentException(MSG_INSUFFICIENT_INPUT_DATA);
		}
	}
	
	private void subtractLastTwoItems() {
		if (myStack.size() >= 2) {
			int firstEle = myStack.pop();
			int nextEle = myStack.pop();
			myStack.push(firstEle - nextEle);
		} else {
			throw new IllegalArgumentException(MSG_INSUFFICIENT_INPUT_DATA);
		}
	}
	
	private void pushRandomElement(String numberString) {
		try {
			myStack.push(Integer.valueOf(numberString));
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(MSG_INVALID_NUMBER_STRING);
		}
	}
}

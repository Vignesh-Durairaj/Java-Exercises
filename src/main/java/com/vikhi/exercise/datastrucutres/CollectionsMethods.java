package com.vikhi.exercise.datastrucutres;

import java.util.Collections;
import java.util.List;

public class CollectionsMethods {

	public int getLargestNumber (List<Integer> inputList) {
		
		if (inputList == null || inputList.size() == 0) {
			throw new IllegalArgumentException("The input array is of invalid size or may be NULL !");
		}
		
		Collections.sort(inputList);
		return inputList.get(inputList.size() - 1);
	}
}

package com.vikhi.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayMethods {

	public int getNthSmallElement (final int[] a, final int rank) {
		if (a == null || a.length < rank || rank < 1) {
			throw new IllegalArgumentException("The input array should have minimum " + rank + " number of elements");
		} 
		
		Arrays.sort(a);
		return a[rank - 1];
	}
	
	public int getNthSmallElement (final int rank, final int[] a) {
		if (a == null || a.length < rank || rank < 1) {
			throw new IllegalArgumentException("The input array should have minimum of " + rank + " elements");
		}
		
		for (int i = 0; i < a.length; i ++) {
			for (int j = i + 1; j < a.length; j ++) {
				if (a[i] > a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		
		return a[rank - 1];
	}
	
	public int getRankedElementFromArray (final int[] a, final int rank) {
		if (a == null || a.length < rank || rank < 1) {
			throw new IllegalArgumentException("The input array should have minimum " + rank + " number of elements");
		}
		
		int[] sortedArray = 
			Arrays
				.stream(a)
				.sorted()
				.distinct()
				.toArray();
		
		if (sortedArray.length < rank) {
			throw new IllegalArgumentException("No value is " + rank + "th smallest from the input array");
		}
		
		return sortedArray[rank - 1];
	}
	
	public int getFamilyNosForPlane(int totalRows, String reservedSeats) 
			throws  IllegalStateException{
        
        Map<Character, Integer> columnMap = new HashMap<>();
		columnMap.put('A', 0);
		columnMap.put('B', 1);
		columnMap.put('C', 2);
		columnMap.put('D', 3);
		columnMap.put('E', 4);
		columnMap.put('F', 5);
		columnMap.put('G', 6);
		columnMap.put('H', 7);
		columnMap.put('J', 8);
		columnMap.put('K', 9);
		
		int[][] seatArr = new int[totalRows][10];
        	if (reservedSeats != null && !reservedSeats.isEmpty()) {
        		String[] strArr = reservedSeats.split(" ");
        	    for (String str : strArr) {
	        		int len = str.length();
	        		int row = 0;
	        		Integer col = columnMap.get(str.charAt(len - 1));
	        		
	        		try {
	        			row = Integer.valueOf(str.substring(0, len - 1)) - 1;
	        		} catch (NumberFormatException e) {
	        			throw new IllegalArgumentException("Invalid Row number specified");
	        		}
	        		
	        		if (col == null || row >= totalRows) {
	        			throw new IllegalArgumentException("Invalid Column ID specified");
	        		} else {
	        			seatArr[row][col] = 1;
	        		}
        	}
		}
		
		int familyCount = 0;
		for (int i = 0; i < totalRows; i ++) {
			if (seatArr[i][0] == 0 && seatArr[i][1] == 0 && seatArr[i][2] == 0) {
				familyCount ++;
			}
			
			if ((seatArr[i][3] == 0 && seatArr[i][4] == 0 && seatArr[i][5] == 0) || 
					(seatArr[i][4] == 0 && seatArr[i][5] == 0) && seatArr[i][6] == 0){
				familyCount ++;
			}
			
			if (seatArr[i][7] == 0 && seatArr[i][8] == 0 && seatArr[i][9] == 0) {
				familyCount ++;
			}
		}
		
		return familyCount;
    }
	
	public int[] frequencySortArray (final int[] inArr) {
		
		if(inArr == null) {
			throw new IllegalArgumentException("Input Array Should not be null");
		}
		
		Map<Integer, Integer> countMap = new HashMap<>();
		List<Integer> myList = Arrays.stream(inArr).boxed().collect(Collectors.toList());
		for (int num : myList) {
			if (countMap.containsKey(num)) {
				countMap.put(num, countMap.get(num) + 1);
			} else {
				countMap.put(num, 1);
			}
		}
		
		List<Entry<Integer, Integer>> entryList = new ArrayList<>(countMap.entrySet());
		entryList.sort((e1, e2) -> {
			if (e1.getValue() > e2.getValue()) {
				return -1;
			} else if (e1.getValue() < e2.getValue()) {
				return 1;
			} else {
				if (myList.indexOf(e1.getKey()) < myList.indexOf(e2.getKey())) {
					return -1;
				} else {
					return 1;
				}
			}
		});
		
		int[] outArr = new int[inArr.length];
		int i = 0;
		for (Entry<Integer, Integer> entry : entryList) {
			for (int num = 1; num <= entry.getValue(); num ++){
				outArr[i] = entry.getKey();
				i ++;
			}
		}
		
		return outArr;
	}
	
	public int function(Integer[] A, int K, int l){
        int sum = 0;

        Integer[] maxArrayIndices = getMaxArrayIndices(A, K);
        sum+=maxArrayIndices[0];
        Integer[] leadingElements = Arrays.copyOfRange(A, 0, maxArrayIndices[1]);
        Integer[] trailingElements = Arrays.copyOfRange(A, (maxArrayIndices[1]+K), A.length);

        List<Integer> mergedLeadingAndTrailingElements = new ArrayList<Integer>(Arrays.asList(leadingElements));
        mergedLeadingAndTrailingElements.addAll(Arrays.asList(trailingElements));
        Integer[] mergedLeadingAndTrailingElementsArray =  mergedLeadingAndTrailingElements.toArray(new Integer[0]);

        maxArrayIndices = getMaxArrayIndices(mergedLeadingAndTrailingElementsArray, l);
        sum+=maxArrayIndices[0];
        return sum;
    }

    private Integer[] getMaxArrayIndices(Integer[] A, int N){
        Integer[] maxArrayIndices = new Integer[2];
        int sumFromStart = 0; 
        int sumFromPrev = 0; 
        int tmpIdx = 0;
        
        for(int i = 0; i < A.length; i++){
            if(i <= A.length - N) {
                for (int j = i; j < i + N; j++) {
                    sumFromStart += A[j];
                }
            }

            if(sumFromStart >  sumFromPrev) {
                sumFromPrev = sumFromStart;
                tmpIdx = i;
            }
            
            sumFromStart = 0;
        }
        
        maxArrayIndices[0] = sumFromPrev;
        maxArrayIndices[1] = tmpIdx;
        return maxArrayIndices;
    }
    
    public int getSmallestSum(int[] intArr) {
		
		if (intArr == null || intArr.length < 4) {
			throw new IllegalArgumentException("Input Array is either NULL or empty");
		}
		
		List<Integer> newList = Arrays
				.stream(intArr)
				.boxed()
				.collect(Collectors.toList());
		
		newList.remove(0); // length reduced to size - 1
		newList.remove(intArr.length - 2); // Or move this original line above removing 0th element
		
		Collections.sort(newList); // Sorted the input array 
		return newList.get(0) + newList.get(1);
	}
    
    
    public int getSmallestSumUsingStream(int[] intArr) {
    	if (intArr == null || intArr.length < 4) {
			throw new IllegalArgumentException("Input Array is either NULL or empty");
		}
    	
    	return IntStream
    			.range(1, intArr.length - 1)
        		.map(idx -> intArr[idx])
        		.sorted()
        		.limit(2)
        		.sum();
    }
	
	public int smallestNotAdjacentSum(int[] intArr) {
		
		if (intArr == null || intArr.length < 5) {
			throw new IllegalArgumentException("Input Array is either NULL or insufficient numbers");
		}
		
		List<Integer> newList = Arrays
				.stream(intArr)
				.boxed()
				.collect(Collectors.toList());
		
		newList.remove(intArr.length - 1);
		newList.remove(0); 
		
		int smallestSum = Integer.MAX_VALUE;
		for (int i = 0; i < newList.size() - 1; i++) {
			for (int j = i + 2; j < newList.size(); j ++ ) {
				int sumVal = newList.get(i) + newList.get(j);
				if (sumVal < smallestSum) {
					smallestSum = sumVal;
				}
			}
		}
		return smallestSum;
	}
}

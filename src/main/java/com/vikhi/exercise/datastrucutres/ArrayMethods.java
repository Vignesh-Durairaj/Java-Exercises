package com.vikhi.exercise.datastrucutres;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.log4j.Logger;

public class ArrayMethods {

	private static final String NUMBER_STRING = "0123456789";
	private final Logger log = Logger.getLogger(ArrayMethods.class);
	
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
	
	public int getFamilyNosForPlane(int totalRows, String reservedSeats) {
        
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
		
		
		
		return getFamilyCount(totalRows, seatArr);
    }
	
	public int[] frequencySortArray (final int[] inArr) {
		
		if(inArr == null) {
			throw new IllegalArgumentException("Input Array Should not be null");
		}
		
		List<Integer> myList = convertArrayToList(inArr);
		Map<Integer, Integer> countMap = getCountMap(myList);
		List<Entry<Integer, Integer>> entryList = getSortedEntryList(myList, countMap);
		
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
	
	public int function(Integer[] inputArray, int lowerBound, int upperBound){
        int sum = 0;

        Integer[] maxArrayIndices = getMaxArrayIndices(inputArray, lowerBound);
        sum+=maxArrayIndices[0];
        Integer[] leadingElements = Arrays.copyOfRange(inputArray, 0, maxArrayIndices[1]);
        Integer[] trailingElements = Arrays.copyOfRange(inputArray, (maxArrayIndices[1]+lowerBound), inputArray.length);

        List<Integer> mergedLeadingAndTrailingElements = new ArrayList<>(Arrays.asList(leadingElements));
        mergedLeadingAndTrailingElements.addAll(Arrays.asList(trailingElements));
        Integer[] mergedLeadingAndTrailingElementsArray =  mergedLeadingAndTrailingElements.toArray(new Integer[0]);

        maxArrayIndices = getMaxArrayIndices(mergedLeadingAndTrailingElementsArray, upperBound);
        sum+=maxArrayIndices[0];
        return sum;
    }

    private Integer[] getMaxArrayIndices(Integer[] inputArray, int limit){
        Integer[] maxArrayIndices = new Integer[2];
        int sumFromStart = 0; 
        int sumFromPrev = 0; 
        int tmpIdx = 0;
        
        for(int i = 0; i < inputArray.length; i++){
            if(i <= inputArray.length - limit) {
                for (int j = i; j < i + limit; j++) {
                    sumFromStart += inputArray[j];
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
	
	public boolean getStatistics(final int[] intArr) {
		if (intArr == null || intArr.length < 2) {
			throw new IllegalArgumentException("Input array is either null or containing insufficient data");
		}
		
		IntSummaryStatistics stats = 
				IntStream
					.range(0, intArr.length)
					.map(idx -> intArr[idx])
					.filter(ele -> ele > 0)
					.summaryStatistics();
	
		log.info("Max Value : " + stats.getMax());
		log.info("Min Value : " + stats.getMin());
		log.info("Total Value : " + stats.getSum());
		log.info("Total Entries : " + stats.getCount());
		log.info("Average Value : " + stats.getAverage());
		return true;
	}
	
	public boolean isNumeric(final String s) {
		if (s == null || s.trim().equals("")) {
			throw new IllegalArgumentException("Input string is not valid");
		}
		
		for(char c : s.toCharArray()){
			if (NUMBER_STRING.indexOf(c) < 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public int[] reverseArray (final int[] inputArr) {
		int arrSize = inputArr.length;
		int[] newArr =  new int[inputArr.length];
		for (int i = 0; i < arrSize; i ++) {
		    newArr[i] = inputArr[arrSize - 1 - i];
		}
		
		return newArr;
	}
	
	public int[] reverseArrayWithStreams (final int[] inputArr) {
		int arrSize = inputArr.length;
		return IntStream
				.range(0, arrSize)
				.map(idx -> inputArr[arrSize - 1 - idx])
				.toArray();
	}
	
	/**
	 * Reverses the array passed as a parameter, without using another array as intermediate
	 * 
	 * @param inputArr - The array to be reversed. The same parameter passed will be reversed
	 */
	public void reverseArraySmartly (int[] inputArr) {
		int arrLength = inputArr.length; 
		int j = arrLength - 1;
		int median = (inputArr.length / 2) - (arrLength % 2 == 0 ? 1 : 0);
		
		for (int i = 0; inputArr.length > 0 && i <= median; i ++, j --) {
			int temp = inputArr[i];
			inputArr[i] = inputArr[j];
			inputArr[j] = temp;
		}
	}
	
	private int getFamilyCount(final int totalRows, final int[][] seatArr) {
		int familyCount = 0;
		for (int i = 0; i < totalRows; i ++) {
			
			int freeFirstColumn = (seatArr[i][0] == 0 && seatArr[i][1] == 0 && seatArr[i][2] == 0) ? 1 : 0;
			int freeSecondColumn = ((seatArr[i][3] == 0 && seatArr[i][4] == 0 && seatArr[i][5] == 0) || 
					(seatArr[i][4] == 0 && seatArr[i][5] == 0) && seatArr[i][6] == 0) ? 1 : 0;
			int freeThirdColumn = (seatArr[i][7] == 0 && seatArr[i][8] == 0 && seatArr[i][9] == 0) ? 1 : 0;
			
			familyCount += (freeFirstColumn + freeSecondColumn + freeThirdColumn);
		}
		
		return familyCount;
	}
	
	private Map<Integer, Integer> getCountMap (final List<Integer> inputList) {
		Map<Integer, Integer> countMap = new HashMap<>();
		for (int num : inputList) {
			if (countMap.containsKey(num)) {
				countMap.put(num, countMap.get(num) + 1);
			} else {
				countMap.put(num, 1);
			}
		}
		
		return countMap;
	}
	
	private List<Integer> convertArrayToList(final int[] inArr) {
		return Arrays.stream(inArr).boxed().collect(Collectors.toList());
	}
	
	private List<Entry<Integer, Integer>> getSortedEntryList (final List<Integer> inputList, final Map<Integer, Integer> frequencyCountMap) {
		List<Entry<Integer, Integer>> entryList = new ArrayList<>(frequencyCountMap.entrySet());
		entryList.sort((e1, e2) -> {
			if (e1.getValue() > e2.getValue()) {
				return -1;
			} else if (e1.getValue() < e2.getValue()) {
				return 1;
			} else {
				if (inputList.indexOf(e1.getKey()) < inputList.indexOf(e2.getKey())) {
					return -1;
				} else {
					return 1;
				}
			}
		});
		
		return entryList;
	}
}

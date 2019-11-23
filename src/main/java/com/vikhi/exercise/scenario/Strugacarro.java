package com.vikhi.exercise.scenario;

import java.util.Arrays;

public class Strugacarro {

	public String getHighAmplitudeSeason(int[] T) {
        
        int days = T.length/4;
        int startIdx = 0;
        int maxAmplitude = 0;
        String season = "";
        int[] winterArray = Arrays.copyOfRange(T, startIdx, startIdx + days);
        int[] springArray = Arrays.copyOfRange(T, startIdx + days, startIdx + (days * 2));
        int[] summerArray = Arrays.copyOfRange(T, startIdx + (days * 2), startIdx + (days * 3));
        int[] autumnArray = Arrays.copyOfRange(T, startIdx + (days * 3), startIdx + (days * 4));
        
        Arrays.sort(winterArray);
        Arrays.sort(springArray);
        Arrays.sort(summerArray);
        Arrays.sort(autumnArray);
        
        int winterAmplitude = winterArray[winterArray.length - 1] - winterArray[0];
        int springAmplitude = springArray[springArray.length - 1] - springArray[0];
        int summerAmplitude = summerArray[summerArray.length - 1] - summerArray[0];
        int autumnAmplitude = autumnArray[autumnArray.length - 1] - autumnArray[0];
        
        if (winterAmplitude > maxAmplitude) {
        	maxAmplitude = winterAmplitude;
        	season = "WINTER";
        } 
        
        if (springAmplitude > maxAmplitude) {
        	maxAmplitude = springAmplitude;
        	season = "SPRING";
        }
        
        if (summerAmplitude > maxAmplitude) {
        	maxAmplitude = summerAmplitude;
        	season = "SUMMER";
        }
        
        if (autumnAmplitude > maxAmplitude) {
        	maxAmplitude = autumnAmplitude;
        	season = "AUTUMN";
        }
        return season;
    }
}

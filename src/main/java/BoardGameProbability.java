import java.math.BigInteger;

import com.vikhi.exercise.NumberCompositions;

public class BoardGameProbability {

	public BigInteger getDiceCompositions (int n) {
		BigInteger[] probabilityCount = new BigInteger [n + 1];
		probabilityCount[0] = BigInteger.valueOf(1);
		
		if (n > 0) {
			probabilityCount[1] = BigInteger.valueOf(1);
		}
		
		for(int i = 2; i < n + 1; i ++) {
	        for(int j = 1; (j <= 6 && (i - j) >= 0) ; j ++) {
	        	if (probabilityCount[i] == null){
	        		probabilityCount[i] = BigInteger.ZERO;
	        	}
	        	probabilityCount[i] = probabilityCount[i].add(probabilityCount[i - j]);
	        }
	    }
		
		return probabilityCount[n];
	}
	
	public static void main(String[] args) {
		NumberCompositions numberCompositions = new NumberCompositions();
		System.out.println(numberCompositions.getDiceCompositions(610));
	}
}

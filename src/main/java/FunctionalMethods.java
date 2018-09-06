import java.math.BigInteger;

public class FunctionalMethods {

	public BigInteger getValueUsingArrays (final int position) {
		if (position < 0) {
			throw new IllegalArgumentException("Input position should be a positive integer");
		} else {
			BigInteger[] funcionValueArr = new BigInteger[position + 1];
			funcionValueArr[0] = BigInteger.ZERO;
			
			if (position >= 1) {
				funcionValueArr[1] = BigInteger.valueOf(1);
			}

			processFuntion(position, funcionValueArr);
			return funcionValueArr[position];
		}
	}
	
	private BigInteger processFuntion (final int position, final BigInteger[] funcionValueArr) {
		if (funcionValueArr[position] != null) {
			return funcionValueArr[position];
		} else if (position >= 2) {
			BigInteger newValue = processFuntion(position - 1, funcionValueArr).add(processFuntion(position - 2, funcionValueArr));
			funcionValueArr[position] = newValue;
			return newValue;
		} else {
			return funcionValueArr[position];
		}
	}
	
	public static void main(String[] args) {
		long startTime, endTime;
		FunctionalMethods functionalMethods = new FunctionalMethods();
		
		startTime = System.currentTimeMillis();
		System.out.println(functionalMethods.getValueUsingArrays(8181));
		endTime = System.currentTimeMillis();
		System.out.println("Time taken to evaluate using Fast process Array : " + (endTime - startTime) + "ms");
	}
}

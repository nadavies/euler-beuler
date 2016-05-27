package nd.projecteuler.problems.onehundred;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem119 {
	// Ugly and a big wrong, relies on producing enough values that the lower end of the range is included.
	private static final BigInteger BI_0 = BigInteger.valueOf(0);
	private static final BigInteger BI_10 = BigInteger.valueOf(10);

	static final class Result implements Comparable<Result> {
		private final BigInteger value;
		private final int base;
		private final int exponent;
		
		public Result(BigInteger value, int base, int exponent) {
			this.value = value;
			this.base = base;
			this.exponent = exponent;
		}

		public String toString() {
			return value.toString() + " = " + base + "^" + exponent;
		}

		@Override
		public int compareTo(Result o) {
			return value.compareTo(o.value);
		}
	}
	
	public static void main(String[] args) {
		List<Result> results = new ArrayList<>();
		for ( BigInteger base = BigInteger.valueOf(2); base.intValue() < 1000; base = BigInteger.valueOf(base.longValue()+1) ) {
			for (int exp = 1; exp < 100; exp++ ) {
				BigInteger val = base.pow(exp);
				
				BigInteger remainder = val;
				int digitSum = 0;
				while (! remainder.equals(BI_0)) {
					digitSum += remainder.mod(BI_10).intValue();
					remainder = remainder.divide(BI_10);
				}
				
				if (digitSum  == base.intValueExact() && val.compareTo(BI_10) >= 0) {
					results.add(new Result(val, base.intValue(), exp));
				}
			}
		}
		System.out.println(results.size() + " results:");
		Collections.sort(results);
		for (int i=0; i<results.size(); i++) {
			System.out.println((i+1) + ": " + results.get(i));
		}
	}

}

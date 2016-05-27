package nd.projecteuler.problems.zero;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem23 {

	public static void main(String[] args) {
		List<Integer> abundantNumbers = new ArrayList<>();
		
		for (int v=12; v<28123; v++) {
			Set<Integer> divisors = new HashSet<>();
			int limit = (int)Math.floor(Math.sqrt(v));
			for (int i=1; i<=limit; i++) {
				if (v % i == 0) {
					divisors.add(i);
					if (i != 1) {
						divisors.add(v/i);
					}
				}
			}
			int sum = 0;
			for (int d : divisors) {
				sum += d;
			}
			if (sum > v) {
				abundantNumbers.add(v);
			}
		}
		
		boolean[] possibles = new boolean[28123];
		for (int i=0; i<abundantNumbers.size(); i++) {
			int pi = abundantNumbers.get(i);
			for (int j=i; j<abundantNumbers.size(); j++) {
				int pj = abundantNumbers.get(j);
				if (pi+pj < possibles.length) {
					possibles[pi+pj] = true;
				}
			}
		}
		long sum = 0;
		for (int i=0; i<possibles.length; i++) {
			if (!possibles[i]) {
				sum += i;
			}
		}
		System.out.println(sum);
	}

}

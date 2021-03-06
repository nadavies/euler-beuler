package nd.projecteuler.problems.zero;

import nd.projecteuler.util.PrimeSieve;

public class Problem10 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PrimeSieve sieve = PrimeSieve.allPrimesLessThan(2000000);
		long total=0;
		for (long p : sieve.allPrimes(2000000)) {
			total += p;
		}
		System.out.println("total: " + total);
	}

}

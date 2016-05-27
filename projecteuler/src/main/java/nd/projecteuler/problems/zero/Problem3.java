package nd.projecteuler.problems.zero;

import nd.projecteuler.util.PrimeSieve;

public class Problem3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PrimeSieve sieve = new PrimeSieve();
		System.out.println("Largest factor is " + sieve.largestFactor(600851475143L));
	}

}

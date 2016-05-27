package nd.projecteuler.problems.zero;

import java.util.List;

import nd.projecteuler.util.PrimeSieve;

public class Problem7 {
	public static void main(String[] args) {
		PrimeSieve s = new PrimeSieve();
		
		long start = System.currentTimeMillis();
		List<Long> primes = s.allPrimes(200000);
		System.out.println("Done in " + (System.currentTimeMillis()-start) + "ms");
		System.out.println(primes.get(10000));
	}
}

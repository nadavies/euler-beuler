package nd.projecteuler.problems.zero;

import java.util.ArrayList;
import java.util.List;

import nd.projecteuler.util.PrimeSieve;

public class Problem35CircularPrimes {
	
	public static void main(String[] args) {
		List<Integer> results = new ArrayList<>();
		PrimeSieve sieve = PrimeSieve.allPrimesLessThan(1000000);
		for (int n=1; n<1000000; n++) {
			if (sieve.isPrime(n)) {
				boolean isCircular = true;
				int rotated = n;
				int length = (int)Math.ceil(Math.log10(n));
				int exp = (int)Math.pow(10, length-1);
				for (int r=1; r<length; r++) {
					rotated = rotated/10 + (exp*(rotated%10));
					if (!sieve.isPrime(rotated)) {
						isCircular = false;
					}
				}
				if (isCircular) {
					results.add(n);
				}
			}
		}
		System.out.println("" + results.size() + " circular primes");
		results.forEach(System.out::println);
	}

}

package nd.projecteuler.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of Sieve of Eratosthenes for problems that need lots of lowish primes.
 * @author ndavies
 */
public class PrimeSieve {
	private final byte[] sieve;
	
	private PrimeSieve(int maxVal) {
		if (maxVal / 8 >= Integer.MAX_VALUE) {
			throw new IndexOutOfBoundsException("Can't create sieve");
		}
		this.sieve = new byte[(int)(maxVal / 8) + 1];
		int maxFactor = (int) Math.floor(Math.sqrt(maxVal));
		for (int i = 2; i <= maxFactor; i++) {
			if ((sieve[byteFor(i)] & (1 << bitFor(i))) == 0) {
				// i is prime; mark all multiples of it as composite
				for (int product = 2 * i; product <= maxVal; product += i) {
					sieve[byteFor(product)] |= (byte) (1 << bitFor(product));
				}
			}
		}
	}
	
	/**
	 * Find all prime numbers less or equal to the specified upper limit. 
	 * @param max
	 * 
	 * @return
	 */
	public static PrimeSieve allPrimesLessThan(int max) {
		return new PrimeSieve(max);
	}
	
	public int getHighestPrime(long upperLimit) {
		int lastBit = bitFor(upperLimit + 1);
		boolean lastByte = true;
		// find the last 0 bit
		for (int byteNo = sieve.length - 1; byteNo >= 0; byteNo--) {
			if (sieve[byteNo] < 0xFF) {
				for (int bitNo = lastByte ? lastBit : 7; bitNo >= 0; bitNo--) {
					if ((sieve[byteNo] & (byte) (1 << bitNo)) == 0) {
						return byteNo * 8 + bitNo;
					}
				}
			}
			lastByte = false;
		}

		return 0;
	}

	public static int largestFactor(long composite) {
		int factorLimit = (int)Math.sqrt(composite);
		PrimeSieve sieve = allPrimesLessThan( factorLimit );
		
		for (int i=2; i<factorLimit; ) {
			if (sieve.isPrime(i)) {
				if (composite == i) {
					return i;
				} else if (composite % i == 0) {
					System.out.println("Factor of " + i);
					composite /= i;
				} else {
					i++;
				}
			} else {
				i++;
			}
		}
		return 0;
	}
	
	public boolean isPrime(long n) {
		return n >=2 && (( sieve[byteFor(n)] & (1<<bitFor(n))) == 0 );
	}
	
	public List<Long> allPrimes(int limit) {
		ArrayList<Long> res = new ArrayList<Long>();
		for (long i=2; i<=limit; i++) {
			if (isPrime(i)) {
				res.add(i);
			}
		}
		return res;
	}
	


	private int byteFor(long i) {
		return (int)(i / 8);
	}

	private int bitFor(long i) {
		return (int)(i % 8);
	}

}

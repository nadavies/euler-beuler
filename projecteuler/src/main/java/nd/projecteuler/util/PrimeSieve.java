package nd.projecteuler.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of Sieve of Eratosthenes for problems that need lots of lowish primes.
 * @author ndavies
 */
public class PrimeSieve {
	public int getHighestPrime(long upperLimit) {
		byte[] sieve = sieve(upperLimit);

		// Set all bits after upperLimit to 1; they may be prime but we're not
		// interested in them here
		int lastBit = bitFor(upperLimit + 1);

		for (int i = lastBit; i < 8; i++) {
			sieve[sieve.length - 1] |= (byte) (1 << i);
		}

		// find the last 0 bit
		for (int byteNo = sieve.length - 1; byteNo >= 0; byteNo--) {
			if (sieve[byteNo] < 0xFF) {
				for (int bitNo = 7; bitNo >= 0; bitNo--) {
					if ((sieve[byteNo] & (byte) (1 << bitNo)) == 0) {
						return byteNo * 8 + bitNo;
					}
				}
			}
		}

		return 0;
	}

	public int largestFactor(long composite) {
		int factorLimit = (int)Math.sqrt(composite);
		// A composite number can have at most one prime factor larger than its square root..?
		byte[] primes = sieve( factorLimit );
		
		for (int i=2; i<factorLimit; ) {
			if (isPrime(primes, i)) {
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
	
	public boolean isPrime(byte[] sieve, long n) {
		return n >=2 && (( sieve[byteFor(n)] & (1<<bitFor(n))) == 0 );
	}
	
	public List<Long> allPrimes(int limit) {
		byte[] primes = sieve(limit);
		ArrayList<Long> res = new ArrayList<Long>();
		for (long i=2; i<=limit; i++) {
			if (isPrime(primes, i)) {
				res.add(i);
			}
		}
		return res;
	}
	/**
	 * 
	 * Return a bitmap array indicating all prime numbers less or equal to the
	 * specified upper limit. A 1 in the array indicates the corresponding
	 * number is composite.
	 * 
	 * @param maxVal
	 * 
	 * @return
	 */

	public byte[] sieve(long maxVal) throws IndexOutOfBoundsException {
		if (maxVal / 8 >= Integer.MAX_VALUE) {
			throw new IndexOutOfBoundsException("Can't create sieve");
		}
		byte[] sieve = new byte[(int)(maxVal / 8) + 1];
		int maxFactor = (int) Math.floor(Math.sqrt(maxVal));
		for (int i = 2; i <= maxFactor; i++) {
			if ((sieve[byteFor(i)] & (1 << bitFor(i))) == 0) {
				// i is prime; mark all multiples of it as composite
				for (int product = 2 * i; product <= maxVal; product += i) {
					sieve[byteFor(product)] |= (byte) (1 << bitFor(product));
				}
			}
		}

		return sieve;

	}

	private int byteFor(long i) {
		return (int)(i / 8);
	}

	private int bitFor(long i) {
		return (int)(i % 8);
	}

	public static void main(String[] args) {

		PrimeSieve sp = new PrimeSieve();

		int testVal = 4000000;

		int res2 = sp.getHighestPrime(testVal);

		System.out.println("Calculating largest prime less than " + testVal);

		System.out.println("PrimeSieve got result " + res2);

	}

}

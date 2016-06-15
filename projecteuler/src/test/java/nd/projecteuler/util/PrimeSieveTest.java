package nd.projecteuler.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class PrimeSieveTest {

	@Test
	public void test() {
		PrimeSieve s = PrimeSieve.allPrimesLessThan(100);
		assertFalse(s.isPrime(0));
		assertFalse(s.isPrime(1));
		assertTrue(s.isPrime(2));
		assertFalse(s.isPrime(4));
		assertTrue(s.isPrime(7));
		assertTrue(s.isPrime(97));
		assertFalse(s.isPrime(98));
	}

}

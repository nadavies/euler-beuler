package nd.projecteuler.problems.zero;

import java.util.HashSet;
import java.util.Set;

public class Problem32Pandigital {
	public static void main(String[] args) {
		Set<Long> perms = new HashSet<>();
		
		long start = System.currentTimeMillis();
		for (int i=0; i<362880; i++) {
			perms.add(longValue(permutation(i)));
		}
		
		System.out.println("Done in " + (System.currentTimeMillis()-start) + "ms");
		System.out.println("Permutations: " + perms.size());
		for (int i=0; i<10; i++) {
			System.out.println("Perm " + i + ": " + longValue(permutation(i)));
		}
	}
	
	private static long longValue(byte[] digits) {
		long v = 0;
		for (int i=0; i<digits.length; i++) {
			v = v*10 + (digits[i]&0xFF);
		}
		return v;
	}
	
	public static byte[] permutation(int n) {
		byte[] digits = {1,2,3,4,5,6,7,8,9};
		
		byte[] b = new byte[9];
		
		for (int i=0; i<9; i++) {
			int j = 9-i;
			b[i] = selectUnused((n%j), digits);
			n /= j;
		}
		return b;
	}
	
	// Select the nth unused digit and mark is as used.
	private static byte selectUnused(int nth, byte[] digits) {
		nth++;
		int n=0;
		for (int i=0; i<digits.length; i++) {
			if (digits[i] != 0) {
				n++;
			}
			if (n == nth) {
				int v = digits[i];
				digits[i] = 0;
				return (byte)v;
			}
		}
		return 0;
	}
}

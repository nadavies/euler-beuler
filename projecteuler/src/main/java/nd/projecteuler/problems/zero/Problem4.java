package nd.projecteuler.problems.zero;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem4 {
	private static List<Integer> generatePalindromes() {
		List<Integer> palindromes = new ArrayList<Integer>();

		for (int a = 9; a > 0; a--) {
			for (int b = 9; b >= 0; b--) {
				for (int c = 9; c >= 0; c--) {
					palindromes.add(100001 * a + 10010 * b + 1100 * c);
				}
			}
		}

		return palindromes;
	}

	public static void main(String[] args) {
		List<Integer> palindromes = generatePalindromes();
		Collections.sort(palindromes);
		/*
		for (Integer i : palindromes) {
			System.out.println(i);
		}
		System.out.println("Generated " + palindromes.size() + " palindromes");
		*/
		System.out.println("Factorisable palindromes:");
		List<String> results = new ArrayList<String>();
		for (int j=100; j<=999; j++) {
			for (int k=j; k<=999; k++) {
				if (Collections.binarySearch(palindromes, (j*k)) > 0) {
					results.add( (j*k) + " = " + j + "*" + k);
				}
			}
		}
		Collections.sort(results);
		for (String s: results) {
			System.out.println(s);
		}
	}
}

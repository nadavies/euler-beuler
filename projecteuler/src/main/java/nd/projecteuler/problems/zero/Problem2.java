package nd.projecteuler.problems.zero;

public class Problem2 {
	private static final int MAX = 4000000;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 1;
		int b = 2;
		int total = 0;
		while (b <= MAX) {
			System.out.print(b);
			if ( (b&1) == 0) {
				total += b;
				System.out.println(" *");
			} else {
				System.out.println();
			}
			int t=b;
			b += a;
			a = t;
		}
		System.out.println("Total: " + total);
	}

}

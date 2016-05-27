package nd.projecteuler.problems.zero;

public class Problem1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int count = 0;
		for (int i=1; i<334; i++) {
			count += i*3;
		}
		for (int i=1; i<200; i++) {
			if (i%3!=0) {
				count += i*5;
			}
		}
		
		System.out.println("pass 1: " + count);
		
		count = 0;
		
		boolean[] n = new boolean[1000];
		for (int i=3; i<1000; i+=3) {
			n[i] = true;
		}
		for (int i=5; i<1000; i+=5) {
			n[i] = true;
		}
		count = 0;
		for (int i=0; i<1000; i++) {
			if (n[i]) {
				count += i;
			}
		}
		System.out.println("pass 2: " + count);
	}

}

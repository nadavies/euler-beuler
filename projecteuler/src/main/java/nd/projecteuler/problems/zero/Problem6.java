package nd.projecteuler.problems.zero;

public class Problem6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long sumofsq = 0;
		long sqofsum = 0;
		for (int i=1; i<=100; i++) {
			sumofsq += (i*i);
			sqofsum += i;
		}
		sqofsum *= sqofsum;
		System.out.println(sqofsum + "-" + sumofsq + " = " + (sqofsum-sumofsq));
	}

}

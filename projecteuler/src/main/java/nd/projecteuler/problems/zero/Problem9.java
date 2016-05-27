package nd.projecteuler.problems.zero;

public class Problem9 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * a^2 + b^2 = c^2		for natural numbers a,b,c
		 * a+b+c=1000	-> c=1000-a-b
		 * ...
		 * a^2 + b^2 = (1000-a-b)^2
		 * a^2 + b^2 = 1000^2 - 1000a - 1000b - 1000a + a^2 + ab - 1000b + ab + b^2
		 * a^2 + b^2 = 1000000 - 2000a - 2000b + a^2 +  b^2 + 2ab
		 * 		   0 = 500000 - 1000a - 1000b + ab
		 *    500000 = 1000a + 1000b - ab
		 *    	   a = (500000 - 1000b) / (1000-b)
		 */
		
		int b;
		for (b=1; b<1000; b++) {
			if ( (500000 - 1000*b) % (1000-b) == 0) {
				break;
			}
		}
		int a = (500000 - 1000*b) / (1000-b);
		int c = 1000 - a - b;
		System.out.println(a + "^2 + " + b + "^2 = " + c + "^2");
		System.out.println(a*b*c);
	}

}

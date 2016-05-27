package nd.projecteuler.problems.zero;

public class Problem30 {
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		long result = 0;
		int iterations = 10000;
		for (int i=0; i<iterations; i++) {
			result = v2();
		}
		long end = System.currentTimeMillis();
		
		System.out.println("Result: " + result);
		System.out.println("Time : " + ((double)end-start)/iterations + "ms");
	}
	
	private static long v2() {
		long result = 0;
		int[] powers = {
				0,
				1,
				2*2*2*2*2,
				3*3*3*3*3,
				4*4*4*4*4,
				5*5*5*5*5,
				6*6*6*6*6,
				7*7*7*7*7,
				8*8*8*8*8,
				9*9*9*9*9
		};
		int an, bn, cn, dn, en;
		
		// Maximum possible value is 6*9^5 = 354294, since 7*9^5 < 10^7
		for (int a=0; a<4; a++) {
			an = a*100000;
			for (int b=0; b<10; b++) {
				bn = b*10000;
				for (int c=0; c<10; c++) {
					cn = c*1000;
					for (int d=0; d<10; d++) {
						dn = d*100;
						for (int e=0; e<10; e++) {
							en = e*10;
							for (int f=0; f<10; f++) {
								int sumOfPowers = powers[a] + powers[b] + powers[c] + powers[d] + powers[e] + powers[f];
								int v = an+bn+cn+dn+en+f;
								if (v==sumOfPowers) {
									result += v;
								}
							}
						}
					}
				}
			}
		}
		return result;
	}
}

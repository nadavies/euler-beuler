package nd.projecteuler.problems.zero;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Problem67 {
	private static final String TRIANGLE_DATA_FILE = "p018_triangle.txt";
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		int[][] triangle = loadTriangle();
		
		int[] sums = triangle[triangle.length-1];
		for (int r = triangle.length-2; r>=0; r--) {
			int[] row = triangle[r];
			int[] newSums = new int[row.length];
			for (int i=0; i<row.length; i++) {
				newSums[i] = row[i] + Math.max(sums[i], sums[i+1]);
			}
			sums = newSums;
		}
		System.out.println("Result: " + sums[0]);
	}
	
	private static int[][] loadTriangle() throws FileNotFoundException, IOException {
		List<int[]> rows = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(Problem67.class.getResourceAsStream(TRIANGLE_DATA_FILE)))) {
			String rowString;
			while ((rowString = reader.readLine()) != null) {
				String[] row = rowString.split(" ");
				int[] rowValues = new int[row.length];
				for (int i=0; i<row.length; i++) {
					rowValues[i] = Integer.parseInt(row[i]);
				}
				rows.add(rowValues);
			}
		}
		int[][] data = new int[rows.size()][];
		rows.toArray(data);
		return data;
	}
}

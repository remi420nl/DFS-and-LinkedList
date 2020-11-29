package project1;

import java.util.Arrays;

//Find highest number of adjacent 1 integers
public class Main {

	public static void main(String[] args) {

		int[][] testray = new int[][] { { 0, 0, 0, 1, 0 },
					        { 1, 1, 0, 1, 1 },
					        { 0, 1, 0, 0, 1 },
					        { 0, 1, 1, 0, 1 },
						{ 1, 0, 1, 0, 1 }
					      };

		System.out.println(dephtFirstSearch(testray));
		// should return 7
	}

	public static int dephtFirstSearch(int[][] matrix) {

		int maxRegionSize = 0;

		for (int row = 0; row < matrix.length; row++) {
			for (int column = 0; column < matrix[row].length; column++) {
				if (matrix[row][column] == 1) {
					int size = getRegionSizeDFS(matrix, row, column);

					maxRegionSize = Math.max(size, maxRegionSize);
				}
			}
		}

		// print to show all values have been set to 0
		System.out.println(Arrays.deepToString(matrix));
		return maxRegionSize;
	}

	
	private static int getRegionSizeDFS(int[][] matrix, int row, int column) {

		if (row < 0 || column < 0 || row > matrix.length - 1 || column > matrix[row].length - 1)
			return 0;
		if (matrix[row][column] == 0)
			return 0;

		matrix[row][column] = 0;

		int size = 1;

		for (int r = row - 1; r <= row + 1; r++) {
			for (int c = column - 1; c <= column + 1; c++) {
				size += getRegionSizeDFS(matrix, r, c);
			}

		}
		return size;
	}
}

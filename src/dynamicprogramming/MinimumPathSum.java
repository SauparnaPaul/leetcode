package dynamicprogramming;

//https://leetcode.com/problems/minimum-path-sum/
public class MinimumPathSum {
	
	public int minPathSum(int[][] grid) {
		int col = grid[0].length;
		int row=grid.length;
		int[][] dp = new int[row][col];

		for (int i = row - 1; i >= 0; i--) {
			for (int j = col - 1; j >= 0; j--) {
				if (dp[i][j] == 0) {
					if(j==col-1 && i==row-1) {
						dp[i][j] = grid[i][j];
					}else if (j== col-1) {
						dp[i][j] = grid[i][j] + dp[i + 1][j];
					} else if (i == row-1) {
						dp[i][j] = grid[i][j] + dp[i][j + 1];
					} else {
						dp[i][j] = grid[i][j] + Math.min(dp[i][j + 1], dp[i + 1][j]);
					}
				}
			}
		}
		return dp[0][0];
	}

	public static void main(String[] args) {
		MinimumPathSum mps = new MinimumPathSum();
		System.out.println(mps.minPathSum(new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } }));
		System.out.println(mps.minPathSum(new int[][] { { 1, 2, 3 }, { 4, 5, 6 } }));

	}

}

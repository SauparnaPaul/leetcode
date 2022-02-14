package dynamicprogramming;

import java.util.Arrays;

//https://leetcode.com/problems/maximum-length-of-pair-chain/
public class MaximumLengthOfPairChain {

	public int findLongestChain(int[][] pairs) {
		if (pairs == null || pairs.length == 0)
			return 0;

		Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));
		int[] dp = new int[pairs.length];
		Arrays.fill(dp, 1);

		for (int i = 0; i < pairs.length; i++) {
			for (int j = i + 1; j < pairs.length; j++) {
				dp[j] = Math.max(dp[j], pairs[j][0] > pairs[i][1] ? dp[i] + 1 : dp[i]);
			}
		}
		return dp[pairs.length - 1];
	}

	public static void main(String[] args) {
		MaximumLengthOfPairChain mlopc = new MaximumLengthOfPairChain();
		System.out.println(mlopc.findLongestChain(new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 } }));
		System.out.println(mlopc.findLongestChain(new int[][] { {1,2},{7,8},{4,5}}));
	}

}

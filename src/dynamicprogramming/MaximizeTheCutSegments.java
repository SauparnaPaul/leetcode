package dynamicprogramming;

import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/cutted-segments1642/1
public class MaximizeTheCutSegments {

	public int maximizeCuts(int n, int x, int y, int z)
    {
		int dp[] = new int[n + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
 
        for (int i = 0; i <= n; i++) {
            if (dp[i] == Integer.MIN_VALUE) continue;
            if (i + x <= n)  dp[i + x] = Math.max(dp[i + x], dp[i] + 1);
            if (i + y <= n)  dp[i + y] = Math.max(dp[i + y], dp[i] + 1);
            if (i + z <= n)  dp[i + z] = Math.max(dp[i + z], dp[i] + 1);
        }

        if (dp[n] == -1) dp[n] = 0;
        return dp[n];
    }
	
	public static void main(String[] args) {
		MaximizeTheCutSegments mtcs=new MaximizeTheCutSegments();
		System.out.println(mtcs.maximizeCuts(4, 2, 1, 1));
		}

}

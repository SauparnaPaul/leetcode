package dynamicprogramming;

import java.util.Arrays;

//https://leetcode.com/problems/coin-change/
/*Runtime: 25 ms, faster than 61.10% of Java online submissions for Coin Change.
Memory Usage: 44.9 MB, less than 27.78% of Java online submissions for Coin Change.*/
public class CoinChange {

	int [] dp;
	public int coinChange(int[] coins, int amount) {
		dp=new int [amount+1];
		Arrays.fill(dp, amount+1);
		dp[0]=0;
		
		for(int i=1;i<=amount;i++) {
			for(int c=0;c<coins.length;c++) {
				if(i-coins[c]>=0) {
					dp[i]=Math.min(dp[i], 1+dp[i-coins[c]]);
				}
			}
		}
		
		return dp[amount]!=amount+1?dp[amount]:-1;
	}

	public static void main(String[] args) {
		CoinChange cc=new CoinChange();
		System.out.println(cc.coinChange(new int[] {1,2,5}, 11));
		System.out.println(cc.coinChange(new int[] {2}, 3));
		System.out.println(cc.coinChange(new int[] {1}, 1));
		System.out.println(cc.coinChange(new int[] {1}, 0));

	}

}

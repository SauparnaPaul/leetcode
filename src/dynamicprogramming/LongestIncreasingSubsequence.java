package dynamicprogramming;

import java.util.Arrays;

//https://leetcode.com/problems/longest-increasing-subsequence/
public class LongestIncreasingSubsequence {

	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int[] L = new int[nums.length];
		L[0] = 1;

		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i] && L[j] > L[i]) {
					L[i] = L[j];
				}
			}
			L[i]++;
		}
		Arrays.stream(L).forEach(System.out::print);
		System.out.println();
		return Arrays.stream(L).max().getAsInt();
	}

	public static void main(String[] args) {
		LongestIncreasingSubsequence lis=new LongestIncreasingSubsequence();
		System.out.println(lis.lengthOfLIS(new int [] {10,9,2,5,3,7,101,18}));
		System.out.println(lis.lengthOfLIS(new int [] {0,1,0,3,2,3}));
		System.out.println(lis.lengthOfLIS(new int [] {7,7,7,7,7,7,7}));



	}

}

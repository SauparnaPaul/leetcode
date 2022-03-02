package dynamicprogramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//https://leetcode.com/problems/minimum-number-of-removals-to-make-mountain-array/
//https://www.youtube.com/watch?v=0f3Q2n2yqWA
public class MinimumNumberRemovalsMakeMountainArray {

	 public int minimumMountainRemovals(int[] nums) {
		 MinimumNumberRemovalsMakeMountainArray flvocep= new MinimumNumberRemovalsMakeMountainArray();
	        int n=nums.length;
	        int [] dp_left=flvocep.lengthOfLIS(nums);
	        
	        List<Integer> listOfObstaclesReverse=Arrays.stream(nums).boxed().collect(Collectors.toList());
	        Collections.reverse(listOfObstaclesReverse);
	        int [] dp_right=flvocep.lengthOfLIS(listOfObstaclesReverse.stream().mapToInt(i->i).toArray());
		
	        int max=0;
	        for(int i=1;i<n-1;i++) {
	        	if(dp_left[i]>1 && dp_right[n-i-1]>1) max=Math.max(max, dp_left[i]+dp_right[n-i-1]-1);
	        }
	        return n-max;
	    }
	 
	public int[] lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return new int [] {};
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
		return L;
	}

	public static void main(String[] args) {
		MinimumNumberRemovalsMakeMountainArray mnrmma=new MinimumNumberRemovalsMakeMountainArray();
		System.out.println(mnrmma.minimumMountainRemovals(new int [] {1,3,1}));
		System.out.println(mnrmma.minimumMountainRemovals(new int [] {2,1,1,5,6,2,3,1}));
		System.out.println(mnrmma.minimumMountainRemovals(new int [] {7,7,7,7,7,7,7}));



	}

}

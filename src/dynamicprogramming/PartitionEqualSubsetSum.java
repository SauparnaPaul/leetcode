package dynamicprogramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PartitionEqualSubsetSum {

	public boolean canPartition(int[] nums) {
		Set<Integer> dp= new HashSet<Integer>();
		int sumOfElemens=Arrays.stream(nums).sum();
		if((sumOfElemens &1 ) != 0) return false;
		
		dp.add(0);
		int target=sumOfElemens>>1;
		
		for(int i=nums.length-1;i>=0;i--) {
			Set<Integer> nextdp= new HashSet<Integer>();
			for(Integer t:dp) {
				nextdp.add(t+nums[i]);
				nextdp.add(t);
			}
			dp.addAll(nextdp);
			//System.out.println(dp);
		}
		return dp.contains(target);
	}

	public static void main(String[] args) {
		PartitionEqualSubsetSum pess = new PartitionEqualSubsetSum();
		System.out.println(pess.canPartition(new int[] { 1, 5, 11, 5 }));
		System.out.println(pess.canPartition(new int[] { 1, 2, 3, 5 }));
		System.out.println(pess.canPartition(new int[] { 1, 2, 5 }));
		System.out.println(pess.canPartition(new int[] { 100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,99,97}));
	}

}

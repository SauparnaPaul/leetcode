package dynamicprogramming;

public class IntegerBreak {
	int [] dp;
	
	public int dfs(int n, int num) {
		if(dp[n]!=0) return dp[n];
		dp[n]=(n==num)?0:n;
		
		for(int i=1;i<n;i++) {
			int val=dfs(i,num)*dfs(n-i,num);
			dp[n]=Math.max(dp[n], val);
		}
		return dp[n];

	}
	public int integerBreak(int n) {
		dp=new int [n+1];
		dp[1]=1;
		return dfs(n,n);

	}

	public static void main(String[] args) {
		IntegerBreak intBreak=new IntegerBreak();
		System.out.println(intBreak.integerBreak(3));
		System.out.println(intBreak.integerBreak(10));

	}

}

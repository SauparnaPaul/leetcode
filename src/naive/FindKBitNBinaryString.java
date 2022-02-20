package naive;

//https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/submissions/
public class FindKBitNBinaryString {

	public char findKthBit(int n, int k) {
		StringBuilder dp[]=new StringBuilder [n];
		dp[0]=new StringBuilder("0");
		for(int i=1;i<n;i++) {
			dp[i]=new StringBuilder();
			dp[i]
			.append(dp[i-1])
			.append("1");

			int t=dp[i-1].length()-1;
			while(t>=0) {
				dp[i].append(dp[i-1].charAt(t--)=='1'?'0':'1');
			}
		}
		return dp[n-1].charAt(k-1);
	
	}

	public static void main(String[] args) {
		FindKBitNBinaryString fkbnbs=new FindKBitNBinaryString();
		System.out.println(fkbnbs.findKthBit(3, 1));
		System.out.println(fkbnbs.findKthBit(1048575, 11));
	}

}

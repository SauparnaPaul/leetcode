package dynamicprogramming;

//https://www.geeksforgeeks.org/friends-pairing-problem/
public class FriendsPairing {
	public int countFriendsPairings(int n)
    {
        int dp[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i <= 2)
                dp[i] = i;
            else
                dp[i] = dp[i - 1] + (i - 1) * dp[i - 2];
        }
        return dp[n];
    }
 
    // Driver code
    public static void main(String[] args)
    {
    	FriendsPairing fp=new FriendsPairing();
        System.out.println(fp.countFriendsPairings(4));
    }

}

package dynamicprogramming;

//https://leetcode.ca/all/276.html
public class PaintingTheFence {
	public int numWays(int n, int k) {
		if (n == 0)
			return 0;
		int same = 0, diff = k;
		for (int i = 2; i <= n; ++i) {
			int t = diff;
			diff = (same + diff) * (k - 1);
			same = t;
		}
		return same + diff;
	}

	public static void main(String[] args) {
		PaintingTheFence out = new PaintingTheFence();
        System.out.println(out.numWays(3, 2));
	}

}

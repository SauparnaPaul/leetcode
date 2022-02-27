package dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

//https://codeforces.com/problemset/problem/1644/E
public class ExpandPath {
	public long allPossiblePaths(String path, long n) {
		Set<String> setOfPath = new HashSet<String>();
		Set<String> setOfPossiblePaths = new HashSet<String>();
		expandPath(path, setOfPath, setOfPossiblePaths, n);
		// System.out.println(setOfPath);
		return setOfPath.size();
	}

	public void expandPath(String path, Set<String> setOfPath, Set<String> setOfPossiblePaths, long n) {
		String direction = "";
		if (!setOfPossiblePaths.contains(path)) {
			if (validatePath(path, setOfPath, n)) {
				setOfPossiblePaths.add(path);
				for (int index = 0; index < path.length(); index++) {
					direction = path.charAt(index) == 'R' ? "R" : "D";
					String pathNew = path.substring(0, index + 1) + direction + path.substring(index + 1);
					expandPath(pathNew, setOfPath, setOfPossiblePaths, n);
				}
			}
		}
	}

	private boolean validatePath(String path, Set<String> setOfPath, long n) {
		int row = 1;
		int col = 1;
		int rCount = 0;
		int dCount = 0;

		if (n == 1)
			return false;

		Set<String> setOfValidPath = new HashSet<String>();
		setOfValidPath.add("{1,1}");

		int index = 0;
		do {
			if (path.charAt(index) == 'R') {
				rCount++;
				col = col + 1;
			} else {
				dCount++;
				row = row + 1;
			}

			if (row <= n && col <= n) {
				setOfValidPath.add("{" + String.valueOf(row) + "," + String.valueOf(col) + "}");
			} else {
				return false;
			}
			index++;
		} while (index < path.length());

		if (rCount == n - 1 || dCount == n - 1)
			setOfPath.addAll(setOfValidPath);
		return true;
	}

	public static void main(String[] args) throws Exception {
		ExpandPath ep = new ExpandPath();
		BufferedReader bfn = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int t = Integer.parseInt(bfn.readLine());

		long startTime = System.currentTimeMillis();
		while (t-- > 0) {
			long n = Long.parseLong(bfn.readLine());
			pw.println(ep.allPossiblePaths(bfn.readLine(), n));
		}
		long endTime = System.currentTimeMillis();
		System.out.println("ExpandPath with DP : " + (endTime - startTime) + " milliseconds");
		pw.close();
		/*
		 * System.out.println(ep.allPossiblePaths("RD",4));
		 * System.out.println(ep.allPossiblePaths("DRDRDRDR", 5));
		 * System.out.println(ep.allPossiblePaths("D", 3));
		 */

	}

}

package naive;

import java.util.Stack;
import java.util.stream.Collectors;

//https://leetcode.com/problems/make-the-string-great/submissions/
public class MakeTheStringGreat {
	public String makeGood(String s) {
		if (s.length() == 0)
			return "";

		Stack<Character> st = new Stack<Character>();

		for (char c : s.toCharArray()) {
			if (!st.isEmpty()
					&& Math.abs(st.peek()-c)==32
					) {
				st.pop();
			} else {
				st.push(c);
			}

		}
		return st.isEmpty() ? "" : st.stream().map(a -> a.toString()).collect(Collectors.joining(""));

	}

	public static void main(String[] args) {
		MakeTheStringGreat mtsg = new MakeTheStringGreat();
		System.out.println(mtsg.makeGood("Pp"));
		System.out.println(mtsg.makeGood("leEeetcode"));
		System.out.println(mtsg.makeGood("abBAcC"));
		System.out.println(mtsg.makeGood("s"));

	}

}

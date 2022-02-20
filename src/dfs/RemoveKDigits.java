package dfs;

import java.util.Stack;

//https://leetcode.com/problems/remove-k-digits/submissions/
public class RemoveKDigits {

	public String removeKdigits(String num, int k) {
		int len = num.length();
        //corner case
        if(k==len)
            return "0";

        Stack<Character> stack = new Stack<>();
        int i =0;
        while(i<num.length()){
            //whenever meet a digit which is less than the previous digit, discard the previous one
            while(k>0 && !stack.isEmpty() && stack.peek()>num.charAt(i)){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
            i++;
        }
        while(k>0){
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
            sb.append(stack.pop());
        sb.reverse();
        
        while(sb.length()>1 && sb.charAt(0)=='0')
            sb.deleteCharAt(0);
        
        return sb.toString();
	}

	public static void main(String[] args) {

		RemoveKDigits rkd = new RemoveKDigits();
		System.out.println(rkd.removeKdigits("1432219", 3));
		System.out.println(rkd.removeKdigits("10200", 1));
		System.out.println(rkd.removeKdigits("10", 2));
		System.out.println(rkd.removeKdigits("10", 1));
		System.out.println(rkd.removeKdigits("100", 1));
	}

}

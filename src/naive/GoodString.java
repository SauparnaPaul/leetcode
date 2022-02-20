package naive;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
public class GoodString {
	public int countCharacters(String[] words, String chars) {
		int sumOfLength = 0;
		Map<Character, Integer> mapOfChars = new HashMap<Character, Integer>();

		for (char c : chars.toCharArray()) {
			if (mapOfChars.get(c) != null) {
				mapOfChars.put(c, mapOfChars.get(c) + 1);
			} else {
				mapOfChars.put(c, 1);
			}
		}

		//System.out.println(mapOfChars);
		
		for (int i = 0; i < words.length; i++) {
			boolean match=false;
			Map<Character, Integer> mapOfWords = new HashMap<Character, Integer>(mapOfChars);
			for (char c : words[i].toCharArray()) {
				if (mapOfWords.get(c) != null && mapOfWords.get(c)>0 ) {
					mapOfWords.put(c, mapOfWords.get(c) - 1);
					match=true;
				} else {
					match=false;
					break;
				}
			}
			//System.out.println(words[i]+": "+mapOfWords);
			sumOfLength+=match?words[i].length():0;
		}
		
		
		return sumOfLength;
	}

	public static void main(String[] args) {
		GoodString gs = new GoodString();
		//System.out.println(gs.countCharacters(new String[] { "cat", "bt", "hat", "tree" }, "atach"));
		System.out.println(gs.countCharacters(new String[] { "catta","hat",}, "atach"));
		/*
		 * System.out.println(gs.countCharacters(new String[] {
		 * "dyiclysmffuhibgfvapygkorkqllqlvokosagyelotobicwcmebnpznjbirzrzsrtzjxhsfpiwyfhzyonmuabtlwin",
		 * "ndqeyhhcquplmznwslewjzuyfgklssvkqxmqjpwhrshycmvrb",
		 * "ulrrbpspyudncdlbkxkrqpivfftrggemkpyjl", "boygirdlggnh",
		 * "xmqohbyqwagkjzpyawsydmdaattthmuvjbzwpyopyafphx",
		 * "nulvimegcsiwvhwuiyednoxpugfeimnnyeoczuzxgxbqjvegcxeqnjbwnbvowastqhojepisusvsidhqmszbrnynkyop",
		 * "hiefuovybkpgzygprmndrkyspoiyapdwkxebgsmodhzpx",
		 * "juldqdzeskpffaoqcyyxiqqowsalqumddcufhouhrskozhlmobiwzxnhdkidr",
		 * "lnnvsdcrvzfmrvurucrzlfyigcycffpiuoo", "oxgaskztzroxuntiwlfyufddl",
		 * "tfspedteabxatkaypitjfkhkkigdwdkctqbczcugripkgcyfezpuklfqfcsccboarbfbjfrkxp",
		 * "qnagrpfzlyrouolqquytwnwnsqnmuzphne", "eeilfdaookieawrrbvtnqfzcricvhpiv",
		 * "sisvsjzyrbdsjcwwygdnxcjhzhsxhpceqz",
		 * "yhouqhjevqxtecomahbwoptzlkyvjexhzcbccusbjjdgcfzlkoqwiwue",
		 * "hwxxighzvceaplsycajkhynkhzkwkouszwaiuzqcleyflqrxgjsvlegvupzqijbornbfwpefhxekgpuvgiyeudhncv",
		 * "cpwcjwgbcquirnsazumgjjcltitmeyfaudbnbqhflvecjsupjmgwfbjo",
		 * "teyygdmmyadppuopvqdodaczob",
		 * "qaeowuwqsqffvibrtxnjnzvzuuonrkwpysyxvkijemmpdmtnqxwekbpfzs",
		 * "qqxpxpmemkldghbmbyxpkwgkaykaerhmwwjonrhcsubchs" },
		 * "usdruypficfbpfbivlrhutcgvyjenlxzeovdyjtgvvfdjzcmikjraspdfp"));
		 */

	}

}

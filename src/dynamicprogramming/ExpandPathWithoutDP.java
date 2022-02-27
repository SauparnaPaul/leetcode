package dynamicprogramming;

import java.util.*;
import java.io.*;

public class ExpandPathWithoutDP {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    StringTokenizer st;

    int t = Integer.parseInt(br.readLine());
  long startTime = System.currentTimeMillis();
    while (t --> 0) {
      long n = Long.parseLong(br.readLine());
      String s = br.readLine();
      int r = 0;
      int d = 0;
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == 'R') r++;
        else d++;
      }
      if (r == 0 || d == 0) pw.println(n);
      else {
        int fr = 0;
        for (int i = 0; i < s.length(); i++) {
          if (s.charAt(i) == 'D') break;
          fr++;
        }
        int fd = 0;
        for (int i = 0; i < s.length(); i++) {
          if (s.charAt(i) == 'R') break;
          fd++;
        }
        long ans = (r + d + 1) + (n - r - 1) * (n - d - 1);
        ans += (r - fr + 1) * (n - d - 1) + (d - fd + 1) * (n - r - 1);
        pw.println(ans);
      }
    }
  long endTime = System.currentTimeMillis();
  System.out.println("ExpandPath with DP : " + (endTime - startTime) + " milliseconds");
    pw.close();
  }
}

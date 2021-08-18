package com.eomcs.pms;

public class Practice {
  public static void main(String[] args) {
    Solution sol = new Solution();
    long answer = sol.solution(3, 10, 4);
    System.out.println(answer);
  }
}

class Solution {
  public long solution(long price, long money, long count) {
    long total = 0;
    for (long i = 0;  i < count; i++) {
      total += price * (i + 1);
    }
    //    if (total > money) {
    //      total -= money;
    //    } else if (total <= money) { 
    //      return 0;
    //    }
    //    return total;
    return (total > money) ? total - money : 0;
  }
}












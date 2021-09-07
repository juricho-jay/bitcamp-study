package com.eomcs.pms;

public class Solution5 {
  public static void main(String[] args) {
    Solution10 sol = new Solution10();
    int a = 221983; // 12346890, 1 , 23
    System.out.println(sol.solution(a));


  }
}

class Solution10 {
  public int solution(int a) {
    int answer = 0; 
    while (a != 0) {
      answer += a % 10; // 3
      a = a/10;
    }

    return answer;
  }
}

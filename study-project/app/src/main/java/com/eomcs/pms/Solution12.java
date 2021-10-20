package com.eomcs.pms;

public class Solution12 {

  public static void main(String[] args) {
    Solution13 sol = new Solution13();
    System.out.println(sol.solution(3)); 
  }

}

class Solution13 {
  public int solution(int no) {
    int answer = 0;
    for (int i = 1; i <= no; i++) {
      if (no%i == 0) {
        answer += i;
      }
    }
    return answer;
  }
}
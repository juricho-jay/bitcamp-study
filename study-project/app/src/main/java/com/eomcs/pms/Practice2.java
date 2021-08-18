package com.eomcs.pms;
//[[100,90,98,88,65],[50,45,99,85,77],[47,88,95,80,67],[61,57,100,80,65],[24,90,94,75,65]]

public class Practice2 {

  public static void main(String[] args) {

    int[][] scores = {
        {70,49,90},
        {68,50,38},
        {73,31,100},
    };
    Solution2 sol = new Solution2();
    String answer = sol.solution(scores);
    System.out.println(answer);
  }
}

class Solution2 {
  public String solution(int[][] scores) {
    String answer = "";

    for (int i = 0; i < scores.length; i++) {
      for (int j = 0; j < scores[i].length; j++) {
        total += scores[j][i];
      }
    }









    return answer;
  }
}

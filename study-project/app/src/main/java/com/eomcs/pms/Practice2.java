package com.eomcs.pms;

//[[100,90,98,88,65],[50,45,99,85,77],[47,88,95,80,67],[61,57,100,80,65],[24,90,94,75,65]]


public class Practice2 {

  public static void main(String[] args) {

    int[][] scores = {
        {90,90,90},
        {50,50,49},
        {80,80,79},
    };
    Solution sol = new Solution();
    String answer = sol.solution(scores);
    System.out.println(answer);
  }
}

class Solution {
  public String solution(int[][] scores) {
    String answer = "";
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < scores.length; i++) {
      long total = 0;
      double average = 0;
      int max = scores[0][i];
      int min = scores[0][i];
      int k = scores.length;


      for (int j = 0; j < k; j++) {
        if(i != j) {
          if (scores[j][i] > max) {
            max = scores[j][i];
          }
          if (scores[j][i] < min) {
            min = scores[j][i];
          }
        }
        total += scores[j][i];
      }

      if (scores[i][i] < min || scores[i][i] > max) {
        total -= scores[i][i];
        average = total - scores[i][i] / (k - 1);
      } else {
        average = total + scores[i][i] / k;
      }

      if (average >= 90) {
        sb.append('A');
      } else if (average < 90 && average >= 80) {
        sb.append('B');
      } else if (average < 80 && average >= 70) {
        sb.append('C');
      } else if (average < 70 && average >= 50) {
        sb.append('D');
      }  else {
        sb.append('F');
      }
    }
    answer = sb.toString();
    return answer;
  }

}

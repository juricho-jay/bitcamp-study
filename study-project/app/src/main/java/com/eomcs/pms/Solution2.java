package com.eomcs.pms;

class Solution2 {
  int score;
  int count;
  int min;
  int max;
  int myscore;
  int cnt;

  public String solution(int[][] scores) {

    double[] student = new double[scores.length]; 

    for(int i = 0; i < scores.length ; i++) {
      count = scores.length;
      myscore = scores[i][i]; 
      min = 101; 
      max = -1; 



      for(int j = 0 ; j < scores[i].length ; j++) {

        score += scores[j][i];

        if((i != j ) && (scores[j][i] == myscore)) {
          cnt++; // 같은숫자가 있음을 표시
        }

        if((i != j) && (scores[j][i] == myscore)) {
          cnt++;
        }

        if(scores[j][i] < min) {
          min = scores[j][i]; 
        }

        if(scores[j][i] > max) {
          max = scores[j][i];
        }


      }

      if( ( (cnt == 0) && (myscore == max) ) || ( (cnt == 0) && (myscore == min) ) )  {
        score -= myscore; // 90
        count--;    // 1
      }

      student[i] = (double)score / count;
      System.out.printf("student[%d] = score(%d) / count(%d) => %f\n", i, score, count, ((double)score/count) );
      score = 0;
      cnt = 0;

    }
    String answer = cutline(student);
    return answer;

  }

  public String cutline(double[] student) {
    double score;
    String answer = "";
    for(int i = 0 ; i < student.length ; i++) {
      score = student[i];
      if(score >= 90) {
        answer += "A";
      } else if(score <90 && score >= 80) {
        answer += "B";

      } else if(score <80 && score >= 70) {
        answer += "C";

      } else if(score <70 && score >= 50) {
        answer += "D";

      } else {
        answer += "F";
      }
    }
    return answer;
  }

}

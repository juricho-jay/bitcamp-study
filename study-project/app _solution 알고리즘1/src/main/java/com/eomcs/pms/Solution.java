package com.eomcs.pms;

public class Solution {
  public static void main(String[] args) {
    Solution3 sol = new Solution3();
    int[] arr = {1,2,3,4,5};
    sol.solution(arr);



  }
}

class Solution3 {
  public int[] solution(int[] arr) {
    int[] answer = {};

    if (arr.length == 1) {
      answer[0] = -1;
      return answer;
    }

    int j = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[j] > arr[i]) {
        j = i; // arr[j] = 최소값
      }
    }
    int cnt = 0;
    int[] arr2 = new int[arr.length - 1];
    for (int i = 0; i < arr.length; i++) {
      if (i == j) {
        continue;
      } else {
        arr2[cnt] = arr[i];
        cnt++;
      }
    }
    //
    //    for(int i = 0 ; i < arr2.length; i++) {
    //      System.out.println(arr2[i]);
    //    }

    return arr2;
  }
}
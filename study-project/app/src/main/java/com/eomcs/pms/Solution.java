package com.eomcs.pms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
  public int[] solution(int[] numbers) {
    ArrayList<Integer> list = new ArrayList<>();


    for (int i = 0; i < numbers.length; i++) {
      for (int j = i+1; j < numbers.length; j++) {
        list.add(numbers[i] + numbers[j]);
      }
    }
    Collections.sort(list);
    System.out.println(list);
    Set<Integer> set = new TreeSet<>(list);

    ArrayList<Integer> set2 = new ArrayList<>(set);
    int[] answer = new int[set2.size()];

    for(int i = 0; i < set2.size(); i++) {
      answer[i] = set2.get(i);
    }

    return answer;
  }
  public static void main(String[] args) {
    Solution sol = new Solution();
    int[] arr = {2,1,3,4,1};
    sol.solution(arr);
  }
}

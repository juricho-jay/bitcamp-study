package com.eomcs.pms;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Solution2 {
  public String solution(int a, int b) {
    int inputA = a;
    int inputB = b;
    String answer = null;

    //안녕안녕안녕
    LocalDate date = LocalDate.of(2016, inputA, inputB);

    DayOfWeek dayOfWeek = date.getDayOfWeek();

    int dayOfWeekNumber = dayOfWeek.getValue();

    if (dayOfWeekNumber == 1) {
      answer = "MON";
    } else if (dayOfWeekNumber == 2) {
      answer = "TUE";
    } else if (dayOfWeekNumber == 3) {
      answer = "WED";
    } else if (dayOfWeekNumber == 4) {
      answer = "THU";
    } else if (dayOfWeekNumber == 5) {
      answer = "FRI";
    } else if (dayOfWeekNumber == 6) {
      answer = "SAT";
    } else {
      answer = "SUN";
    }

    return answer;
  }
  public static void main(String[] args) {

  }
}

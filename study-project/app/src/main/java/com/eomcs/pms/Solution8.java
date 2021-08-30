package com.eomcs.pms;

import java.util.Scanner;

public class Solution8 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);   
    System.out.println("입력: ");
    int n = sc.nextInt();
    int m = sc.nextInt();

    //가로 세로 입력한 만큼 출력
    //    for (int i = 0; i < m; i++) {
    //      for (int j = 0; j < n; j++) {
    //        System.out.print("*");
    //      }
    //      System.out.println("");
    //    }

    //우측 하단 트리
    //    for (int i = 0; i < m; i++) {
    //      for (int j = 0; j < i + 1; j++) {
    //        System.out.print("*");
    //      }
    //      System.out.println("");
    //    }

    //좌측 하단 트리
    for (int i = 0; i < n; i++) {
      for (int j = 1; j < n - i; j++) {
        System.out.print(" "); // ""가 아니라 " "공백 칸
      }
      for (int j = 0; j < i + 1; j++) {
        System.out.print("*");
      }
      System.out.println("");
    }
  }
}



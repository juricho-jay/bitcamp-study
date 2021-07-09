package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

public class App3 {

  public static void main(String[] args) {
    System.out.println("[작업]");

    Scanner keyboardScan = new Scanner(System.in);

    final int LENGTH = 100;

    int[] no = new int[LENGTH];
    String[] content = new String[LENGTH];
    Date[] deadline = new Date[LENGTH];
    int[] status = new int[LENGTH];
    String[] owner = new String[LENGTH];

    System.out.print("프로젝트? ");
    String project = keyboardScan.nextLine();

    int size = 0; 
    for (int i= 0; i < LENGTH; i++) {
      size++;

      System.out.print("번호? ");
      no[i] = Integer.parseInt(keyboardScan.nextLine());
      System.out.print("내용? ");
      content[i] = keyboardScan.nextLine();
      System.out.print("완료일? ");
      deadline[i] = Date.valueOf(keyboardScan.nextLine());
      System.out.println("상태?");
      System.out.println("0: 신규");
      System.out.println("1: 진행중");
      System.out.println("2: 완료");
      System.out.print("> ");
      status[i] = Integer.valueOf(keyboardScan.nextLine());
      System.out.print("담당자? ");
      owner[i] = keyboardScan.nextLine();
      System.out.print("계속 입력하시겠습니까? (y/N)");
      String input = keyboardScan.nextLine();
      if (!input.equalsIgnoreCase("y")) {
        break;
      }

    }



    keyboardScan.close();

    System.out.println("--------------------------------");

    for (int i = 0; i < size, i++) {
      System.out.printf("프로젝트: %s\n", project);
      System.out.printf("번호: %d\n", no[i]);
      System.out.printf("내용: %s\n", content[i]);
      System.out.printf("상태: %s\n", status[i]);

      switch (status[i]) {
        case 1:
          System.out.println("상태: 진행중");
          break;
        case 2:
          System.out.println("상태: 완료");
          break;
        default:
          System.out.println("상태: 신규");
      }

      System.out.printf("담당자: %s\n", owner[i]);
      System.out.println();

    }
  }
}

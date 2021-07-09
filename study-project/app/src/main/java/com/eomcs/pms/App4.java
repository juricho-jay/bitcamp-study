package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

public class App4 {

  public static void main(String[] args) {
    System.out.println("[작업]");

    Scanner keyScan = new Scanner(System.in);

    final int LENGTH = 100;

    System.out.println("프로젝트? ");
    String project = keyScan.nextLine();

    int[] no = new int[LENGTH];
    String[] content = new String[LENGTH];
    Date[] deadline = new Date[LENGTH];
    int[] status = new int[LENGTH];
    String[] owner = new String[LENGTH];

    int size = 0;
    for (int i = 0; i < LENGTH; i++) {
      System.out.print("번호? ");
      size++;
      no[i] = Integer.parseInt();


    }



  }

}

package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

//1) 변경 준비 
//2) 사용자에게 명령 프롬프트 출력
//3) 사용자의 명령을 입력 받아 출력
//4) 명령을 입력 받아 출력하는 것을 무한 반복
//5) exit나 quit 명령을 입력하면 반복 실행 중지
//6) /member/add와 /member/list 명령을 구분해 보자!
//7) /member/add 명령 처리
//8) /member/list 명령 처리
//9) /project/add  명령 처리
//10) /project/list 명령 처리
//11) /task/add 명령 처리
//12) /task/list 명령 처리
public class App {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    //최대 입력 개수
    final int MAX_LENGTH = 100;
    int[] no = new int[MAX_LENGTH];
    String[] name = new String[MAX_LENGTH];
    String[] email = new String[MAX_LENGTH];
    String[] password = new String[MAX_LENGTH];
    String[] photo = new String[MAX_LENGTH]; 
    String[] tel = new String[MAX_LENGTH];
    Date[] registeredDate = new Date[MAX_LENGTH];
    int size = 0;

    //프로젝트 데이터
    final int PROJECT_LENGTH = 100; 
    int[] pNo = new int[PROJECT_LENGTH];
    String[] pTitle = new String[PROJECT_LENGTH];
    String[] pContent = new String[PROJECT_LENGTH];
    Date[] pStartDate = new Date[PROJECT_LENGTH];
    Date[] pEndDate = new Date[PROJECT_LENGTH];
    String[] pOwner = new String[PROJECT_LENGTH];
    String[] pMembers = new String[PROJECT_LENGTH];
    int pSize = 0;

    //작업 데이터
    final int TASK_LENGTH = 100;
    int[] tNo = new int[TASK_LENGTH];
    String[] tContent = new String[TASK_LENGTH];
    Date[] tDeadline = new Date[TASK_LENGTH];
    String[] tOwner = new String[TASK_LENGTH];
    int[] tStatus = new int[TASK_LENGTH];
    int tSize = 0;



    while (true) {
      System.out.print("명령> ");
      String input = sc.nextLine();
      if (input.equals("exit") || input.equals("quit")) {
        System.out.println("안녕!");
        break;
      } else if (input.equals("/member/add")) {
        System.out.println("[회원 등록]");

        System.out.print("번호? ");
        no[size] = Integer.parseInt(sc.nextLine());
        System.out.print("이름? ");
        name[size] = sc.nextLine();
        System.out.print("이메일? ");
        email[size] = sc.nextLine();
        System.out.print("암호? ");
        password[size] = sc.nextLine();
        System.out.print("사진? ");
        photo[size] = sc.nextLine();
        System.out.print("전화? ");
        tel[size] = sc.nextLine();
        registeredDate[size] = new Date(System.currentTimeMillis());

        size++;

        System.out.println();

      } else if (input.equals("/member/list")) {
        System.out.println("[회원 목록]");
        for (int i = 0; i < size; i = i + 1) {
          System.out.printf("%d, %s, %s, %s, %tY-%5$tm-%5$td\n", 
              no[i],
              name[i],
              email[i],
              tel[i],
              registeredDate[i]);
        }

      } else if (input.equals("/project/add")) {
        System.out.print("번호? ");
        pNo[size] = Integer.valueOf(sc.nextLine());

        System.out.print("프로젝트명? ");
        pTitle[size] = sc.nextLine();

        System.out.print("내용? ");
        pContent[size] = sc.nextLine();

        System.out.print("시작일? ");
        pStartDate[size] = Date.valueOf(sc.nextLine());

        System.out.print("종료일? ");
        pEndDate[size] = Date.valueOf(sc.nextLine());

        System.out.print("만든이? ");
        pOwner[size] = sc.nextLine();

        System.out.print("팀원? ");
        pMembers[size] = sc.nextLine();

        pSize++;
        System.out.println();


      } else if (input.equals("/project/list")) {
        for (int i = 0; i < pSize; i++) {
          System.out.println("[프로젝트 목록]");
          // 번호, 프로젝트명, 시작일, 종료일, 만든이
          System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
              pNo[i], pTitle[i], pStartDate[i], pEndDate[i], pOwner[i]);
        }
      } else if (input.equals("/task/add")) {
        System.out.print("번호? ");
        tNo[size] = Integer.parseInt(sc.nextLine());

        System.out.print("내용? ");
        tContent[size] = sc.nextLine();

        System.out.print("마감일? ");
        tDeadline[size] = Date.valueOf(sc.nextLine());

        System.out.println("상태?");
        System.out.println("0: 신규");
        System.out.println("1: 진행중");
        System.out.println("2: 완료");
        System.out.print("> ");
        tStatus[size] = Integer.valueOf(sc.nextLine());

        System.out.print("담당자? ");
        tOwner[size] = sc.nextLine();

        size++;
        System.out.println(); // 빈 줄 출력

        System.out.print("계속 입력하시겠습니까?(y/N) ");
        String str = sc.nextLine();
        if (!str.equalsIgnoreCase("y")) {
          break;
        }
        System.out.println();





      } else if (input.equals("/task/list")) {        



      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
    }
    sc.close();

  }
}






/*

      System.out.print("계속 입력하시겠습니까? (y/N) ");
      String input = keyboardScan.nextLine();
      if (input.equalsIgnoreCase("N") || input.equals("")) {
        break;
      }
      System.out.println();
    }

    keyboardScan.close(); // 데이터 입출력이 끝났으면 도구를 닫는다.

    System.out.println("--------------------------------");

    for (int i = 0; i < size; i = i + 1) {
      System.out.printf("%d, %s, %s, %s, %tY-%5$tm-%5$td\n", 
          no[i],
          name[i],
          email[i],
          tel[i],
          registeredDate[i]);
    }*/


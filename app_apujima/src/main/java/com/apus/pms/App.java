package com.apus.pms;

import handler.MemberHandler;
import util.Prompt;

public class App {

  static MemberHandler memberHandler = new MemberHandler();

  public static void main(String[] args) {
    while (true) {
      int menuNo = doMainMenu();

      if (menuNo == 0) {
        System.out.println("APUJIMA에 방문해주셔서 감사합니다!\n다음에 또 만나요!");
        break;
      } else if (menuNo == 1) {
        doMemberRegisterMenu();
      } else if (menuNo == 2) {
        doSignInMenu();
      } else if (menuNo == 3) {
        doCommunityMenu();
      } else {
        System.out.println("메뉴 번호가 유효하지 않습니다.");
      }
      System.out.println();
    }

    Prompt.close();
  }

  private static void doCommunityMenu() {
    while (true) {
      System.out.println("[커뮤니티 페이지]");
      System.out.println("원하시는 게시판을 선택해 주세요!");
      System.out.println("1. 공지사항");
      System.out.println("2. 자유게시판");
      System.out.println("3. HEALER 지식 in");
      System.out.println("0. 이전메뉴");

      int menuNo = Prompt.inputInt("커뮤니티> ");
      switch (menuNo) {
        case 1: System.out.println("공지사항인데 아직이라능"); break;
        case 2: System.out.println("자유게시판인데 아직이라능"); break;
        case 3: System.out.println("HEALER 지식in인데 아직이라능"); break;
        case 0: return;
        default:
          System.out.println("무효한 메뉴 번호입니다.");
      }
      System.out.println();
    } 

  }

  private static void doSignInMenu() {
    System.out.println("[로그인 페이지]");
    System.out.println("1. 로그인 아직 No구현데스네");
    System.out.println("0. 이전메뉴");

    int menuNo = Prompt.inputInt("로그인> ");
    switch (menuNo) {
      case 1: break;
      case 0: return;
      default:
        System.out.println("무효한 메뉴 번호입니다.");
    }
    System.out.println();
  } 

  static void doMemberRegisterMenu() {
    while (true) {
      System.out.println("APUJIMA에 오신 것을 환영합니다.");
      System.out.println("[회원가입]");
      System.out.println("1. 회원가입하기");
      System.out.println("0. 이전메뉴");

      int menuNo = Prompt.inputInt("가입> ");
      switch (menuNo) {
        case 1: memberHandler.add(); break;
        case 0: return;
        default:
          System.out.println("무효한 메뉴 번호입니다.");
      }
      System.out.println();
    } 
  }



  static int doMainMenu() {
    System.out.println("[APUJIMA에 오신 것을 환영합니다!!]");
    System.out.println("/(ㅇㅅㅇ)/오우 매우 허접쓰~");
    System.out.println();
    System.out.println("1.회원가입");
    System.out.println("2.로그인");
    System.out.println("3.메뉴");
    System.out.println("0.종료");
    return Prompt.inputInt("메인> ");
  }



}


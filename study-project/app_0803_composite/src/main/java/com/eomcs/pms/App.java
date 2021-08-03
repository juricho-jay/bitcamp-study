package com.eomcs.pms;

import com.eomcs.pms.handler.BoardHandler;
import com.eomcs.pms.handler.MemberHandler;
import com.eomcs.pms.handler.ProjectHandler;
import com.eomcs.pms.handler.TaskHandler;
import com.eomcs.pms.menu.Menu;
import com.eomcs.pms.menu.MenuGroup;
import com.eomcs.util.Prompt;

// 1) 메인 메뉴를 출력하고 번호를 입력 받는다.(App.java.01)
//    - 0 번을 입력하면 프로그램을 종료한다.
// 2) 게시판 메뉴를 출력하고 번호를 입력 받는다.
//    - 사용자가 입력한 메뉴 번호에 따라 실행할 명령어를 설정한다.
// 3) 회원/프로젝트/작업 메뉴를 출력하고 번호를 입력 받는다.
//    - 사용자가 입력한 메뉴 번호에 따라 실행할 명령어를 설정한다.
// 4) 메뉴 번호를 입력했을 때 해당 기능을 바로 실행하게 한다.
// 5) 각각의 메인 메뉴를 다루는 코드를 별도의 메서드로 추출한다.
//    - doBoardMenu() 메서드 정의
//    - doMemberMenu() 메서드 정의
//    - doProjectMenu() 메서드 정의
//    - doTaskMenu() 메서드 정의
//    - doMainMenu() 메서드 정의
// 
public class App {

  // main() 메서드와 doXxxMenu() 메서드가 공유하는 변수는 
  // 같은 스태틱 멤버로 만든다.
  BoardHandler boardHandler = new BoardHandler();
  MemberHandler memberHandler = new MemberHandler();
  ProjectHandler projectHandler = new ProjectHandler(memberHandler);
  TaskHandler taskHandler = new TaskHandler(memberHandler);

  public static void main(String[] args) {
    App app = new App();
    app.service();
  }

  void service() {
    //      Menu mainMenu = createMenu();
    //      mainMenu.execute();
    createMenu().execute();  //익숙해지기 -  한 번만 쓸거면 이렇게 간단하게!
    Prompt.close();
  }

  Menu createMenu() {
    MenuGroup mainMenuGroup = new MenuGroup("메인");
    mainMenuGroup.setPrevMenuTitle("종료");

    MenuGroup boardMenu = new MenuGroup("게시판");
    mainMenuGroup.add(boardMenu);

    // 로컬 클래스 

    boardMenu.add(new Menu("등록") {
      @Override
      public void execute() {
        boardHandler.add();
      }
    });

    boardMenu.add(new Menu("목록") {
      @Override
      public void execute() {
        boardHandler.list();
      }});

    boardMenu.add(new Menu("상세보기") {
      @Override
      public void execute() {
        boardHandler.detail();
      }});

    boardMenu.add(new Menu("변경") {
      @Override
      public void execute() {
        boardHandler.update();
      }});

    boardMenu.add(new Menu("삭제") {
      @Override
      public void execute() {
        boardHandler.delete();
      }});

    MenuGroup memberMenu = new MenuGroup("회원");
    mainMenuGroup.add(memberMenu);

    memberMenu.add(new Menu("등록") {
      @Override
      public void execute() {
        memberHandler.add();
      }});

    memberMenu.add(new Menu("목록") {
      @Override
      public void execute() {
        memberHandler.list();
      }});

    memberMenu.add(new Menu("상세보기") {
      @Override
      public void execute() {
        memberHandler.detail();
      }});

    memberMenu.add(new Menu("변경") {
      @Override
      public void execute() {
        memberHandler.update();
      }});

    memberMenu.add(new Menu("삭제") {
      @Override
      public void execute() {
        memberHandler.delete();
      }});



    MenuGroup projectMenu = new MenuGroup("프로젝트");
    mainMenuGroup.add(projectMenu);

    projectMenu.add(new Menu("등록") {
      @Override
      public void execute() {
        projectHandler.add();
      }});

    projectMenu.add(new Menu("목록") {
      @Override
      public void execute() {
        projectHandler.list();
      }});

    projectMenu.add(new Menu("상세보기") {
      @Override
      public void execute() {
        projectHandler.detail();
      }});

    projectMenu.add(new Menu("변경") {
      @Override
      public void execute() {
        projectHandler.update();
      }});

    projectMenu.add(new Menu("삭제") {
      @Override
      public void execute() {
        projectHandler.delete();
      }});

    MenuGroup taskMenu = new MenuGroup("작업");
    mainMenuGroup.add(taskMenu);

    taskMenu.add(new Menu("등록") {
      @Override
      public void execute() {
        taskHandler.add();
      }});

    taskMenu.add(new Menu("목록") {
      @Override
      public void execute() {
        taskHandler.list();
      }});

    taskMenu.add(new Menu("상세보기") {
      @Override
      public void execute() {
        taskHandler.detail();
      }});

    taskMenu.add(new Menu("변경") {
      @Override
      public void execute() {
        taskHandler.update();
      }});

    taskMenu.add(new Menu("삭제") {
      @Override
      public void execute() {
        taskHandler.delete();
      }});


    return mainMenuGroup; //둘 다 메뉴야 MenuGroup이나 MenuItem이나
  }


  void doBoardMenu() {
    while (true) {
      System.out.println("[메인/게시판]");
      System.out.println("1. 등록");
      System.out.println("2. 목록");
      System.out.println("3. 상세보기");
      System.out.println("4. 변경");
      System.out.println("5. 삭제");
      System.out.println("0. 이전메뉴");

      int menuNo = Prompt.inputInt("게시판> ");
      switch (menuNo) {
        case 1: boardHandler.add(); break;
        case 2: boardHandler.list(); break;
        case 3: boardHandler.detail(); break;
        case 4: boardHandler.update(); break;
        case 5: boardHandler.delete(); break;
        case 0: return;
        default:
          System.out.println("무효한 메뉴 번호입니다.");
      }
      System.out.println();
    }
  }

  void doMemberMenu() {
    while (true) {
      System.out.println("[메인/회원]");
      System.out.println("1. 등록");
      System.out.println("2. 목록");
      System.out.println("3. 상세보기");
      System.out.println("4. 변경");
      System.out.println("5. 삭제");
      System.out.println("0. 이전메뉴");

      int menuNo = Prompt.inputInt("회원> ");
      switch (menuNo) {
        case 1: memberHandler.add(); break;
        case 2: memberHandler.list(); break;
        case 3: memberHandler.detail(); break;
        case 4: memberHandler.update(); break;
        case 5: memberHandler.delete(); break;
        case 0: return;
        default:
          System.out.println("무효한 메뉴 번호입니다.");
      }
      System.out.println();
    } 
  }

  void doProjectMenu() {
    while (true) {
      System.out.println("[메인/프로젝트]");
      System.out.println("1. 등록");
      System.out.println("2. 목록");
      System.out.println("3. 상세보기");
      System.out.println("4. 변경");
      System.out.println("5. 삭제");
      System.out.println("0. 이전메뉴");

      int menuNo = Prompt.inputInt("프로젝트> ");
      switch (menuNo) {
        case 1: projectHandler.add(); break;
        case 2: projectHandler.list(); break;
        case 3: projectHandler.detail(); break;
        case 4: projectHandler.update(); break;
        case 5: projectHandler.delete(); break;
        case 0: return;
        default:
          System.out.println("무효한 메뉴 번호입니다.");
      }
      System.out.println();
    }
  }

  void doTaskMenu() {
    while (true) {
      System.out.println("[메인/작업]");
      System.out.println("1. 등록");
      System.out.println("2. 목록");
      System.out.println("3. 상세보기");
      System.out.println("4. 변경");
      System.out.println("5. 삭제");
      System.out.println("0. 이전메뉴");

      int menuNo = Prompt.inputInt("작업> ");
      switch (menuNo) {
        case 1: taskHandler.add(); break;
        case 2: taskHandler.list(); break;
        case 3: taskHandler.detail(); break;
        case 4: taskHandler.update(); break;
        case 5: taskHandler.delete(); break;
        case 0: return;
        default:
          System.out.println("무효한 메뉴 번호입니다.");
      }
      System.out.println();
    }
  }

  static int doMainMenu() {
    System.out.println("[메인]");
    System.out.println("1. 게시판");
    System.out.println("2. 회원");
    System.out.println("3. 프로젝트");
    System.out.println("4. 작업");
    System.out.println("0. 종료");
    return Prompt.inputInt("메인> "); 
  }

}













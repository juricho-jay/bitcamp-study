package com.eomcs.pms.menu;

import com.eomcs.util.Prompt;

public class MenuGroup extends Menu {
  Menu[] childs = new Menu[100];
  int size;
  boolean disablePrevMenu;
  String prevMenuTitle = "이전 메뉴";


  public MenuGroup(String title) {
    super(title);
  }

  public MenuGroup(String title, boolean disablePrevMenu) {
    super(title);
    this.disablePrevMenu = disablePrevMenu;
  }

  public void setPrevMenuTitle(String prevMenuTitle) {
    this.prevMenuTitle = prevMenuTitle;
  }


  @Override
  public void execute() {
    while (true) {
      System.out.printf("\n[%s]\n", this.title); //" ? " 더블쿼테이션마크 안에는
      //this.title이 들어온다. Menu(String title)에 입력되는 것
      for (int i = 0;  i < this.size; i++) {
        System.out.printf("%d. %s\n", i + 1, this.childs[i].title);
        // 1. 게시판, 2. 회원 이런식으로 출력되도록
        // int i = 0부터 시작하지만 출력되는 메뉴는 1부터 시작하므로
        // i + 1!!!
      }

      if (!disablePrevMenu) {
        System.out.printf("0. %s\n", this.prevMenuTitle); //이전 메뉴로 갈 코드
      }

      int menuNo = Prompt.inputInt("선택> ");
      if (menuNo == 0 && !disablePrevMenu) {//번호가 0이고 disableprevmenu가 아니면
        // 실행 끝
        return;
      }

      if(menuNo < 0 || menuNo > this.size) {
        System.out.println("무효한 메뉴 번호입니다.");
        continue;
      }

      this.childs[menuNo - 1].execute(); // i 값에 1을 더했으니 - 1!

    }
  }

}

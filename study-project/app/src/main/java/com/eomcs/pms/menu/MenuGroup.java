package com.eomcs.pms.menu;

import com.eomcs.util.Prompt;

public class MenuGroup extends Menu {
  Menu[] childs = new Menu[100]; // childs 레퍼런스 변수에 Menu 설계도로 만든 변수 100개?
  //객체 100개?
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

  public void add(Menu child) {
    if (this.size == this.childs.length) { //입력한 데이터 사이즈가 childs 배열 길이
      // 하위 메뉴를 저장하는 배열이 꽉차면 더 이상 저장하면 안됨
      return;
    }
    this.childs[this.size++] = child;
  }

  // 배열에 들어있는 Menu 객체를 찾아 제거한다. 
  public Menu remove(Menu child) { // child 찾자~
    int index = indexOf(child); //객체 번호 알아내기 (child의 번호 알아내기)
    if (index == -1) { 
      return null; //null로 리턴하면 아마 해당 번호의 ~가 없습니다 출력하겠지
    }
    for (int i = index + 1; i < this.size; i++) {// 뒷 번호 인덱스로 겹쳐서 제거하기
      this.childs[i - 1] = this.childs[i]; //  i = index+1이므로 i - 1이 해당 객체
      // i가 뒷 번호 객체 (다음 객체)
    }
    childs[--this.size] = null; // 삭제했으니 size 1개 줄이고 마지막은 null로 초기화 
    return child;
  }


  // 배열에 들어 있는 Menu 객체의 인덱스를 알아낸다.
  public int indexOf(Menu child) { // 해당 객체의 번호> int로 리턴해야
    for (int i = 0; i < this.size; i++) {
      if (this.childs[i] == child) {
        return i;
      }
    }
    return -1; // 다 해당 안되면 -1 해서 > 해당 번호의 ~가 없습니다 출력
  }

  // 배열에 있는 Menu 객체 찾기
  public Menu getMenu(String title) {
    for (int i = 0; i < this.size; i++) {
      if (this.childs[i].title.equals(title)) {
        return this.childs[i];
      }
    }
    return null;
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

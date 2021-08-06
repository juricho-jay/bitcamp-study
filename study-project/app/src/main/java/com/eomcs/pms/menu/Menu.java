package com.eomcs.pms.menu;

public abstract class Menu {

  String title;

  public Menu(String title) {
    this.title = title;
  }

  public abstract void execute();

}


//그대로 두면
// Menu(); 이렇게 but 파라미터 넣어야해서 
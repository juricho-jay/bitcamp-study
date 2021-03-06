package com.eomcs.pms.handler;

import java.sql.Date;
import com.eomcs.pms.domain.Member;
import com.eomcs.util.Prompt;

public class MemberHandler {

  static final int MAX_LENGTH = 5;

  Member[] members = new Member[MAX_LENGTH];
  int size = 0;

  public void add() {
    System.out.println("[회원 등록]");

    Member member = new Member();

    member.no = Prompt.inputInt("번호? ");
    member.name = Prompt.inputString("이름? ");
    member.email = Prompt.inputString("이메일? ");
    member.password = Prompt.inputString("암호? ");
    member.photo = Prompt.inputString("사진? ");
    member.tel = Prompt.inputString("전화? ");
    member.registeredDate = new Date(System.currentTimeMillis());

    System.out.println("회원 정보를 등록하였습니다.");
    this.members[this.size++] = member;
  }

  public void list() {
    System.out.println("[회원 목록]");
    for (int i = 0; i < this.size; i++) {
      System.out.printf("%d, %s, %s, %s, %s\n", 
          this.members[i].no, 
          this.members[i].name, 
          this.members[i].email, 
          this.members[i].tel, 
          this.members[i].registeredDate);
    }
  }

  boolean exist(String name) {
    for (int i = 0; i < this.size; i++) {
      if (this.members[i].name.equals(name)) {
        return true;
      }
    }
    return false;
  }

  public void detail() {
    System.out.println("[회원 정보 상세보기]");

    int no = Prompt.inputInt("번호? ");

    Member member = null; //으아아아아아아아

    for (int i = 0; i < this.size; i++) {
      if (members[i].no == no) {
        member = members[i];
        break;
      }

      if (member == null)/*으아아아아*/ {
        System.out.println("해당 번호의 회원이 없습니다.");
        return;
      }
    }

    System.out.printf("이름: %s\n", member.name);
    System.out.printf("이메일: %s\n", member.email);
    System.out.printf("사진: %s\n", member.photo);
    System.out.printf("전화: %s\n", member.tel);
    System.out.printf("등록일: %s\n", member.registeredDate);

  }

  public void update() {
    System.out.println("[회원 정보 변경]");

    int no = Prompt.inputInt("번호? ");

    Member member = null;
    for (int i = 0; i < this.size; i++) {
      if (members[i].no == no) {
        member = members[i];
        break;
      }
    }

    if (member == null) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    String name = Prompt.inputString(String.format("이름(%s)", member.name));
    String email = Prompt.inputString(String.format("이메일(%s)", member.email));
    String tel = Prompt.inputString(String.format("전화(%s)", member.tel));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("회원 변경을 취소하였습니다.");
      return;
    }
    if (input.equalsIgnoreCase("y")) {
      System.out.println("회원 정보를 변경하였습니다.");

      member.name = name;
      member.email = email;
      member.tel = tel;
    }



  }
}










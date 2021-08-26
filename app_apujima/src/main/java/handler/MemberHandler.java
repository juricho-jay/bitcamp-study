package handler;

import java.sql.Date;
import domain.Member;
import util.Prompt;

public class MemberHandler {

  static final int MAX_LENGTH = 50;

  Member[] members = new Member[MAX_LENGTH];
  int size = 0;


  public static void add() {
    System.out.println("APUJIMA에 오신 것을 환영합니다.");
    System.out.println("[회원가입]");

    Member member = new Member();

    member.setNo(Prompt.inputInt("번호? "));
    member.setName(Prompt.inputString("이름? "));
    member.setBirthDay(Prompt.inputString("생일? "));
    member.setEmail(Prompt.inputString("email? "));
    member.setPhoneNum(Prompt.inputString("tel? "));
    member.setPhoto(Prompt.inputString("사진? "));
    member.setRegisteredDate(new Date(System.currentTimeMillis()));

  }

  public void list() {
    Member member = new Member();
    System.out.println("[회원 정보]");
    System.out.printf("%d, %s, %s, %s, %s, %s, %s\n",
        member.getNo(),
        member.getName(),
        member.getBirthDay(),
        member.getEmail(),
        member.getPhoneNum(),
        member.getPhoto(),
        member.getRegisteredDate());
  }









}


// 아규먼트에 람다(lambda) 활용
package com.eomcs.oop.ex12;

public class Exam0310 {

  static interface Player { //(앞에 public 생략) interface는 모두 public static field)
    void play();
  }

  static void testPlayer(Player p) {
    p.play();
  }

  public static void main(String[] args) {
    // 로컬 클래스 -> 익명클래스로
    class MyPlayer implements Player { //Player 인터페이스를 구현한 MyPlayer 
      //클래스도 상속받고 인터페이스도 구현하는 경우에는 익명 클래스로 만들 수 없음
      @Override
      public void play() {
        System.out.println("실행!");
      }
    }

    testPlayer(new MyPlayer()); //인스턴스 1번만 생성? > 익명 클래스로

  }
}




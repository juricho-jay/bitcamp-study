// 제네릭(Generic) 문법 정리 - 레퍼런스와 인스턴스 생성 
package com.eomcs.generic.ex02;

import java.util.ArrayList;

public class Exam0213 {

  static class A {}
  static class B1 extends A {}
  static class B2 extends A {}
  static class C extends B1 {}
  /*
   *   Object
   *     |
   *     A
   *    / \
   *   B1 B2
   *   |
   *   C
   */

  public static void main(String[] args) {

    ArrayList<A> list1;

    list1 = new ArrayList(); // 이렇게 사용하지 말고, 명확히 제네릭의 타입을 지정하라.
    //    list1 = new ArrayList<Object>(); // 컴파일 오류! A를 다룬다고 위에서 명시함
    list1 = new ArrayList<>();
    list1 = new ArrayList<A>();
    //    list1 = new ArrayList<B1>(); // 컴파일 오류! B1은 자식인데 안되나? > 안됨
    //    list1 = new ArrayList<B2>(); // 컴파일 오류! 얘는 다형적 변수가 아님
    //    list1 = new ArrayList<C>(); // 컴파일 오류!

    list1.add(new B2()); // 이건 되는데...? 다형적 변수하고 구분할 것

    ArrayList<B2> list2; // B2목록을 다루기로 했으면 그 목록을 다뤄야지
    // ArrayList는 다형적 변수랑 상관이 없음

    list2 = new ArrayList(); // 이렇게 사용하지 말고, 명확히 제네릭의 타입을 지정하라.
    //list2 = new ArrayList<Object>(); // 컴파일 오류!
    list2 = new ArrayList<>();
    //list2 = new ArrayList<A>(); // 컴파일 오류!
    //list2 = new ArrayList<B1>(); // 컴파일 오류!
    list2 = new ArrayList<B2>();
    //list2 = new ArrayList<C>(); // 컴파일 오류!
  }
}









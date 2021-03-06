// local class에서 바깥 메서드의 로컬 변수 접근
package com.eomcs.oop.ex11.d;

class D22 {
  int v1 = 1;

  void m1() {
    int v2 = 2;

    class X {
      int v3 = 3;

      // 로컬 클래스는 바깥 클래스의 인스턴스 주소를 저장할 필드가 있을 뿐만 아니라
      // 인스턴스 메서드 안에 선언된 로컬 변수의 값을 저장할 필드도 있다.
      // .class 파일의 코드:
      //      class com.eomcs.oop.ex11.d.D$1X {
      //
      //        int v3; <== 로컬 클래스의 인스턴스 필드
      //        final synthetic com.eomcs.oop.ex11.d.D this$0;  <== 바깥 클래스의 인스턴스 주소 저장
      //        private final synthetic int val$v2; <== 바깥 메서드의 로컬 변수 저장
      //

      void f() {
        int v4 = 4;
        System.out.printf("v4 = %d\n", v4);  // f()의 로컬 변수
        System.out.printf("v3 = %d\n", this.v3); // X 인스턴스의 변수
        System.out.printf("v1 = %d\n", D22.this.v1); // D2의 인스턴스 변수

        // 바깥 메서드의 로컬 변수를 사용할 때는
        // 자신의 메서드인양 사용하면 된다.
        System.out.printf("v2 = %d\n", v2); // D2.m1()의 로컬 변수
      }
    }

    X obj = new X();
    obj.f();
  }
}

public class Exam0322 {

  public static void main(String[] args) {
    D22 obj = new D22();
    obj.m1();
  }

}

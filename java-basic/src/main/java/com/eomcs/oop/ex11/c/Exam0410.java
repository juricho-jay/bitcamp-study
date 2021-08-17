// inner class : import 사용
package com.eomcs.oop.ex11.c;

// 중첩 클래스를 직접 import 할 수 있다.
// => import가 하는 일은 클래스를 로딩하는 것이 아니다!
// => 컴파일러에게 클래스의 위치를 알려주는 것이다.
import com.eomcs.oop.ex11.c.D.X;
import com.eomcs.oop.ex11.c.sub.M;
import com.eomcs.oop.ex11.c.sub.M.Y;

class D {
  class X {
    void test() {
      System.out.println("test()");
    }
  }
}

public class Exam0410 {

  public static void main(String[] args) {

    //레퍼런스 선언 시에는 클래스를 로딩하지 않음
    //인스턴스 생성, 인스턴스 멤버 호출 시에 클래스를 로딩함


    D outer = new D();
    X obj = outer.new X();
    obj.test();

    M outer2 = new M();
    Y obj2 = outer2.new Y();
    obj2.test();
  }

}

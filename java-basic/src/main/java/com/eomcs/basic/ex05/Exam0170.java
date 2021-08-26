// Stack 클래스 사용법 - Iterator 사용
package com.eomcs.basic.ex05;

import java.util.Iterator;
import java.util.Stack;

public class Exam0170 {

  public static void main(String[] args) {
    Stack<String> stack = new Stack<>();

    // push() - 스택의 맨 마지막에 값을 추가한다.
    stack.push("aaa");
    stack.push("bbb");
    stack.push("ccc");

    Iterator<String> iterator = stack.iterator();

    for (String s : stack) { //stack 자리에는 iterable 사용법에 따라 만든 객체가 올 수 있음
      // stack도 iterable 구현체이기 대문에 다음과 같이 for ( : ) 문을 사용할 수 있다.
      // => 내부적으로는 iterator()를 호출하여 Iterator를 꺼낸 후에
      //    이 Iterator를 통해서 값을 꺼낸다.
      // => 결국 Exam0160과 같다.
      //    즉 EXam0160 처럼 개발자가 직접 iterator()를 호출하여 Iterator를 얻은 후에
      //    hasNext()와 next()를 사용할 것인지,
      //    아니면 다음과 같이 for( : )문을 통해 간접적으로 처리할 것인지 선택하면 된다.
      System.out.println(s);
    }

  }

}


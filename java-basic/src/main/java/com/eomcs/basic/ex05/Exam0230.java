// Deque의 Iterator 와 for(:)문
package com.eomcs.basic.ex05;

import java.util.ArrayDeque;

public class Exam0230 {

  public static void main(String[] args) {

    //Deque 인터페이스
    // - "Double ended queue"의 약자이다.
    //   즉 앞, 뒤 모두 양방향에서 값을 넣고 꺼낼 수 있다.
    //   그래서 큐로도 사용할 수 있고 스택으로도 사용할 수 있다.
    // - 큐, 스택 둘 다 사용할 수 있도록 queue와 stack 사용법을 모두 정의한 인터페이스다.

    // 다음은 Dequeue 구현체 중 하

    ArrayDeque<String> stack = new ArrayDeque<>();

    stack.push("aaa");
    stack.push("bbb");
    stack.push("ccc");


    // Iterator를 통해 데이터를 조회하고 싶다면,
    // 다음과 같이 for(:) 문을 사용하는 것이 더 낫다.
    for (String s : stack) {
      System.out.println(s);
    }

  }

}


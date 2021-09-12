package com.eomcs.pms;

import java.util.HashSet;
import java.util.Iterator;

public class Example {

  public static void main(String[] args) {
    HashSet<Integer> A = new HashSet<>();
    A.add(1);
    A.add(1);
    A.add(1);

    //가상의 컨테이너

    Iterator hi = A.iterator();
    while(hi.hasNext()) {
      System.out.println(hi.next());
    }



  }

}

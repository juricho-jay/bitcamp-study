package com.eomcs.pms;

public class Exercise6_4 {

  public static void main(String args[]) {
    Student s = new Student();
    s.name = "홍길동";
    s.ban = 1;
    s.no = 1;
    s.kor = 100;
    s.eng = 60;
    s.math = 76;

    System.out.println("이름:" +s.name);
    System.out.println("이름:" +s.getTotal());
    System.out.println("이름:" +s.getAverage());
  }
}

class Student {
  public String name;
  public int ban;
  public int no;
  public int kor;
  public int eng;
  public int math;
  public int total;

  //  Student(){
  //    this.name = null;
  //    this.ban = 0;
  //  }

  //  public int getTotal(int kor, int eng, int math) {
  //    return kor + eng + math;
  //  }

  public int getTotal() {
    total = kor + eng + math;
    return total;
  }

  public float getAverage() {
    float answer = Math.round(total/3.0f * 10)/10.0f; 
    return answer;
  }
}




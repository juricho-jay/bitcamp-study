package com.eomcs.pms;

public class Exercise6_5 {

  public static void main(String args[]) {
    Student2 s = new Student2("홍길동", 1, 1, 100, 60, 76);
    System.out.println(s.info());
  }
}


class Student2 {
  String name;
  int ban;
  int no;
  int kor;
  int eng;
  int math;
  int total;
  float answer;


  Student2(String name, int ban, int no, int kor, int eng, int math) {
    this.name = name;
    this.ban = ban;
    this.no = no;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
  }

  public int getTotal() {
    total = kor + eng + math;
    return total;
  }

  public float getAverage() {
    float answer = Math.round(total/3.0f * 10)/10.0f; 
    return answer;
  }

  String info() {
    return name + ", " + ban + ", " + no + ", " 
        + kor + ", " + eng + ", " + math + ", " + getTotal() + ", " + getAverage();
  }


}




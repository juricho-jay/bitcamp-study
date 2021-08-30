package com.eomcs.pms;

public class practice3 {

  public static boolean isNumber(String str) {
    if (str == null || str == "") {
      return false;
    }
    for(int i = 0 ; i < str.length() ; i++) {
      char a =  str.charAt(i);
      if(a < '0' || a > '9') {
        return false;
      }
    }
    return true;
  } // return되는 순간 메서드는 끝남! 1부터 트루면 메서드 끝나버림 헐랭

  public static void main(String[] args) {
    String str = "123";
    System.out.println(str+"는 숫자입니까? "+isNumber(str));
    str = "1234o";
    System.out.println(str+"는 숫자입니까? "+isNumber(str));
  }
}

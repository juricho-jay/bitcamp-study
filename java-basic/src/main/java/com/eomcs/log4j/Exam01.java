// Log4j 2 사용법
package com.eomcs.log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Log4j
// - 프로그램을 실행하는 중에 특정 변수의 값이나 상태, 오류 내용을
//   콘솔이나 파일에 기록하고 싶을 때 사용하는 라이브러리이다.
// - 단계 별로 출력을 제어할 수 있다.
// - 프로그램 실행 과정을 추적하거나 디버깅 할 때 유용하다.
// 
// 사용법
// 1) log42 라이브러리 파일을 프로젝트에 포함한다.
// 
public class Exam01 {
  // 기록을 남길 때 사용할 도구 준지
  // - 클래스 당 한 개의 도구만있어도 된다.

  private static final Logger logger = LogManager.getLogger(Exam01.class);

  public static void main(String[] args) {

    // 로깅 도구 없이 기록을 남기는 방법
    System.out.println("고전적인 방법으로 기록을 남기기!");

    // 로깅 도구를 사용하여 기록을 남기는 방법
    logger.fatal("내용 ==> {}, {}, {}", "FATAL", "aaa", 100);
    logger.error("ERROR");
    logger.warn("WARN");
    logger.info("INFO");
    logger.debug("DEBUG");
    logger.trace("TRACE");
  }
}


// 로그 레벨 중요도 
// trace < debug < info < warn < error < fatal
//
// 1) trace
//  - 실행 과정을 순서대로 자세하게 확인하고 싶을 때 사용한다.
// 2) debug
//  - 개발자 입장에서 변수의 값을 확인하고 싶을 때 사용한다.
// 3) info
//  - 주요 메서드의 호출이나 실행 흐름을 확인하고 싶을 때 사용한다.
// 4) warn
//  - 시스템 실행 
// 5) error
// 
// 6) fatal
//
//
//
//















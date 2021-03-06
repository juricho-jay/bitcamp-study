package com.eomcs.pms.handler;

import java.sql.Date;
import com.eomcs.pms.domain.Board;
import com.eomcs.util.Prompt;

public class BoardHandler {


  static class Node {
    Board board; // 보드 객체 주소
    Node next; //다음 노드 주소

    public Node(Board board) {
      this.board = board;
      //앞은 인스턴스 보드 뒤는 파라미터 보드
    }
  }

  int size = 0;

  Node head; // 앞쪽 노드
  Node tail; // 꼬리쪽 노드

  public void add() {
    System.out.println("[새 게시글]");

    Board board = new Board();

    board.no = Prompt.inputInt("번호? ");
    board.title = Prompt.inputString("제목? ");
    board.content = Prompt.inputString("내용? ");
    board.writer = Prompt.inputString("작성자? ");
    board.registeredDate = new Date(System.currentTimeMillis());
    //    board.viewCount = 0; // 인스턴스 변수는 생성되는 순간 기본 값이 0으로 설정된다.


    // 새 노드를 만든다. 이때 생성자를 호출할 때, 노드에 담을 Board 객체 주소를 넘긴다.
    Node node = new Node(board); // board 객체 주소를 줌 > 객체를 넘긴다 > 객체를 리턴 (주소 생략)

    if (head == null) {/* this.head */
      tail = head = node;
    } else {
      // 기존에 테일이 가리키는 마지막 노드의 next 변수에 새 노드 주소를 저장한다.
      tail.next = node; 

      // 새로 만든 노드를 마지막 노드로 설정한다.
      tail = node;
    }

    size++;

  }


  public void list() {
    System.out.println("[게시글 목록]");
    if (head == null) {
      return;
    } 

    Node node = head;


    do { 
      System.out.printf("%d, %s, %s, %s, %d, %d\n", 
          node.board.no, 
          node.board.title, 
          node.board.writer,
          node.board.registeredDate,
          node.board.viewCount, 
          node.board.like);
      node = node.next;
    } while (node != null);
  }

  public void detail() {
    System.out.println("[게시글 상세보기]");
    int no = Prompt.inputInt("번호? ");

    Board board = findByNo(no);

    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    System.out.printf("제목: %s\n", board.title);
    System.out.printf("내용: %s\n", board.content);
    System.out.printf("작성자: %s\n", board.writer);
    System.out.printf("등록일: %s\n", board.registeredDate);
    System.out.printf("조회수: %d\n", ++board.viewCount);
  }

  public void update() {
    System.out.println("[게시글 변경]");
    int no = Prompt.inputInt("번호? ");

    Board board = findByNo(no);

    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    String title = Prompt.inputString(String.format("제목(%s)? ", board.title));
    String content = Prompt.inputString(String.format("내용(%s)? ", board.content));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("게시글 변경을 취소하였습니다.");
      return;
    }

    board.title = title;
    board.content = content;
    System.out.println("게시글을 변경하였습니다.");
  }

  public void delete() {
    System.out.println("[게시글 삭제]");
    int no = Prompt.inputInt("번호? ");

    Board board = findByNo(no);

    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("게시글 삭제를 취소하였습니다.");
      return;
    }


    Node node = head;
    Node prev = null;

    while (node != null) {
      if (node.board == board) {
        // 찾은 노드를 삭제해야 한다.
        if (node == head) {
          head = node.next;
        } else {
          prev.next = node.next; // 이전 노드를 다음 노드와 연결한다.
        }

        node.next = null; // 다음 노드와의 연결을 끊는다.

        if (node == tail) { // 삭제할 현재 노드가 마지막 노드라면, (노드 하나만 남았을 때도 )
          tail = prev; // 이전 노드를 마지막 노드로 설정한다.
        }
        break;
      }

      // 못찾았으면 현재 노드가 아니라면, 
      prev = node; // 현재 노드의 주소를 prev 변수에 저장하고,
      node = node.next; // node 변수에는 다음 노드의 주소를 저장한다.

    }
    size--;

    System.out.println("게시글을 삭제하였습니다.");
  }

  private Board findByNo(int no) {
    Node node = head;

    while (node != null) {
      if (node.board.no == no) {
        return node.board;
      }
      node = node.next;
    }
    return null;
  }

  /* if (head == null) {
      return null;
    }

    Node node = head;

    do {
      if (node.board.no == no) {
        return node.board;
      }
      node = node.next;
    } while (node != null);

    return null;
  }
   */

}








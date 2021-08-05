package com.eomcs.pms.handler;

import java.sql.Date;
import com.eomcs.pms.domain.Member;
import com.eomcs.util.Prompt;

public class MemberHandler {

  static class Node {
    Member member; //멤버 객체 주소
    Node next; //다음 노드 주소

    public Node(Member member) {
      this.member = member;
    }
  }

  int size = 0;

  Node head;
  Node tail;


  public void add() {
    System.out.println("[회원 등록]");

    Member member = new Member();

    member.no = Prompt.inputInt("번호? ");
    member.name = Prompt.inputString("이름? ");
    member.email = Prompt.inputString("이메일? ");
    member.password = Prompt.inputString("암호? ");
    member.photo = Prompt.inputString("사진? ");
    member.tel = Prompt.inputString("전화? ");
    member.registeredDate = new Date(System.currentTimeMillis());

    Node node = new Node(member);
    //새 노드를 만든다. 생성자 호출 시 노드에 담을 Member의 객체 주소가 담긴 member 변수를 넘긴다.

    if (head == null) { // head에 아무런 주소가 없을 경우
      tail = head = node; // 새로운 노드 생성 => tail head 모두 같음
    } else { // 노드가 이미 있을 경우
      // 기존의 테일이 가리키는 마지막 노드의 next 변수에 새 노드 주소를 저장
      tail.next = node;

      //새로 만든 노드를 마지막 노드, 즉 tail 노드로 설정한다.
      tail = node;
    }
    size ++; // 노드 크기 +1
  }

  public void list() {
    System.out.println("[회원 목록]");
    if (head == null) { // head에 주소가 없으면 회원이 없는 것을 의미하니 그대로 if문 탈출
      return;
    }

    Node node = head; 
    //head에 주소가 있는 경우에는 head 주소를 Node 설계도로 만들진 node 변수에 담는다.

    do { // node에 주소가 있으면-null이 아니면 do{}를 계속 실행해라.
      System.out.printf("%d, %s, %s, %s, %s\n", 
          node.member.no, 
          // 따라서 node에 있는 member에서 no 변수 찾아 출력해라
          node.member.name, 
          node.member.email, 
          node.member.tel, 
          node.member.registeredDate);
      node = node.next; // 다음 노드 조사 (빼먹으면 무한 조사, 무한 루프)
    } while (node != null); // node에 주소가 있으면-null이 아니면 
    // 계속 넣다보면 tail 마지막에 null이 나오고 node == null이 되어 반복문 탈출!
  }

  public void detail() {
    System.out.println("[회원 상세보기]");
    int no = Prompt.inputInt("번호? ");

    Member member = findByNo(no);

    if (member == null) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    System.out.printf("이름: %s\n", member.name);
    System.out.printf("이메일: %s\n", member.email);
    System.out.printf("사진: %s\n", member.photo);
    System.out.printf("전화: %s\n", member.tel);
    System.out.printf("등록일: %s\n", member.registeredDate);
  }

  public void update() {
    System.out.println("[회원 변경]");
    int no = Prompt.inputInt("번호? ");

    Member member = findByNo(no);

    if (member == null) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    String name = Prompt.inputString("이름(" + member.name  + ")? ");
    String email = Prompt.inputString("이메일(" + member.email + ")? ");
    String password = Prompt.inputString("암호? ");
    String photo = Prompt.inputString("사진(" + member.photo + ")? ");
    String tel = Prompt.inputString("전화(" + member.tel + ")? ");

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("회원 변경을 취소하였습니다.");
      return;
    }

    member.name = name;
    member.email = email;
    member.password = password;
    member.photo = photo;
    member.tel = tel;

    System.out.println("회원을 변경하였습니다.");
  }

  public void delete() {
    System.out.println("[회원 삭제]");
    int no = Prompt.inputInt("번호? ");

    Member member = findByNo(no);

    if (member == null) { //위에서 findByNo 실행해서 조사한 결과를 member에 담아둠 
      System.out.println("해당 번호의 회원이 없습니다.");
      return; // 일치하는 회원 번호 없으니 실행 끝
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("회원 삭제를 취소하였습니다.");
      return;
    }

    Node node = head;  // head 주소를 Node 설계도로 만들진 node 변수에 담는다.
    Node prev = null; // 이전 변수 필요하니 prev 변수 생성하고 null 초기화.
    // reference type은 null로 초기화해야함.

    while (node != null) {
      if (node.member == member) { 
        // node가 null이 아니고 
        // node 안의 member가 findByNo로 찾은 member와 같다면
        // 찾은 노드를 삭제해야 한다.
        if (node == head) { //첫 번째 노드를 삭제하려면
          head = node.next; // 두 번째 노드를 head-첫번째 노드로 담는다
        } else { // 첫 번째 노드가 아니라면
          prev.next = node.next; // 현재 노드는 제외하고 이전 노드를 다음 노드와 연결한다.
        }
        node.next = null; // 다음 노드와의 연결을 끊는다. 가비지 관리용!

        if (node == tail) {// 삭제할 현재 노드가 마지막 노드면 (노드 하나만 남아도)
          tail = prev; // 이전 노드를 마지막 노드로 설정한다.
        }
        break;
      }

      // 일치하는 노드를 못찾은 경우 > 현재 노드가 우리가 찾는 노드가 아니라면
      prev = node; // 현재 노드 주소는 prev 변수에 저장하고,
      node = node.next; // 다음 노드의 주소를 (현재가 되는) node 변수에 저장한다.

    }

    size--; // 삭제했으므로 노드 값 하나 삭제 

    System.out.println("회원을 삭제하였습니다.");
  }


  private Member findByNo(int no) {
    Node node = head; // head 주소를 Node 설계도로 만들진 node 변수에 담는다.
    // 이 Node node = head를 전역 변수로 만들어버리면 샤발 모든 메소드를 한 방에 다 넣어야한다.
    // 그러니까 닥치고 이 메소드 안에서만 활용되는 로컬 변수로 쓴다 ^^

    while (node != null) { // node가 null이 아닐 경우- node에 주소가 있을 때
      if (node.member.no == no) { // node에 있는 member의 no변수가 
        // int no = Prompt.inputInt("번호? "); 여기서 입력한 no 변수와 같을 때
        return node.member; // node에 들어간 Member 클래스 객체 주소를 리턴한다. 
        //리턴 안하면 찾기만 하고 뱉어내질 못하잖아
      }
      // no 변수가 일치하지 않을 때는 다음 노드를 조사한다. (if문, 아직 while문 안끝남)
      node = node.next;

    }
    // 조사하다 조사하다 tail까지 다다라 node = null이 되면 while문 탈출! 
    // 그냥 return; 하지 않는 이유는 위에서 member 값이 null이여야 
    // "해당 번호의 회원이 없습니다"를 출력할 수 있기 때문이다.
    return null;
  }

  /* if (head == null) {
   * return null;
   * }
   * 
   * Node node = head;
   * 
   * do {
   * if (node.member.no == no) {
   *    return node.member;
   *    }
   *    node = node.next;
   *} while (node != null);
   *
   *return null
   *}
   *    
   */

  boolean exist(String name) {
    Node node = head;

    while (node != null) {
      if (node.member.name.equals(name)) {
        return true;
      }
      node = node.next; // 다음 사람을 null 나올 때까지 조사해야지!!!!!
    }
    return false;
  }



}








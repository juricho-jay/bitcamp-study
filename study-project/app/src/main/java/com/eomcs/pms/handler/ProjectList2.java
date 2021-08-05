package com.eomcs.pms.handler;

import com.eomcs.pms.domain.Project;

public class ProjectList2 {

  static class Node {
    Project project;
    Node next;

    public Node(Project project) {
      this.project = project;
    }
  }

  Node head;
  Node tail;

  int size = 0;

  public void add(Project project) {
    Node node = new Node(project);

    if (head == null) {
      tail = head = node;
    } else {
      // 기존에 tail이 가리키는 마지막 노드의 next 변수에 새 노드 주소를 저장한다.
      tail.next = node;

      // 새로 만든 노드를 마지막 노드로 설정한다. 
      tail = node;
    }

    size++;
  }
  public Project[] toArray() {
    Project[] arr = new Project[this.size]; // 배열에 저장된 값을 담을 정도의 크기를 가진 새 배열을 만든다.
    Node node = head;


    for (int i = 0; i < this.size; i++) {
      arr[i] = node.project;
      node = node.next;

    }
    return arr; // 새 배열을 리턴한다.
  }

  public Project findByNo(int no) { 
    Node node = head;

    while (node != null) {
      if (node.project.no == no) {
        return node.project;
      }
      node = node.next;
    }
    return null;
  }

  public boolean remove(Project project) {
    Node node = head;
    Node prev = null;

    while (node != null) {
      if (node.project == project) { // 노드에 들어 있는 객체와 같다면
        if (node == head) { // 삭제할 노드가 하필이면 첫 번째 노드라면
          head = node.next; // head가 두 번째 노드를 가리키게 한다.
        } else { //삭제할 노드가 첫 번째 노드가 아니라면
          prev.next = node.next; // 이전 노드를 다음 노드와 연결한다.
        }

        node.next = null; // 삭제할 노드가 더이상 다음 노드를 가리키지 않게 한다

        if (node == tail) { // 삭제할 노드가 마지막 노드라면
          tail = prev; // tail이 이전 노드를 가리키게 한다.
        }
        size --; // 삭제했으니 사이즈 줄이자
        return true; //반복문을 나간다.
      }

      // 현재 노드가 아니라면,
      prev = node; // 현재 노드를 prev에 저장하고,
      node = node.next; // node는 다음 노드를 가리킨다.
    }

    return false; // 반복문이 끝날 때까지 리턴하지 않았다면 못찾은 거니까 false가 됨
  }
}









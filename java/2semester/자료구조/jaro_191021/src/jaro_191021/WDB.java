package jaro_191021;

import java.util.Scanner;

public class WDB {

	public static void main(String[] args) {
		LinkedList L = new LinkedList();
		System.out.println("1 첫번째 노드 삽입");
		System.out.println("2 찾아서 다음 노드에 삽입");
		System.out.println("3 마지막 노드에 삽입");
		System.out.println("4 첫번째 노드 삭제");
		System.out.println("5 찾은 노드 삭제");
		System.out.println("6 마지막 노드 삭제");
		System.out.println("7 리스트 출력");
		System.out.println("8 끝내기");
		
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		
		
		L.insertFirstNode("월");
		L.insertFirstNode("수");
		L.insertFirstNode("일");
		
		switch(a) {
		//첫번째 노드 삽입
		case 1:
			L.insertFirstNode("일2");
			L.printList();
		break;
		//찾아서 다음 노드에 삽입
		case 2:
			System.out.println("찾을 값 입력");
			
			Scanner input2 = new Scanner(System.in);
			String a2 = input2.next();
			
			 ListNode pre2 = L.searchNode(a2);
			 
			   if(pre2 == null)
			      System.out.println("검색실패>>찾는 데이터가 없습니다.");
			   else {
			      L.insertMiddleNode(pre2,"금");
			      L.printList();
			   }
			break;
		//마지막 노드에 삽입
		case 3:
			L.insertFirstNode("토");
			L.printList();
			break;
			
		//첫번째 노드 삭제
		case 4:
			L.deleteFirstNode();
			L.printList();
			break;
		//찾은 노드 삭제
		case 5:
			System.out.println("찾을 값 입력");
			
			Scanner input3 = new Scanner(System.in);
			String a3 = input3.nextLine();
			
			ListNode b = L.searchNode(a3);
			L.deleteSNode(b);
			L.printList();
			
			break;
		//마지막 노드 삭제
		case 6:
			L.deleteLastNode();
			L.printList();
			break;
		//리스트 출력
		case 7:
			L.printList();
			break;
		//끝내기
		case 8:
			break;
		}
	}
}
class LinkedList{
	   private ListNode head;
	   public LinkedList() {
	      head = null;
	   }

	public void deleteSNode(ListNode rev) { //수
	      ListNode pre, temp;
	      if(head == null) {
	         return;
	      }else if(head==rev) {
	         head=head.link;
	      }else {
	         if(head.link !=null) {
	            pre=head;
	            temp = head.link;
	            while(temp != rev) {
	               pre = temp;
	               temp = temp.link;
	            }
	            pre.link = temp.link;
	         }
	      }
	      
	   }
	
	
	   public void deleteFirstNode() {
	   ListNode newNode = new ListNode();
	      if(head==null) {
	      }else {
	         head = head.link;
	      }
	      }

	   public void insertMiddleNode(ListNode pre, String data) { 
	      ListNode newNode = new ListNode(data);
	      
	      if(newNode==null) {
	         newNode=head;
	      }else {
	         newNode.link = pre.link; //금
	         pre.link = newNode;
	      }
	   }
	   
	   public  ListNode searchNode(String data) {
	       ListNode temp = this.head;
	         while (temp != null) {
	            if (data.equals(temp.getData()))
	               return temp;
	            else
	               temp = temp.link;
	         }
	         return temp;
	   }

	   public void insertFirstNode(String data) {
	      ListNode newNode = new ListNode(data);
	      if(head==null) {
	         this.head = newNode;
	      }else{
	         ListNode temp = head;
	         while(temp.link != null)
	         {
	            temp = temp.link;
	         }
	            temp.link = newNode;
	      }
	   }
	   public void deleteLastNode() {
	      ListNode pre, temp;
	      if(head == null) return;
	      if(head.link == null) {
	         head = null;
	      }else {
	         pre = head;
	         temp=head.link;
	         while(temp.link != null) {
	            pre = temp;
	            temp = temp.link;
	         }
	         pre.link = null;
	      }
	   }
	   
	   public void printList() {
	      ListNode temp = this.head;
	      System.out.printf(" (");
	      while(temp != null) {
	         System.out.printf(temp.getData());
	         temp = temp.link;
	         if(temp != null) {
	            System.out.printf(", ");
	         }
	      }
	      System.out.println(")");
	   }
	}
	class ListNode{
	   String data;
	   public ListNode link;
	   public ListNode() {
	      this.data = null;
	      this.link = null;
	   }
	   public ListNode(String data) {
	      this.data = data;
	      this.link = null;
	   }
	   public ListNode(String data, ListNode link) {
	      this.data = data;
	      this.link = link;
	   }
	   public String getData() {
	      return this.data;
	   }
	}
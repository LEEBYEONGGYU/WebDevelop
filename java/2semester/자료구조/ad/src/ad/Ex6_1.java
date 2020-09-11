package ad;



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

   public void insertMiddleNode(ListNode pre, String data) { // pre는 수고 data는 금
      ListNode newNode = new ListNode(data); //newnode는 금이겠지? 결과는 수 다음에 금
      
      if(newNode==null) {
         newNode=head;
      }else {
         newNode.link = pre.link; //금이 
         pre.link = newNode;
      }
   }
   
   public  ListNode searchNode(String data) { //수
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


public class Ex6_1 {

   public static void main(String[] args) {
   LinkedList L = new LinkedList();
   System.out.println("(1) 첫번째 노드에 삽입하기");
   L.insertFirstNode("월");
   L.insertFirstNode("수");
   L.insertFirstNode("일");
   L.printList();
   


   System.out.println("(2) 찾아서 다음 노드에 삽입");   
   ListNode pre2 = L.searchNode("월");
   if(pre2 == null)
      System.out.println("검색실패>>찾는 데이터가 없습니다.");
   else {
      L.insertMiddleNode(pre2,"금");
      L.printList();
   }
   
   
   System.out.println("(3) 마지막 노드에 삽입하기");
   ListNode pre = L.searchNode("금");
   if(pre == null)
      System.out.println("검색실패>>찾는 데이터가 없습니다.");
   else {
      L.insertMiddleNode(pre,"일");
      L.printList();
   }
   
System.out.println("(4) 첫 번째 노드삭제");
L.deleteFirstNode();
L.printList();


System.out.println("(5) 찾은 노드 삭제 ");
ListNode b = L.searchNode("일");
L.deleteSNode(b);
L.printList();


System.out.println("(6) 마지막 노드 삭제");
L.deleteLastNode();
L.printList();
   }

}
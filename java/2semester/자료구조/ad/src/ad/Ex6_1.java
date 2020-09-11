package ad;



class LinkedList{
   private ListNode head;
   public LinkedList() {
      head = null;
   }
   
   public void deleteSNode(ListNode rev) { //��
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

   public void insertMiddleNode(ListNode pre, String data) { // pre�� ���� data�� ��
      ListNode newNode = new ListNode(data); //newnode�� ���̰���? ����� �� ������ ��
      
      if(newNode==null) {
         newNode=head;
      }else {
         newNode.link = pre.link; //���� 
         pre.link = newNode;
      }
   }
   
   public  ListNode searchNode(String data) { //��
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
   System.out.println("(1) ù��° ��忡 �����ϱ�");
   L.insertFirstNode("��");
   L.insertFirstNode("��");
   L.insertFirstNode("��");
   L.printList();
   


   System.out.println("(2) ã�Ƽ� ���� ��忡 ����");   
   ListNode pre2 = L.searchNode("��");
   if(pre2 == null)
      System.out.println("�˻�����>>ã�� �����Ͱ� �����ϴ�.");
   else {
      L.insertMiddleNode(pre2,"��");
      L.printList();
   }
   
   
   System.out.println("(3) ������ ��忡 �����ϱ�");
   ListNode pre = L.searchNode("��");
   if(pre == null)
      System.out.println("�˻�����>>ã�� �����Ͱ� �����ϴ�.");
   else {
      L.insertMiddleNode(pre,"��");
      L.printList();
   }
   
System.out.println("(4) ù ��° ������");
L.deleteFirstNode();
L.printList();


System.out.println("(5) ã�� ��� ���� ");
ListNode b = L.searchNode("��");
L.deleteSNode(b);
L.printList();


System.out.println("(6) ������ ��� ����");
L.deleteLastNode();
L.printList();
   }

}
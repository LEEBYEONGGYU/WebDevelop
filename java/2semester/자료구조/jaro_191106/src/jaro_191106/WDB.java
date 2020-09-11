package jaro_191106;

class LinkedStack {

   private int tp[] = new int[100];
   private int ct = -1;
   
   public boolean isEmpty() {
      return (ct == -1);
   }

   public void puh(int item) {
	   tp[++ct] = item;
   }

   public int pop() {
      if (isEmpty()) {
         System.out.println("삭제 실패 링크 스택 비었음");
         return 0;
      }else {
         int item = tp[ct];
         ct--;
         return item;
      }
   }
}

class OptExp2 {
   private String exp;

   public int evalPostfix(String postfix) {
      LinkedStack S = new LinkedStack();
      exp = postfix;
      int opr1, opr2, value;
      char testCh;
      for (int i = 0; i < 7; i++) {
         testCh = exp.charAt(i);
         if (testCh != '+' && testCh != '-' && testCh != '*' && testCh != '/') {
            value = testCh - '0';
            S.puh(value);
         } else {
            opr2 = S.pop();
            opr1 = S.pop();
            switch (testCh) {
            case '+':
               S.puh(opr1 + opr2);
               break;
            case '-':
               S.puh(opr1 - opr2);
               break;
            case '*':
               S.puh(opr1 * opr2);
               break;
            case '/':
               S.puh(opr1 / opr2);
               break;

            }
         }
      }
      return S.pop();
   }
}

class WDB {

   public static void main(String[] args) {
      OptExp2 opt = new OptExp2();
      int result;
      String exp = "35*62/-";
      System.out.printf("\n후위식표기식 : %s", exp);
      result = opt.evalPostfix(exp);
      System.out.printf("\n 연산결과= %d\n", result);

   }
}
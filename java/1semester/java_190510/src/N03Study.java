class Test {
   private int gear;   // this.gear�� ���⸦ ����
   public int StringToInt(String s) {
      int result = 0;
      
      // 100~999 ��� ���ڰ� �ԷµǾ��� ��
      // Int�� ��ȯ�Ͽ� ��ȯ
      // ex: 123�� �ɰ��� 1*100 + 2*10 + 3*1
      // ParseInt�� �����ϰ� ��� ����
      
      // ù ��° ���ڸ� �����´�.
      char c = s.charAt(0);
      int i = c - '0';
      result = result + i * 100;
    //  System.out.printf("����3�� �ڵ� %d, ����2�� �ڵ� %d, %d \n", (int)c, (int)'0', i);
      
     
      
       c = s.charAt(1);
       i = c - '0';
       result = result + i * 10;
      
      c = s.charAt(2);
      i = c - '0';
      result = result + i * 1;
      
      System.out.println(result);
      return result;
   }
   
   public int getGear() {
      return gear;
   }
   public void setGear(int gear) {
      this.gear = gear;
      // this�� �ڱ� ��ü�� �ɹ�����
      // = gear�� ���尡���� ����� ������ �ڱ��
   }


   private int speed;   // �ʵ�, �ɹ�����
   // ������ Setter
   public void setSpeed(int data){
      speed = data;
   }
   // ������ Gatter
   public int getSpeed() {
      return speed;
   }
   
   
   public void testWrapper( ) {
      
      speed = 1;
      // private������ speed�� �����̱⿡ ��� ����.
      
      Integer obj = new Integer(127);   // 127����  ��� �ʰ��� �����÷ο� ������ Recycle
                              // �ʰ��� ������ ������ ���
      byte b = obj.byteValue();   // Byte ���·� ��ȯ
      System.out.println(b);
      
//      int a = 10;
//      b = (byte)a;
      
      // ������������ ���� Int ������ �����ϱ�
      // ParseInt�� ������ �ſ� �������� �̹� ��������ֱ⿡ ���� �ȴ�.
      String s = new String("123");
      int i = obj.parseInt(s);   // �׳�  s�� �����ϸ� ��� �Ұ���!

      i = Integer.parseInt(s);
      // obj�� ��ü, Integer�� Ŭ����
      System.out.println(i+7);   // ���������� ��ȯ!
             
      String s1 = obj.toBinaryString(127);   
      System.out.println(s1);   // 127�� 2������ ��ȯ�Ͽ� ���
      
      Double obj1 = new Double(10.1);
      s1 = obj1.toHexString(101.1);   // 16���� ���·� ��ȯ
      System.out.println(s1);
   }
}

public class N03Study {

   public static void main(String[] args) {
      // ���� ���� Ŭ������ ����ϱ� ���� ��ü ����
      Test t = new Test();   // ��ü ����
      // ������ ��ü�� �޼ҵ带 ȣ��
      t.testWrapper();
      // t.speed = 2;
    
      // �����ڸ� ���� ����
      // speed�� ���������ڰ� public�̱⿡ ��밡��.
      // ��, private�� ���ο����� �����ϹǷ� speed�� �ܺο� �־� ��� �Ұ���.
      
      // �ɹ������� ���������� �ٲ��� �ʰ�, �޼ҵ带 ���� �ٲٵ��� �Ѵ�.
      // �̰��� �����ڶ�� �ϰ�, �о���� ���� �����ڶ�� �Ѵ�.
      // ������ mutator
      // setXXX() ����
      
      // System.out.println(t.speed);
      // speed��� �ɹ������� private�̶� ���� �Ұ��Ͽ� ������ ���
   
      
      int i = t.StringToInt("abc");
      System.out.print(i);
    
      

   }

}
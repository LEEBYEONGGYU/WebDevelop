class Test {
   private int gear;   // this.gear가 여기를 참조
   public int StringToInt(String s) {
      int result = 0;
      
      // 100~999 라는 문자가 입력되었을 때
      // Int로 변환하여 반환
      // ex: 123을 쪼개서 1*100 + 2*10 + 3*1
      // ParseInt를 제외하고 사용 가능
      
      // 첫 번째 문자를 가져온다.
      char c = s.charAt(0);
      int i = c - '0';
      result = result + i * 100;
    //  System.out.printf("문자3의 코드 %d, 문자2의 코드 %d, %d \n", (int)c, (int)'0', i);
      
     
      
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
      // this는 자기 객체인 맴버변수
      // = gear는 가장가까이 선언된 변수가 자기것
   }


   private int speed;   // 필드, 맴버변수
   // 설정자 Setter
   public void setSpeed(int data){
      speed = data;
   }
   // 접근자 Gatter
   public int getSpeed() {
      return speed;
   }
   
   
   public void testWrapper( ) {
      
      speed = 1;
      // private에서도 speed의 내부이기에 사용 가능.
      
      Integer obj = new Integer(127);   // 127까지  양수 초과시 오버플로우 음수로 Recycle
                              // 초과시 무조건 오류로 취급
      byte b = obj.byteValue();   // Byte 형태로 변환
      System.out.println(b);
      
//      int a = 10;
//      b = (byte)a;
      
      // 문자형이지만 실제 Int 값으로 변경하기
      // ParseInt가 없으면 매우 힘들지만 이미 만들어져있기에 쓰면 된다.
      String s = new String("123");
      int i = obj.parseInt(s);   // 그냥  s만 대입하면 사용 불가능!

      i = Integer.parseInt(s);
      // obj는 객체, Integer는 클래스
      System.out.println(i+7);   // 성공적으로 변환!
             
      String s1 = obj.toBinaryString(127);   
      System.out.println(s1);   // 127을 2진수로 변환하여 출력
      
      Double obj1 = new Double(10.1);
      s1 = obj1.toHexString(101.1);   // 16진수 형태로 변환
      System.out.println(s1);
   }
}

public class N03Study {

   public static void main(String[] args) {
      // 내가 만든 클래스를 사용하기 위한 객체 생성
      Test t = new Test();   // 객체 생성
      // 생성된 객체의 메소드를 호출
      t.testWrapper();
      // t.speed = 2;
    
      // 설정자를 통한 변경
      // speed의 접근지정자가 public이기에 사용가능.
      // 단, private는 내부에서만 가능하므로 speed가 외부에 있어 사용 불가능.
      
      // 맴버변수를 직접적으로 바꾸지 않고, 메소드를 통해 바꾸도록 한다.
      // 이것을 설정자라고 하고, 읽어오는 것은 접근자라고 한다.
      // 설정자 mutator
      // setXXX() 형식
      
      // System.out.println(t.speed);
      // speed라는 맴버변수가 private이라 접근 불가하여 접근자 사용
   
      
      int i = t.StringToInt("abc");
      System.out.print(i);
    
      

   }

}
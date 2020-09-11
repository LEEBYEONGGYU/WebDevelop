class StringTest {
	void test() {
		String a = "영진";
		String b = "전문대학교";
		String c = a+b;
		System.out.println(c);
	}
	
	void test1() {
		String a = "영진";
		int b = 1977;
		String c = a+b;
		System.out.println(c);
	}
	
	void test2() {
		String a = "영진";
		String b = "전문대학교";
		//int b = 1977;
		String c = a.concat(b);
		String d = c.replace('대', '-');
		d = c.substring(4,7);
		System.out.println(d);
	}
	
	void test3() {
		String a = "영진전문대학교";
		String b = "컴퓨터정보계열";
		int i = a.compareTo(b);
		if(i==0) {
			System.out.println(a+"와" + b + "는  동일합니다.");
		//}else if(i){
			System.out.println("rrrr");
		}
		System.out.println(i);
	}
	
}

public class Project_190508 {
	 public static void main(String[] args) {
	// 1. 해당 객체를 생성하려는 클래스의 객체 변수를 생성한다
	StringTest a;
	a = new StringTest(); //개체를 생선하고 변수에 대입
	a.test3();
	//
}
}

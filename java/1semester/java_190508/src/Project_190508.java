class StringTest {
	void test() {
		String a = "����";
		String b = "�������б�";
		String c = a+b;
		System.out.println(c);
	}
	
	void test1() {
		String a = "����";
		int b = 1977;
		String c = a+b;
		System.out.println(c);
	}
	
	void test2() {
		String a = "����";
		String b = "�������б�";
		//int b = 1977;
		String c = a.concat(b);
		String d = c.replace('��', '-');
		d = c.substring(4,7);
		System.out.println(d);
	}
	
	void test3() {
		String a = "�����������б�";
		String b = "��ǻ�������迭";
		int i = a.compareTo(b);
		if(i==0) {
			System.out.println(a+"��" + b + "��  �����մϴ�.");
		//}else if(i){
			System.out.println("rrrr");
		}
		System.out.println(i);
	}
	
}

public class Project_190508 {
	 public static void main(String[] args) {
	// 1. �ش� ��ü�� �����Ϸ��� Ŭ������ ��ü ������ �����Ѵ�
	StringTest a;
	a = new StringTest(); //��ü�� �����ϰ� ������ ����
	a.test3();
	//
}
}

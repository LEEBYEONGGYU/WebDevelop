class Car3 {
	String color;
	int id;
	static int numberOfcars = 0;
	
	//������
	public Car3(String c) {
		color = c;
		id = ++numberOfcars;
	}
	//Į��� id�� ������ִ� �޼ҵ�
	public void print() {
		System.out.println(this.color + this.id);
	}
	
	//���� ������ ��ü�� ���� �� ȯ�ϴ� �޼ҵ�
	public int getNumbers() {
		return this.numberOfcars;
	}
}
public class p190529 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car3 c1 = new Car3("Red");
		Car3 c2 = new Car3("Blue");
		c1.print();
		c2.print();
		
		int n = c1.getNumbers();
		System.out.println(n);
	}

}

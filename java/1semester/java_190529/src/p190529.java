class Car3 {
	String color;
	int id;
	static int numberOfcars = 0;
	
	//생성자
	public Car3(String c) {
		color = c;
		id = ++numberOfcars;
	}
	//칼라와 id를 출력해주는 메소드
	public void print() {
		System.out.println(this.color + this.id);
	}
	
	//현재 생성된 객체의 수르 반 환하는 메소드
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

package p190612;
class ParentClass{
	int data=100;
	public void print() {
		System.out.println("수퍼 클래스의 print() 메소드");
	}
}

	public class ChildClass extends ParentClass {
		int data=200;
		public void print() {
			super.print();
			System.out.println("서브클래스의 ");
			System.out.println(this.data);
			System.out.println(super.data);
		}

	
	public static void main(String[] args) {
		ChildClass obj = new ChildClass();
		obj.print();
	}
}
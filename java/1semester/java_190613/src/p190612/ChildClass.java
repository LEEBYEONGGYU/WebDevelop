package p190612;
class ParentClass{
	int data=100;
	public void print() {
		System.out.println("���� Ŭ������ print() �޼ҵ�");
	}
}

	public class ChildClass extends ParentClass {
		int data=200;
		public void print() {
			super.print();
			System.out.println("����Ŭ������ ");
			System.out.println(this.data);
			System.out.println(super.data);
		}

	
	public static void main(String[] args) {
		ChildClass obj = new ChildClass();
		obj.print();
	}
}
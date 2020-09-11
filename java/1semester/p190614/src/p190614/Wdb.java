package p190614;

/*
interface RemoteControl {
	public void turnon();
	public void turnoff();
}

class television implements RemoteControl {

	@Override
	public void turnon() {
		System.out.println("텔레비전 켜");
		
	}

	@Override
	public void turnoff() {
		System.out.println("티비 꺼라");
		
	}
	
	public void print() {
		System.out.println("dfdfdf");
	}
	
}
public class Wdb {
	public static void main(String[] args) {
		television t = new television();
		t.turnon();
		t.print();
		//자식객체는 부모 객체변수에 저장이 가능하지만 부모 객체변수에 저장되어 있을 때는 부모에서 정의된 메서드만 사용할 수 있다
		// 부모 객체벼수에 저장되어 있을 때는 자식 ㄱㄱ체에서 정의된 메소드는 사용할 수 없다
		RemoteControl x = new television();
		x.turnoff();
		//x.print();
		
		television y = (television)x; //강제 형변환
		y.print();
		
		String s = new String("홍길동");
	}

}
*/

public class Wdb{
	public static void main(String[] args) {
		Shape s;
		Rectangle r = new Rectangle();
		Circle c = new Circle();
		Triangle t = new Triangle();
		
		r.draw();
		c.draw();
		t.draw();
		
		s=r;
		s.draw();
		
		r = (Rectangle)s;
		
		Shape[] ss = new Shape[3];
		ss[0] = r;
		ss[1] = c;
		ss[2] = t;
		
		for(int i=0; i<3; i++) {
			System.out.println(ss[i].getClass().getName());
			ss[i].draw();
			
			if(ss[i] instanceof Rectangle) {
				System.out.println(ss[i].getClass().getName());
				ss[i].draw();
			}
		}
	}
}
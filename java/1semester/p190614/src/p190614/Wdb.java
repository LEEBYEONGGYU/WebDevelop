package p190614;

/*
interface RemoteControl {
	public void turnon();
	public void turnoff();
}

class television implements RemoteControl {

	@Override
	public void turnon() {
		System.out.println("�ڷ����� ��");
		
	}

	@Override
	public void turnoff() {
		System.out.println("Ƽ�� ����");
		
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
		//�ڽİ�ü�� �θ� ��ü������ ������ ���������� �θ� ��ü������ ����Ǿ� ���� ���� �θ𿡼� ���ǵ� �޼��常 ����� �� �ִ�
		// �θ� ��ü������ ����Ǿ� ���� ���� �ڽ� ����ü���� ���ǵ� �޼ҵ�� ����� �� ����
		RemoteControl x = new television();
		x.turnoff();
		//x.print();
		
		television y = (television)x; //���� ����ȯ
		y.print();
		
		String s = new String("ȫ�浿");
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
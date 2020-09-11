

public class WDB {

	//���ñ����� �Һ� ��
	public static void main(String[] args) {
		Buffer buffer = new Buffer(); //������ ������ ����
		Producer p = new Producer(buffer);
		Consumer c = new Consumer(buffer);
		Thread p1 = new Thread(p);
		Thread c1 = new Thread(c);
		p1.start();
		c1.start();
	}

}

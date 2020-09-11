


class Counter{
	int value = 0;
	synchronized public void increment() {
		value++;
	}
	synchronized public void decrement() {
		value--;
	}
	 public void print() {
		System.out.println(value);
	}
}

class MyThread extends Thread {
	Counter c;
	public MyThread(Counter input) {
		this.c = input;
	}
	public void run() {
		super.run();
		for(int i=0; i<10000; i++) {
			c.increment();
			c.decrement();
			if(i%40==0) {
				c.print();
			}
			try {
				Thread.sleep((long) (Math.random()*3));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}


public class WDB {

	public static void main(String[] args) {
		//�����ڿ��� ��ü�� �����Ѵ�
		Counter c = new Counter();
		MyThread t1 = new MyThread(c);
		MyThread t2 = new MyThread(c);
		t1.start();
		t2.start();
	}

}

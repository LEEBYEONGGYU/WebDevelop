

//��. thread�� ��ӹ޾� Ŭ������ �����ϴ� ���
//1. Thread�� ���� ��ӹ޴� ���ο� Ŭ������ �ϳ� �����
//2. run�̶�� �޼ҵ带 �������̵��ؼ� ������ �� (run �޼ҵ� �ȿ� ���� �ۼ��� 1���� 100������ ���� ���ϴ� �ڵ带 �ۼ��Ѵ�)

class MyThread extends Thread {
	String name;
	
	public MyThread(String s) {
		this.name = s;
	}
	@Override
	public void run() {
		
		super.run();
		
		int sum=0;
		for(int i=0; i<9999999; i++) {
			sum=sum+(i+1);
			System.out.printf("%s 1���� %d ������ ����%d\n",name,i,sum);
		}
	}
	
}


//��. threadŬ������ ��ӹ޾� ũ������ �����ϴ� ���
//��. runnable�������̽��� ��ӹ޾� Ŭ������ �����ϴ� ���
//1. runnable �������̽��� ��ӹ޾� ���ο� Ŭ������ �����Ѵ�
//2 run �޼ҵ带 ������ �Ѵ�.

class MyRunnable implements Runnable {
	String name;
	public  MyRunnable(String s) {
		this.name = s;
	}
	@Override
	public void run() {
		int sum=0;
		for(int i=0; i<99999999; i++) {
			sum=sum+(i+1);
			try {
				Thread.sleep(30); //����������� 30�и������� 0.03�ʵ��� ������Ŵ
			}catch (InterruptedException e){
				e.printStackTrace();
			}
			System.out.printf("%s 1���� %d ������ ����%d\n",name,i,sum);
		}
		
	}
	
}
public class WDB {

	public static void main(String[] args) {
		//��. threadŬ������ ��ӹ޾� Ŭ������ �����ϴ� ���
		// �ش� Ŭ������ ��ü�� ������, �� ��ü��  start�޼ҵ带 ȣ���Ѵ�
		
//		MyThread myThread = new MyThread("A");
//		myThread.start();
//		
//		MyThread myThread1 = new MyThread("B");
//		myThread1.start();
		
		//��. Runnable �������̽��� ��ӹ޾� Ŭ������ �����ϴ� ���
		//�ش�Ŭ������ ��ü�� �����ϰ�, �� ��ü�� thread ��ü�� �����Ҷ� �μ��� �����ϰ� thread��ü�� start�޼ҵ带 ȣ���Ѵ�
		MyRunnable Myrunnable= new MyRunnable("C");
		Thread thread = new Thread(Myrunnable);
		thread.start();
		
		MyRunnable Myrunnable2= new MyRunnable("D");
		Thread thread2 = new Thread(Myrunnable2);
		thread2.start();
		
		Runnable Myrunnable3= new MyRunnable("E");
		Thread thread3 = new Thread(Myrunnable3);
		thread3.start();
	}

}

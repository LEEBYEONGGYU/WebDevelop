

public class Buffer {
	//���ۿ� ������ 3������ ������ �� �ִٸ� ��� �ٲ�
	private int data[] = new int[3];
	//boolean empty = true;
	int current = 0;
	
	//�Һ��ڰ� ȣ���ϴ� �޼ҵ�, ���۰� ������ wait�Ѵ�
	public synchronized int get() {
		while(current==0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//�����ڰ� wait�� �� �����Ƿ� ��������
		current--;
		System.out.println("�Һ���: "+data[current]+"��° ���� �Һ�");
		notifyAll();
		return data[current];
	}
	
	//�����ڰ� ȣ���ϴ� �޼ҵ� ���۰� �� ������ wait�Ѵ�
	public synchronized void put(int a) {
		while(current==3) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.data[current]=a;
		current+=1;
		System.out.println("������: "+a+"��° ����");
		notifyAll();
	}

}

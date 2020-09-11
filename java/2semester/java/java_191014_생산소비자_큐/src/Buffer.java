
import java.util.LinkedList;
import java.util.Queue;

public class Buffer {
	//���ۿ� ������ 3������ ������ �� �ִٸ� ��� �ٲ�
	//private int data[] = new int[3];
	//boolean empty = true;
	int current = 0;
	Queue<Integer> q= new LinkedList<Integer>();
	
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
		notifyAll();
		int data=q.remove();
		System.out.println("�Һ���: "+data+"���� �Һ�");
		return data;
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
		
		q.add(a);
		current+=1;
		System.out.println("������: "+a+"���� ���� ����");
		notifyAll();
	}

}

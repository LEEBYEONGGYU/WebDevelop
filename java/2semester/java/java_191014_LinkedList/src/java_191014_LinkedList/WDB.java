package java_191014_LinkedList;

import java.util.LinkedList;
import java.util.Queue;

public class WDB {

	public static void main(String[] args) {
		LinkedList<Integer> a = new LinkedList<Integer>();
		for(int i=0; i<10; i++) {
			a.add(i);
		}
		//5��° ���ҿ� 10�̶�� ���� �߰��Ϸ��� ����
		a.add(5,10);
		for(Integer I:a) {
			System.out.println(I);
		}
		System.out.println("--------------------");
		a.addFirst(100);
		for(Integer I:a) {
			System.out.println(I);
		}
		System.out.println("ù��° ���Ұ� ����");
		int data=a.remove(1);
		System.out.println(data);
		System.out.println("--------------------");
		for(Integer I:a) {
			System.out.println(I);
		}
		
		System.out.println("LinkedList��");
		
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i=0; i<4; i++) {
			q.add(i);
		}
		System.out.println("------------------");
		System.out.println("ť����");
		for(int i=0; i<4; i++) {
			//q.remove(i);
			System.out.println(q.remove());
		}
	}

}

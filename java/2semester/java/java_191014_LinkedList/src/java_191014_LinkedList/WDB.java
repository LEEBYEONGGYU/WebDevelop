package java_191014_LinkedList;

import java.util.LinkedList;
import java.util.Queue;

public class WDB {

	public static void main(String[] args) {
		LinkedList<Integer> a = new LinkedList<Integer>();
		for(int i=0; i<10; i++) {
			a.add(i);
		}
		//5번째 원소에 10이라는 값을 추가하려고 ㅏㅁ
		a.add(5,10);
		for(Integer I:a) {
			System.out.println(I);
		}
		System.out.println("--------------------");
		a.addFirst(100);
		for(Integer I:a) {
			System.out.println(I);
		}
		System.out.println("첫번째 원소값 제거");
		int data=a.remove(1);
		System.out.println(data);
		System.out.println("--------------------");
		for(Integer I:a) {
			System.out.println(I);
		}
		
		System.out.println("LinkedList끝");
		
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i=0; i<4; i++) {
			q.add(i);
		}
		System.out.println("------------------");
		System.out.println("큐시작");
		for(int i=0; i<4; i++) {
			//q.remove(i);
			System.out.println(q.remove());
		}
	}

}

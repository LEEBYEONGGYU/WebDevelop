package p190617;

import java.util.ArrayList;
import java.util.Iterator;
public class p190617 {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("����");
		list.add("��");
		list.add("����");
		
		for(int i=0; i<list.size(); i++) {
			
		
		System.out.println(list.get(i));
		}
		System.out.println("�߰�����");
		list.add(1, "���");
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("�� ����");
		list.remove(2);
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("��������");
		list.set(0,"�������");
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println(list.indexOf("���"));
		list.add("���");
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println(list.indexOf("���"));
		Iterator e = list.iterator();
		while(e.hasNext()) {
			String a = (String) e.next();
			System.out.println(a);
		}
	}

}

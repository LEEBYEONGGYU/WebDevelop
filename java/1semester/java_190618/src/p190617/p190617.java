package p190617;

import java.util.ArrayList;
import java.util.Iterator;
public class p190617 {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("우유");
		list.add("빵");
		list.add("버터");
		
		for(int i=0; i<list.size(); i++) {
			
		
		System.out.println(list.get(i));
		}
		System.out.println("중간삽입");
		list.add(1, "사과");
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("빵 삭제");
		list.remove(2);
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("우유수정");
		list.set(0,"서울우유");
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println(list.indexOf("사과"));
		list.add("사과");
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println(list.indexOf("사과"));
		Iterator e = list.iterator();
		while(e.hasNext()) {
			String a = (String) e.next();
			System.out.println(a);
		}
	}

}

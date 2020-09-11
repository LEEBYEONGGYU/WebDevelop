package p190709;
import java.util.Arrays;
public class project190709 {
	public static void main(String[] args) {
		
		/*
		//문자배열을 생성하여 배열의 원소에 자신의 이름 글자를 저장
		//배열의 각 원소를 출력
		//문자열(String) 객체에 배열의 역순으로 저장
		//문자열을 출력
		
		char [] array = new char[3];
		
		//배열원소에 이름 저장
		array[0] = '이';
		array[1] = '병';
		array[2] = '규';
		
		//배열의 각 원소 출력
		for(int i=0; i<3; i++) {
			System.out.println(array[i]);
		}
		
		//문자열 객체에 역순으로 저장
		String a = new String();
		System.out.println();
		
		a = array[2]+""+array[1]+""+array[0]+"";
		System.out.println(a);
	
		Arrays.sort(array);
		char[] s = array;
		System.out.println(s);
		
		//역순저장 확인
		System.out.println("sort역순저장 확인");
		System.out.println(array[0]);
		System.out.println(array[1]);
		System.out.println(array[2]);
		*/
		
		/*
		//배열 '영진전문대학교 computer
		char[] a = new char[28];
		
		//문자열로 저장
		String b = "영진전문대학교 Computer information";
		//문자열을 이용하여 배열의 원소를 역순으로 저장해라
		for(int i=0; i<b.length(); i++) {
			int j=27;
				//a[0] = b.charAt(27);
				//a[1] = b.charAt(26);
				a[i] = b.charAt(j-i);
		}
		System.out.println(a);
		*/
		
		//String 배열 만듬
		String[] arr = new String[28];
		
		//0번째 원소에 초기 문자열을 대입
		arr[0] = "영진전문대학교 computer information";
		
		for(int i=1; i<=arr.length; i++) {
			//1번째은 "진전문"
			arr[i] = arr[0].substring(i)+arr[0].substring(0, i);
			System.out.println(arr[i]);
		
		
		
	}
}
}
package p190709;
import java.util.Arrays;
public class project190709 {
	public static void main(String[] args) {
		
		/*
		//���ڹ迭�� �����Ͽ� �迭�� ���ҿ� �ڽ��� �̸� ���ڸ� ����
		//�迭�� �� ���Ҹ� ���
		//���ڿ�(String) ��ü�� �迭�� �������� ����
		//���ڿ��� ���
		
		char [] array = new char[3];
		
		//�迭���ҿ� �̸� ����
		array[0] = '��';
		array[1] = '��';
		array[2] = '��';
		
		//�迭�� �� ���� ���
		for(int i=0; i<3; i++) {
			System.out.println(array[i]);
		}
		
		//���ڿ� ��ü�� �������� ����
		String a = new String();
		System.out.println();
		
		a = array[2]+""+array[1]+""+array[0]+"";
		System.out.println(a);
	
		Arrays.sort(array);
		char[] s = array;
		System.out.println(s);
		
		//�������� Ȯ��
		System.out.println("sort�������� Ȯ��");
		System.out.println(array[0]);
		System.out.println(array[1]);
		System.out.println(array[2]);
		*/
		
		/*
		//�迭 '�����������б� computer
		char[] a = new char[28];
		
		//���ڿ��� ����
		String b = "�����������б� Computer information";
		//���ڿ��� �̿��Ͽ� �迭�� ���Ҹ� �������� �����ض�
		for(int i=0; i<b.length(); i++) {
			int j=27;
				//a[0] = b.charAt(27);
				//a[1] = b.charAt(26);
				a[i] = b.charAt(j-i);
		}
		System.out.println(a);
		*/
		
		//String �迭 ����
		String[] arr = new String[28];
		
		//0��° ���ҿ� �ʱ� ���ڿ��� ����
		arr[0] = "�����������б� computer information";
		
		for(int i=1; i<=arr.length; i++) {
			//1��°�� "������"
			arr[i] = arr[0].substring(i)+arr[0].substring(0, i);
			System.out.println(arr[i]);
		
		
		
	}
}
}
package p190708;
import java.util.Scanner;
public class project190708 {

	public static void main(String[] args) {
/*
		int num=0, i=0, j=0;
		System.out.println("���� ��");
		Scanner sc = new Scanner(System.in);
		j = sc.nextInt(); //j�� �Է��Ѱ�
		

		for(i=2; i<=9; i++) {
			for(j=1; j<=9; j++) {	
				//System.out.print("2*" + (i+1) + "=" +2*(i+1)+" ");
				//System.out.println("3*" + (i+1) + "=" +3*(i+1));
			
				System.out.print(i+"*"+j+"="+j*i+"  ");
				System.out.println(i+1+"*"+j+"="+j*i);
	}
			System.out.println();
}*/
		
		/*
		//�迭 10���� ���ڸ� �����ϰ� �����Ͽ� �迭�� �����ϰ�
		//�迭�� ��� �� �� �հ�� �����  ����϶�
		
		int [] array;
		array = new int[10];
		
		
		int hap=0;
		double avg=0;
		
		for(int i=0; i<10; i++) {
			array[i] =  (int) ((Math.random()*1000)+1);
			
			System.out.println("�� �迭�� ������ "+array[i]);
			 hap = hap+array[i];
			 avg = hap/10;
		}
		
		System.out.println();
		System.out.println("�迭�� �հ�� "+hap);
		System.out.println("�迭�� ����� "+(double)hap/10);
		*/
		
		//100���� ���Ҹ� �迭�� �Ǻ���ġ �������� ��������
		//1 1 2 3 5 8 13 21 ...
		
		//1 �Ǻ���ġ ���� �� ����
		int [] fibo = new int[45];
		long hap=0; double avg=0;
		
		fibo[0] = 1;
		fibo[1] = 1;
		for(int i = 0; i<43; i++) {
			fibo[i+2] = fibo[i]+fibo[i+1];
		}
		//�迭�� �� ���� ���
		for(int i=0; i<45; i++) {
			System.out.println(i+ ":"+fibo[i]);
			
			hap = hap+fibo[i];
			avg = hap/fibo.length;
		}
		
		//�迭 ��
		System.out.println();
		System.out.println("�迭�� �հ�� "+hap);
		System.out.println("�迭�� ����� "+avg);
		
}
}
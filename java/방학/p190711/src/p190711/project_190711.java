package p190711;

import java.util.Random;

public class project_190711 {

	static class Student {
		public String name;
		char ����;
		int ����;

		public int kor;
		public int eng;
		public int math;

		public void print����() {
			System.out.print(kor + " ");
			System.out.print(eng + " ");
			System.out.print(math + " ");
		}

		public int sum;
		public double avg;

		public void �հ�() {
			sum = kor + eng + math;
			System.out.print("�հ� " + sum + " ");

		}

		public void ���() {
			avg = sum / 3.0;
			System.out.printf("%6.2f \n", avg);
		}
	}

	public static void main(String[] args) {
		Random random = new Random();
		// Student ��ü 100���� ������ �迭 ����
		Student[] array = new Student[100];
		// �����ʱ�ȭ
		int kavg = 0, eavg = 0, mavg = 0;

		// 2�迭�� ��ü�� ������
		for (int i = 0; i < 100; i++) {
			Student object = new Student();
			array[i] = object;
			
			object.name="�̺���"+i+" ";// �̸����ٰ� +i
			int age = random.nextInt(2);

			switch (age) {
			case 0:
				object.���� = '��';
				break;
			case 1:
				object.���� = '��';
				break;
			}
			
			object.���� = random.nextInt(31)+20;
			System.out.print(object.name + object.���� + " " + object.���� +"\n");
			
		}
	}
}



/*
 * //2.1 student��ü�� ���� ���� ���� ���� �Է� 
 * 
 * object.name="�̺���"+i+" ";//�̸����ٰ� +i
 * object.kor= random.nextInt(101);
 *  object.eng= random.nextInt(101);;
 * object.math= random.nextInt(101);
 * 
 * //student��ü �迭 ���� 
 * //��ձ��ϴ� ģ����
 *  kavg = kavg+array[i].kor; eavg = eavg+array[i].eng; mavg =
 * mavg+array[i].math; } 
 * 
 * for(int j=0; j<array.length; j++) { array[j].�̸�();
 * array[j].print����();
 *  array[j].�հ�(); array[j].���();
 * 
 * }
 * System.out.println("������� "+kavg/100.0+" ������� "+eavg/100.0+" ������� "+mavg/100.0
 * );
 */

// �̸� : ȫ�浿 0~99 ���� : random���� 0�� 1 ���̴� 20~50

 

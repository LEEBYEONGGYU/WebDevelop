package p190710;

public class project190710 {

	public static void main(String[] args) {
		
		/*
		//2���� �迭 ���� �׸��� �ʱⰪ ����
		int [][] array = new int[3][5];
		int t=0;
		int sum=0;
		int summ=0;
		
		//2���� �ʱⰪ ����
		for(int i=0; i<3; i++) {
			for(int j=0; j<5; j++) {
				array[i][j]=t++;
			}
		}
		
		//�迭��� �� �����հ�
		for(int i=0; i<3; i++) {
			sum=0;
			for(int j=0; j<5; j++) {
				
				System.out.printf("%2d ",array[i][j]);
				sum = sum+array[i][j];
			}
			System.out.printf("%2d ",sum);
			System.out.println("");
		}
		
		//���� �հ�
		for(int i=0; i<5; i++) {
			sum=0;
			for(int j=0; j<3; j++) {
				sum = sum+array[j][i];
			}
			System.out.printf("%2d ",sum);
		}
		System.out.println("");
		*/
		
		//1. String�� ���� " �� ���� �����б���ǻ���� ���� ��";
		//2. 6�� 3�� ¥�� ���� �迭 ����q 
		//3. �迭�� �� ���ҿ� ���� ����
		//4. �迭�� ����Ͽ� 
		/* 
		 �� ��
		 �� ��
		 ���б�
		 ��ǻ��
		 �� ��
		 �� ��
		 */
		
		String arr = "�� ���� �����б���ǻ���� ���� ��";
		
		char[][] carr = new char[6][3];
		for(int i=0; i<6; i++) {
			for(int j=0; j<3; j++) {
				carr[i][j] = arr.charAt(3*(5-i)+j);
				System.out.print(carr[i][j]);
			}
			System.out.println("");
		}
	}

}

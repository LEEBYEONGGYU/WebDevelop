import java.util.Scanner;

public class Twoarray {

	public static void main(String[] args) {
		

		/*
	
		//4���� �л��� ����, ����, ���� ������ 2���� �迭�� �����ϰ� ������ ����� �������
		//���� ���� 2���� �迭 ��ü ������ �����մϴ�. 
		int arrayA[][];
		//�迭 ��ü�� ����
		arrayA = new int [4][3]; //4�� 3��¥�� �迭(�� 12���� ������ ����)
		// �迭�� ���� ����
		int i,j;
		for(i=0; i<4; i++) {
			for(j=0; j<3; j++) {
				arrayA[i][j] = 3*i+j+1;
			}
		}
		//��� 
		int sum = 0;
		// �� ���� �հ踦 ������ �迭�� �����սô�!!!
		int [] sumA = new int [3]; //new�� ����ϸ� ���� 0���� �ʱ�ȭ�ȴ�
		
		for(i=0; i<3; i++) {
			sumA[i] = 0;
			
		}
		
		for(i=0; i<4; i++) {
			for(j=0; j<3; j++) {
				System.out.printf("%4d", arrayA[i][j]);
				sum = sum + arrayA[i][j];
				sumA[j] = sumA[j]+arrayA[i][j];
			}
			//���κ� ��� ������ ���;� �Ѵ�
			System.out.printf("%6.1f", sum/3.0);  //6�ڸ��� �Ҽ��� 1�ڸ��� ������
			System.out.println();
		}
		
		for(i=0; i<3; i++) {
			System.out.printf("%4.1f",sumA[i]/4.0);
		}
		}*/
		
		int i, j, n;
		Scanner input = new Scanner(System.in);
		System.out.printf("\n���ڸ� �Է��ϼ���");
		n = input.nextInt();
		
		//������ �迭 ����
		char[][] arr = new char[n][n];
		
		//�� �Է�
		for(i=0; i<n; i++) {
			for(j=0; j<n; j++) {
				if(i==0 || j==0 || j==n || i==n/2) {
					arr[i][j] = '*';
		  		}else {
		  			arr[i][j] = ' ';
		  		}
				
			}
		}
		
		//���
		for(i=0; i<n; i++) {
			System.out.print(i+":");
			for(j=0; j<n; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println(" ");
		}
	}

}
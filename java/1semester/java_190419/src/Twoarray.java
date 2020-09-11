import java.util.Scanner;

public class Twoarray {

	public static void main(String[] args) {
		

		/*
	
		//4명의 학생의 국어, 영어, 수학 점수를 2차원 배열에 저장하고 각각의 평균을 출력하자
		//가장 먼저 2차원 배열 객체 변수를 선언합니다. 
		int arrayA[][];
		//배열 객체를 생성
		arrayA = new int [4][3]; //4행 3열짜리 배열(총 12개의 정수형 변수)
		// 배열의 값을 저장
		int i,j;
		for(i=0; i<4; i++) {
			for(j=0; j<3; j++) {
				arrayA[i][j] = 3*i+j+1;
			}
		}
		//출력 
		int sum = 0;
		// 각 과목별 합계를 저장할 배열을 생성합시다!!!
		int [] sumA = new int [3]; //new를 사용하면 값이 0으로 초기화된다
		
		for(i=0; i<3; i++) {
			sumA[i] = 0;
			
		}
		
		for(i=0; i<4; i++) {
			for(j=0; j<3; j++) {
				System.out.printf("%4d", arrayA[i][j]);
				sum = sum + arrayA[i][j];
				sumA[j] = sumA[j]+arrayA[i][j];
			}
			//개인별 평균 점수가 나와야 한다
			System.out.printf("%6.1f", sum/3.0);  //6자리중 소수점 1자리만 보여라
			System.out.println();
		}
		
		for(i=0; i<3; i++) {
			System.out.printf("%4.1f",sumA[i]/4.0);
		}
		}*/
		
		int i, j, n;
		Scanner input = new Scanner(System.in);
		System.out.printf("\n숫자를 입력하세요");
		n = input.nextInt();
		
		//이차원 배열 생성
		char[][] arr = new char[n][n];
		
		//값 입력
		for(i=0; i<n; i++) {
			for(j=0; j<n; j++) {
				if(i==0 || j==0 || j==n || i==n/2) {
					arr[i][j] = '*';
		  		}else {
		  			arr[i][j] = ' ';
		  		}
				
			}
		}
		
		//출력
		for(i=0; i<n; i++) {
			System.out.print(i+":");
			for(j=0; j<n; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println(" ");
		}
	}

}
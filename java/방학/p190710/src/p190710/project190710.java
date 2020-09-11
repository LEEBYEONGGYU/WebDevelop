package p190710;

public class project190710 {

	public static void main(String[] args) {
		
		/*
		//2차원 배열 생성 그리고 초기값 대입
		int [][] array = new int[3][5];
		int t=0;
		int sum=0;
		int summ=0;
		
		//2차원 초기값 대입
		for(int i=0; i<3; i++) {
			for(int j=0; j<5; j++) {
				array[i][j]=t++;
			}
		}
		
		//배열출력 및 가로합계
		for(int i=0; i<3; i++) {
			sum=0;
			for(int j=0; j<5; j++) {
				
				System.out.printf("%2d ",array[i][j]);
				sum = sum+array[i][j];
			}
			System.out.printf("%2d ",sum);
			System.out.println("");
		}
		
		//세로 합계
		for(int i=0; i<5; i++) {
			sum=0;
			for(int j=0; j<3; j++) {
				sum = sum+array[j][i];
			}
			System.out.printf("%2d ",sum);
		}
		System.out.println("");
		*/
		
		//1. String을 저장 " 영 진전 문대학교컴퓨터정 보계 열";
		//2. 6행 3열 짜리 문자 배열 생성q 
		//3. 배열의 각 원소에 문자 저장
		//4. 배열을 출력하여 
		/* 
		 영 진
		 전 문
		 대학교
		 컴퓨터
		 정 보
		 계 열
		 */
		
		String arr = "영 진전 문대학교컴퓨터정 보계 열";
		
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

import java.util.Scanner;

public class Ghya {

	public static void main(String[] args) {
		
		int i, j, n = 0, a=0;
		Scanner input = new Scanner(System.in);
		System.out.printf("\n숫자를 입력하세요");
		a =  input.nextInt();
		n = a*(3*a+2);
		
		//이차원 배열 생성
		char[][] arr = new char[n][n];
		
		//값 입력 L
		for(i=0; i<n; i++) {
			for(j=0; j<n; j++) {
				if( j==0 || j==n || i==n-1) {
					arr[i][j] = '.';
		  		}else {
		  			arr[i][j] = ' ';
		  		}
				
			}
		}
		
		//출력 L
		for(i=0; i<n; i++) {
			for(j=0; j<n; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println(" ");
			for(int h=0; h<j; h++) {
				System.out.print("^");
			}
			
		}

		//B
		for(int z=0; z<n; z++) {
			for(int x=0; x<n; x++) {
				if( z==0 || x==0 || z==n/2 || z==n-1 || x==n-1) {
					arr[z][x] = '&';
		  		}else {
		  			arr[z][x] = ' ';
		  		}
				
			}
		}
		
		//B출력
		for(i=0; i<n; i++) {
			
			for(j=0; j<n; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println(" ");
		}
		
		// K j < n/4 
		for(i=0; i<n; i++) {
			for(j=0; j<n; j++) {
				if( j==0 || i==n/4 || i==n/2) {
					arr[i][j] = '%';
		  		}else {
		  			arr[i][j] = ' ';
		  		}
			}
		}
		
		//k
		for(i=0; i<n; i++) {
			
			for(j=0; j<n; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println(" ");
		}
	}
}
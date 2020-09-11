import java.util.*;
public class project190424 {

 public static void main(String[] args) {
	// 이름이니셜();
	 배열이름합구하기();
 }
 
 static void 배열이름합구하기() {
	 int i, j, n;
	 n = 9;
	 
	 //배열 입력
	 int[][] arrayA;
	 arrayA = new int [n+1][n+1];
			 for(i=0; i<n; i++) {
				for(j=0; j<n; j++) {
					if(i==0 && j==0 && j==n-1 || i==n/2 || j ==n+2) {
						arrayA[i+1][j+1] = 1;
					}else {
						arrayA[i+1][j+1] = 0;
					}
				}
			 }

	//배열 값 합산
			//i j합산
				for(i=0; i<n; i++) {
					for(j=0 ;j<n; j++) {
						arrayA[i+1][0] = arrayA[i+1][0] + arrayA[i+1][j+1];
						arrayA[0][j+1] = arrayA[0][j+1] + arrayA[i+1][j+1];
					}
					arrayA[0][0] = arrayA[0][0] + arrayA[i+1][j];
				}
				
			 //i값 합산
			for(i=0; i<n; i++) {
				for(j=0 ;j<n; j++) {
					arrayA[1][0] = arrayA[i][j] + arrayA[i][j];
				}
			}
			
			//j값 합산
			for(i=0; i<n; i++) {
				for(j=0 ;j<n; j++) {
					arrayA[9][j] = arrayA[9][j] + arrayA[i][j]; 
				}
			}
			
			 //배열 출력
			 for(i=0; i<n+1; i++) {
				 System.out.printf("%2d: ",i);
				 	for(j=0; j<n+1; j++) {
				 		if(arrayA[i][j] > 0) {
				 		System.out.printf("%2d", arrayA[i][j]);
				 	}else{
				 		System.out.print(" ");
				 	}
				 	System.out.print("\n");
				 	
			 }
			 }
	 
 }
	 
	static void 이름이니셜(){
	Scanner input = new Scanner(System.in);
  
  System.out.print("숫자를 입력하세요 : ");
  int n = input.nextInt();
  
  char[][] name = new char[n][3*n+2];
  
  int i,j;
 
  
  for ( i = 0; i < n; i++) {
   for ( j = 0 ; j < 3*n+2; j++) {
    if ( j < n) {
     if ( j==0 || j==n || i==n-1) {
      name[i][j] = '*';
     }
     else {
      name[i][j] = ' ';
     }
    }
    if ( j == n ) {
     name[i][j] = ' ';
    }
    if ( j > n && j < 2*n+1) {
     if (i==0 || j==0 || j==n/2 || i==n-1 || j==n-1) {
      name[i][j] = '&';
     }
     else {
      name[i][j] = ' ';
     }
    }
    if ( j == 2*n+1) {
     name[i][j] = ' ';
    }
    if ( j > 2*n+1) {
     if (j==0 || i==n/4 || i==n/2) {
      name[i][j] = '%';
     }
     else {
      name[i][j] = ' ';
     }
    }
   }
  }
  
  
  
  for ( i = 0; i < n; i++) {
   System.out.printf("%2d: ", i);
   for ( j = 0; j < 3*n+2; j++) {
    System.out.print(name[i][j]);
   }
   System.out.print("\n");
  }
  

 }

}
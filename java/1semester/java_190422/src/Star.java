import java.util.Scanner;

public class Star {
 public static void main(String[] args) {
  // 직각삼각형1();
  // 직각삼각형2();
//  직각삼각형3();
//  직각삼각형3번호();
//  직각삼각형4번호();
//  이등변삼각형1();
//  조합삼각형1();
//  조합삼각형2();
//  조합삼각형3();
//  조합삼각형3_1(); // for문 2개만 사용
//  다이아몬드1(); // 2개 중복
//  다이아몬드2(); // 중복 제거
//  다이아몬드3(); // 반쪽 다이아몬드
	 다이아몬드n개수();
 }
 static void H찍어() {

	 int i, j, n, k;
	 
	 Scanner input = new Scanner(System.in);
	  System.out.print("숫자를 입력해\n");
	  k = input.nextInt();
	  
	  for(i=0; i<k; i++) {
		  
		 
		  	for(j=0; j<k; j++) {
		  		if(i==0 || j==0 || j==k-1) {
		  			System.out.print("*");
		  		}else {
		  			System.out.print(" ");
		  		}
		  	}
		  	System.out.print("\n");
	  }
 }
 static void 다이아몬드n개수() {
	 
	 int i, j, n, k;
	 
	 Scanner input = new Scanner(System.in);
	  System.out.print("\n N의 개수 입력하면 다이아몬드가 출력됩니당");
	  k = input.nextInt();
	  
	  
	  Scanner input2 = new Scanner(System.in);
	  System.out.print("\n 이 숫자입력하면 줄수를 표시합니당");
	  n = input2.nextInt();
	  
	  for(k=0; k<n; k++) {
		  
	  for (i = 0; i < n; i = i + 1) {
	  
	   
	   for (j = 0; j < n-i-1; j = j + 1) {
	    System.out.print(" ");
	   }

	   for (j = 0; j < 2*i+1; j = j + 1) {
	    System.out.print("*");
	   }

	   	for(k=0; k<n-1; k++){
	   		for(j=0; j< 2*(n-i)-2; j=j+1){
	   			System.out.print(" ");
	   			
	   		}
	   		for(j=0; j< 2*i+1; j=j+1){
	   			System.out.print("+");
	   			
	   		}
	   	}
	 
	   System.out.print("\n");
	  }
	  for (i = 0; i < n-1; i = i + 1) {
	  
	   
	   for (j = 0; j < i+1; j = j + 1) {
	    System.out.print(" ");
	   }
	   for (j = 0; j < 2*(n-i)-3; j = j + 1) {
	    System.out.print("*");
	   }
	   
	   /*
	   //두번쨰 다이아
	   for (j = 0; j < i+1; j = j + 1) {
		    System.out.print("-");
		   }
	   for (j = 0; j < i+1; j = j + 1) {
		    System.out.print(" ");
		   }
		   for (j = 0; j < 2*(n-i)-3; j = j + 1) {
		    System.out.print("*");
		   }
	   //세번째 다디아
		  
		   
		   for (j = 0; j < i+1; j = j + 1) {
			    System.out.print("-");
			   }
		   for (j = 0; j < i+1; j = j + 1) {
			    System.out.print(" ");
			   }
			   for (j = 0; j < 2*(n-i)-3; j = j + 1) {
			    System.out.print("*");
			   }
	   */
	   
	   System.out.print("\n");
	  }
	  }
 }
 static void 다이아몬드4() {
  int i, j, n;
  Scanner input = new Scanner(System.in);
  System.out.print("\n숫자를 입력하세요");
  n = input.nextInt();
  
  for (i = 0; i < n; i = i + 1) {
   System.out.printf("%2d: ", i);
   
   for (j = 0; j < n-i-1; j = j + 1) {
    System.out.print("-");
   }

   for (j = 0; j < 2*i+1; j = j + 1) {
    System.out.print("*");
   }
   
   // 두번쨰 다이아임
   
   for (j = 0; j < 2*(n-i-1); j = j + 1) {
	    System.out.print(" ");
	    
	   }
   
   for (j = 0; j < 2*i+1; j = j + 1) {
	    System.out.print("*");
	    
	   }
   
   for (j = 0; j < 2*(n-i-1); j = j + 1) {
	    System.out.print(" ");
	    
	   }
  
  for (j = 0; j < 2*i+1; j = j + 1) {
	    System.out.print("*");
	    
	   }
  
  
   System.out.print("");
  }
  for (i = 0; i < n-1; i = i + 1) {
   System.out.printf("%2d: ", i + n);
   
   for (j = 0; j < i+1; j = j + 1) {
    System.out.print("-");
   }
   for (j = 0; j < 2*(n-i)-3; j = j + 1) {
    System.out.print("*");
   }
   
   
   //두번쨰 다이아
   for (j = 0; j < i+1; j = j + 1) {
	    System.out.print("-");
	   }
   for (j = 0; j < i+1; j = j + 1) {
	    System.out.print(" ");
	   }
	   for (j = 0; j < 2*(n-i)-3; j = j + 1) {
	    System.out.print("*");
	   }
   //세번째 다디아
	  
	   
	   for (j = 0; j < i+1; j = j + 1) {
		    System.out.print("-");
		   }
	   for (j = 0; j < i+1; j = j + 1) {
		    System.out.print(" ");
		   }
		   for (j = 0; j < 2*(n-i)-3; j = j + 1) {
		    System.out.print("*");
		   }
		   
		   
   
   System.out.print("\n");
  }

  return;
 }
 static void 다이아몬드3() {
  int i, j, n;
  Scanner input = new Scanner(System.in);
  System.out.print("\n숫자를 입력하세요");
  n = input.nextInt();
  for (i = 0; i < n; i = i + 1) {
   System.out.printf("%2d: ", i);
   for (j = 0; j < n-i-1; j = j + 1) {
    System.out.print("-");
   }
   for (j = 0; j < 2*i+1; j = j + 1) {
    System.out.print("*");
   }
   System.out.print("\n");
  }
  for (i = 0; i < n-1; i = i + 1) {
   System.out.printf("%2d: ", i + n);
   for (j = 0; j < 2*(n-i)-3; j = j + 1) {
    System.out.print("*");
   }
   System.out.print("\n");
  }

  return;
 }
 static void 다이아몬드2() {
  int i, j, n;
  Scanner input = new Scanner(System.in);
  System.out.print("\n숫자를 입력하세요");
  n = input.nextInt();
  for (i = 0; i < n; i = i + 1) {
   System.out.printf("%2d: ", i);
   for (j = 0; j < 2*i+1; j = j + 1) {
    System.out.print("*");
   }
   System.out.print("\n");
  }
  for (i = 0; i < n-1; i = i + 1) {
   System.out.printf("%2d: ", i + n);
   for (j = 0; j < 2*(n-i)-3; j = j + 1) {
    System.out.print("*");
   }
   System.out.print("\n");
  }

  return;
 }
 static void 다이아몬드1() {
  int i, j, n;
  Scanner input = new Scanner(System.in);
  System.out.print("\n숫자를 입력하세요");
  n = input.nextInt();
  for (i = 0; i < n; i = i + 1) {
   System.out.printf("%2d: ", i);
   for (j = 0; j < 2*i+1; j = j + 1) {
    System.out.print("*");
   }
   System.out.print("\n");
  }
  for (i = 0; i < n; i = i + 1) {
   System.out.printf("%2d: ", i + n);
   for (j = 0; j < 2*(n-i)-1; j = j + 1) {
    System.out.print("*");
   }
   System.out.print("\n");
  }

  return;
 }
 
 static void 조합삼각형3_1() {
  int i, j, n;
  Scanner input = new Scanner(System.in);
  System.out.print("\n숫자를 입력하세요");
  n = input.nextInt();
  for (i = 0; i < n; i = i + 1) {
   System.out.printf("%2d: ", i);
   for (j = 0; j < n + 1; j = j + 1) {
    if (i == j) {
     System.out.print(" ");
    } else {
     System.out.print("*");
    }
   }
   System.out.print("\n");
  }

  return;

 }

 static void 조합삼각형3() {
  int i, j, n;
  Scanner input = new Scanner(System.in);
  System.out.print("\n숫자를 입력하세요");
  n = input.nextInt();
  for (i = 0; i < n; i = i + 1) {
   System.out.printf("%2d: ", i);
   for (j = 0; j < i; j = j + 1) {
    System.out.print("*");
   }
   System.out.print(" ");
   for (j = 0; j < n - i; j = j + 1) {
    System.out.print("*");
   }
   System.out.print("\n");
  }

  return;

 }

 static void 조합삼각형2() {
  int i, j, n;
  Scanner input = new Scanner(System.in);
  System.out.print("\n숫자를 입력하세요");
  n = input.nextInt();
  for (i = 0; i < n; i = i + 1) {
   System.out.printf("%2d: ", i);
   for (j = 0; j < i; j = j + 1) {
    System.out.print("-");
   }
   for (j = 0; j < n - i + 1; j = j + 1) {
    System.out.print("*");
   }
   System.out.print("\n");
  }

  return;

 }

 static void 조합삼각형1() {
  int i, j, n;
  Scanner input = new Scanner(System.in);
  System.out.print("\n숫자를 입력하세요");
  n = input.nextInt();
  for (i = 0; i < n; i = i + 1) {
   System.out.printf("%2d: ", i);
   for (j = 0; j < n - i - 1; j = j + 1) {
    System.out.print("-");
   }
   for (j = 0; j < i + 1; j = j + 1) {
    System.out.print("*");
   }
   System.out.print("\n");
  }

  return;

 }

 static void 이등변삼각형1() {
  int i, j, n;
  Scanner input = new Scanner(System.in);
  System.out.print("\n숫자를 입력하세요");
  n = input.nextInt();
  for (i = 0; i < n; i = i + 1) {
   System.out.printf("%2d: ", i);
   for (j = 0; j < i + 1; j = j + 1) {
    System.out.print("*");
   }
   System.out.print("\n");
  }
  for (i = 0; i < n; i = i + 1) {
   System.out.printf("%2d: ", n + i);
   for (j = 0; j < n - i; j = j + 1) {
    System.out.print("*");
   }
   System.out.print("\n");
  }
  return;

 }

 // 메소드 정의 void 메소드이름() { }
 static void 직각삼각형4번호() {
  int i, j, n;
  int sum = 0;
  Scanner input = new Scanner(System.in);
  System.out.print("\n숫자를 입력하세요");
  n = input.nextInt();
  for (i = 0; i < n; i = i + 1) {
   System.out.printf("%2d: ", i);
   for (j = 0; j < 2 * (n - i) - 1; j = j + 1) {
    System.out.print("*");
   }
   System.out.print("\n");

  }
  return;

 }

 static void 직각삼각형3번호() {
  int i, j, n;
  int sum = 0;
  Scanner input = new Scanner(System.in);
  System.out.print("\n숫자를 입력하세요");
  n = input.nextInt();
  for (i = 0; i < n; i = i + 1) {
   System.out.printf("%2d: ", i);
   for (j = 0; j < 2 * i + 1; j = j + 1) {
    System.out.print("*");
   }
   System.out.print("\n");

  }
  return;

 }

 static void 직각삼각형3() {
  int i, j, n;
  int sum = 0;
  Scanner input = new Scanner(System.in);
  System.out.print("\n숫자를 입력하세요");
  n = input.nextInt();
  for (i = 0; i < n; i = i + 1) {
   for (j = 0; j < 2 * i + 1; j = j + 1) {
    System.out.print("*");
   }
   System.out.print("\n");

  }
  System.out.print(sum);

  return;

 }

 static void 직각삼각형2() {
  int i, j, n;
  int sum = 0;
  Scanner input = new Scanner(System.in);
  System.out.print("\n숫자를 입력하세요");
  n = input.nextInt();
  for (i = 0; i < n; i = i + 1) {
   for (j = 0; j < n - i; j = j + 1) {
    System.out.print("*");
   }
   System.out.print("\n");

  }
  System.out.print(sum);

  return;

 }

 static void 직각삼각형1() {
  int i, j, n;
  Scanner input = new Scanner(System.in);
  System.out.print("\n숫자를 입력하세요");
  n = input.nextInt();
  for (i = 0; i < n; i = i + 1) {
   for (j = 0; j < i + 1; j = j + 1) {
    System.out.print("*");

   }
   System.out.print("\n");
  }

  System.out.println("");
  return;

 }

}

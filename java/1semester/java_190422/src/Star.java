import java.util.Scanner;

public class Star {
 public static void main(String[] args) {
  // �����ﰢ��1();
  // �����ﰢ��2();
//  �����ﰢ��3();
//  �����ﰢ��3��ȣ();
//  �����ﰢ��4��ȣ();
//  �̵�ﰢ��1();
//  ���ջﰢ��1();
//  ���ջﰢ��2();
//  ���ջﰢ��3();
//  ���ջﰢ��3_1(); // for�� 2���� ���
//  ���̾Ƹ��1(); // 2�� �ߺ�
//  ���̾Ƹ��2(); // �ߺ� ����
//  ���̾Ƹ��3(); // ���� ���̾Ƹ��
	 ���̾Ƹ��n����();
 }
 static void H���() {

	 int i, j, n, k;
	 
	 Scanner input = new Scanner(System.in);
	  System.out.print("���ڸ� �Է���\n");
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
 static void ���̾Ƹ��n����() {
	 
	 int i, j, n, k;
	 
	 Scanner input = new Scanner(System.in);
	  System.out.print("\n N�� ���� �Է��ϸ� ���̾Ƹ�尡 ��µ˴ϴ�");
	  k = input.nextInt();
	  
	  
	  Scanner input2 = new Scanner(System.in);
	  System.out.print("\n �� �����Է��ϸ� �ټ��� ǥ���մϴ�");
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
	   //�ι��� ���̾�
	   for (j = 0; j < i+1; j = j + 1) {
		    System.out.print("-");
		   }
	   for (j = 0; j < i+1; j = j + 1) {
		    System.out.print(" ");
		   }
		   for (j = 0; j < 2*(n-i)-3; j = j + 1) {
		    System.out.print("*");
		   }
	   //����° �ٵ��
		  
		   
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
 static void ���̾Ƹ��4() {
  int i, j, n;
  Scanner input = new Scanner(System.in);
  System.out.print("\n���ڸ� �Է��ϼ���");
  n = input.nextInt();
  
  for (i = 0; i < n; i = i + 1) {
   System.out.printf("%2d: ", i);
   
   for (j = 0; j < n-i-1; j = j + 1) {
    System.out.print("-");
   }

   for (j = 0; j < 2*i+1; j = j + 1) {
    System.out.print("*");
   }
   
   // �ι��� ���̾���
   
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
   
   
   //�ι��� ���̾�
   for (j = 0; j < i+1; j = j + 1) {
	    System.out.print("-");
	   }
   for (j = 0; j < i+1; j = j + 1) {
	    System.out.print(" ");
	   }
	   for (j = 0; j < 2*(n-i)-3; j = j + 1) {
	    System.out.print("*");
	   }
   //����° �ٵ��
	  
	   
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
 static void ���̾Ƹ��3() {
  int i, j, n;
  Scanner input = new Scanner(System.in);
  System.out.print("\n���ڸ� �Է��ϼ���");
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
 static void ���̾Ƹ��2() {
  int i, j, n;
  Scanner input = new Scanner(System.in);
  System.out.print("\n���ڸ� �Է��ϼ���");
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
 static void ���̾Ƹ��1() {
  int i, j, n;
  Scanner input = new Scanner(System.in);
  System.out.print("\n���ڸ� �Է��ϼ���");
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
 
 static void ���ջﰢ��3_1() {
  int i, j, n;
  Scanner input = new Scanner(System.in);
  System.out.print("\n���ڸ� �Է��ϼ���");
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

 static void ���ջﰢ��3() {
  int i, j, n;
  Scanner input = new Scanner(System.in);
  System.out.print("\n���ڸ� �Է��ϼ���");
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

 static void ���ջﰢ��2() {
  int i, j, n;
  Scanner input = new Scanner(System.in);
  System.out.print("\n���ڸ� �Է��ϼ���");
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

 static void ���ջﰢ��1() {
  int i, j, n;
  Scanner input = new Scanner(System.in);
  System.out.print("\n���ڸ� �Է��ϼ���");
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

 static void �̵�ﰢ��1() {
  int i, j, n;
  Scanner input = new Scanner(System.in);
  System.out.print("\n���ڸ� �Է��ϼ���");
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

 // �޼ҵ� ���� void �޼ҵ��̸�() { }
 static void �����ﰢ��4��ȣ() {
  int i, j, n;
  int sum = 0;
  Scanner input = new Scanner(System.in);
  System.out.print("\n���ڸ� �Է��ϼ���");
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

 static void �����ﰢ��3��ȣ() {
  int i, j, n;
  int sum = 0;
  Scanner input = new Scanner(System.in);
  System.out.print("\n���ڸ� �Է��ϼ���");
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

 static void �����ﰢ��3() {
  int i, j, n;
  int sum = 0;
  Scanner input = new Scanner(System.in);
  System.out.print("\n���ڸ� �Է��ϼ���");
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

 static void �����ﰢ��2() {
  int i, j, n;
  int sum = 0;
  Scanner input = new Scanner(System.in);
  System.out.print("\n���ڸ� �Է��ϼ���");
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

 static void �����ﰢ��1() {
  int i, j, n;
  Scanner input = new Scanner(System.in);
  System.out.print("\n���ڸ� �Է��ϼ���");
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

import java.util.*;

public class Test1 {

 public static void main(String[] args) {
  Scanner scan = new Scanner(System.in);
  int i, j, k;
  int l = 3;
  int a = 0;

  System.out.print("n의 값을 입력하시오 : ");
  int n = scan.nextInt();

  for (i = 0; i < n; i++) {
   a = a + 1;
   System.out.printf("%2d ", a);
   
   
   for (j = 0; j < n - (n - 1); j++) {
    if (i == (n - 1)) {
     for (k = 0; k < n; k++) {
      System.out.print("■");
     }
    } else {
     System.out.print("■");
    }
   }
   
   
   
//   for (j = 0; j < n - 1; j++) {
//    if (i == (n - 1)) {
//     System.out.print("");
//    } else {
//     System.out.print(" ");
//    }
//   }
//   
//   
//   for (j = 0; j < n - (n - 1); j++) {
//    System.out.print(" ");
//   }
//   for (j = 0; j < n - (n - 1); j++) {
//    if (i == 0) {
//     for (k = 0; k < n; k++) {
//      System.out.print("■");
//     }
//    } else if (i == n - 1) {
//     for (k = 0; k < n; k++) {
//      System.out.print("■");
//     }
//    } else {
//     System.out.print("■");
//    }
//
//   }
//   for (j = 0; j < n - 1; j++) {
//    if (i == 0) {
//     System.out.print("");
//    } else if (i == n - 1) {
//     System.out.print("");
//    } else {
//     System.out.print(" ");
//    }
//   }
//   System.out.print(" ");
//  
//   
//   for(j=0; j<n; j++){
//    
//   if(i==0 || j == 0 &&  i< n/2 || i==n/2 || i==n-1 || j==n-1 && i>n/2 ){
//    System.out.print("■");
//   }else{
//    System.out.print(" ");
//   }
//   }
//   System.out.println();
//  }
 }
} 
}
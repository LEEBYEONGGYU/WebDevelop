package p190708;
import java.util.Scanner;
public class project190708 {

	public static void main(String[] args) {
/*
		int num=0, i=0, j=0;
		System.out.println("곱할 수");
		Scanner sc = new Scanner(System.in);
		j = sc.nextInt(); //j에 입력한거
		

		for(i=2; i<=9; i++) {
			for(j=1; j<=9; j++) {	
				//System.out.print("2*" + (i+1) + "=" +2*(i+1)+" ");
				//System.out.println("3*" + (i+1) + "=" +3*(i+1));
			
				System.out.print(i+"*"+j+"="+j*i+"  ");
				System.out.println(i+1+"*"+j+"="+j*i);
	}
			System.out.println();
}*/
		
		/*
		//배열 10개의 숫자를 랜덤하게 생성하여 배열에 저장하고
		//배열의 모든 값 과 합계와 평균을  출력하라
		
		int [] array;
		array = new int[10];
		
		
		int hap=0;
		double avg=0;
		
		for(int i=0; i<10; i++) {
			array[i] =  (int) ((Math.random()*1000)+1);
			
			System.out.println("각 배열의 랜덤값 "+array[i]);
			 hap = hap+array[i];
			 avg = hap/10;
		}
		
		System.out.println();
		System.out.println("배열의 합계는 "+hap);
		System.out.println("배열의 평균은 "+(double)hap/10);
		*/
		
		//100개의 원소를 배열에 피보나치 수열값을 저장하자
		//1 1 2 3 5 8 13 21 ...
		
		//1 피보나치 수열 값 저장
		int [] fibo = new int[45];
		long hap=0; double avg=0;
		
		fibo[0] = 1;
		fibo[1] = 1;
		for(int i = 0; i<43; i++) {
			fibo[i+2] = fibo[i]+fibo[i+1];
		}
		//배열의 각 원솟 출력
		for(int i=0; i<45; i++) {
			System.out.println(i+ ":"+fibo[i]);
			
			hap = hap+fibo[i];
			avg = hap/fibo.length;
		}
		
		//배열 합
		System.out.println();
		System.out.println("배열의 합계는 "+hap);
		System.out.println("배열의 평균은 "+avg);
		
}
}
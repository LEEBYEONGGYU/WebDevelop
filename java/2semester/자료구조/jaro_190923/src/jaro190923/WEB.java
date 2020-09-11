package jaro190923;

public class WEB {

	public static void main(String[] args) {
		float a[] = new float[] {4,3,5,0};
		float b[] = new float[] {3,1,0,2,1};
		
		int degreeA = a.length;
		int degreeB = b.length;
		int expoA = degreeA;
		int expoB = degreeB;
		int degreeC = degreeA;
		
		if(degreeA < degreeB) degreeC=degreeB;
		float c[] = new float[degreeC];
		
		if(degreeA>=degreeB) {
			degreeC=degreeA;
		}else {
			degreeC=degreeB;
		}
		
		int ixA=0, ixB=0, ixC=0; 
		while(ixA < degreeA && ixB < degreeB) { 
			
			if(expoA > expoB) { 
				c[ixC] = a[ixA];
				ixC++; ixA++; 
				expoA--;
				/*
				 ¤§e
				 */
			}else if(expoA == expoB){
				c[ixC]=a[ixA]+b[ixB];
				ixC++; ixA++; ixB++;
				expoA--; expoB--;
			}else {
				c[ixC]=a[ixB];
				ixC++; ixB++;
				expoB--;
			}
		}
		
		int temp;
		temp=degreeA;
		
		System.out.print("A(x)= ");
		for(int i=0; i<degreeA; i++) {
			System.out.printf("%2.0fx^%d",a[i],--temp);
		}
		
		temp=degreeB;
		System.out.println();
		System.out.print("B(x)= ");
		for(int i=0; i<degreeB; i++) {
			System.out.printf("%2.0fx^%d",b[i],--temp);
		}
		
		temp=degreeC;
		System.out.println();
		System.out.print("C(x)= ");
		for(int i=0; i<degreeC; i++) {
			System.out.printf("%2.0fx^%d",c[i],--temp);
		}
	}	

}

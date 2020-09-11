package jaro_190905;

public class list {

	public static void main(String[] args) {
		int sale[] = new int[] {63,84,140,130,157,209,251,312};
		
		for(int i=0; i<2; i++) {
			for(int j=0; j<4; j++) {
				System.out.printf("%d/4ºÐ±â: sale[%d]= %d%n", j+1,i,sale[i*4+j]);
				System.out.println();
			}
		}
	}

}

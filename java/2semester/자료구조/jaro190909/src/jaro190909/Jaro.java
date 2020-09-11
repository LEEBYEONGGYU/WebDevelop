package jaro190909;

public class Jaro {

	public static void main(String[] args) {
		int[][] array = new int[8][7];
		
		for (int i=0; i<6; i++){
			for (int j=0; j<6; j++){
			int tmp = array[i][j];
			array[i][j] = array[j][i];
			array[j][i] = tmp;
			System.out.println(tmp);
			}
			
		} 

}
}

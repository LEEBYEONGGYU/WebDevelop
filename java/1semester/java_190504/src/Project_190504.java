class Lotto{
	//1~45 숫자 7개
	private int [] numbers;
	
	// 7개를 랜덤하게 생성하는 생성자
	public Lotto() {
		numbers = new int[7];
		for(int i=1; i<7; i++) {
			int n = (int) (Math.random()*45);
			numbers[i] = n+1;
		}
	}
	
	//하나의 숫자만 주면 나머지 6개를 랜덤하게 생성하는 생성자를 만들어라

	public Lotto(int p) {
		numbers = new int[7];
		numbers[0] = p;
		for(int i=0; i<6; i++) {
			int n = (int) (Math.random()*45);
			numbers[i+1] = n+1;
		}
	}
	
	//출력메소드
	public String toString() {
		String result = "";
		for(int i=1; i<7; i++) {
			result = result.concat(" " + numbers[i]);
		}
		return result;
	}
}
public class Project_190504 {
	public static void main(String[] args) {
		
		Lotto 당첨번호 = new Lotto();
		System.out.println(당첨번호);
		Lotto 당첨번호1 = new Lotto(2);
		System.out.println(당첨번호1);

	}

}

class Lotto{
	//1~45 ���� 7��
	private int [] numbers;
	
	// 7���� �����ϰ� �����ϴ� ������
	public Lotto() {
		numbers = new int[7];
		for(int i=1; i<7; i++) {
			int n = (int) (Math.random()*45);
			numbers[i] = n+1;
		}
	}
	
	//�ϳ��� ���ڸ� �ָ� ������ 6���� �����ϰ� �����ϴ� �����ڸ� ������

	public Lotto(int p) {
		numbers = new int[7];
		numbers[0] = p;
		for(int i=0; i<6; i++) {
			int n = (int) (Math.random()*45);
			numbers[i+1] = n+1;
		}
	}
	
	//��¸޼ҵ�
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
		
		Lotto ��÷��ȣ = new Lotto();
		System.out.println(��÷��ȣ);
		Lotto ��÷��ȣ1 = new Lotto(2);
		System.out.println(��÷��ȣ1);

	}

}

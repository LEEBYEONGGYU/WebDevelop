import java.util.Scanner;

//Car Ŭ������ �����մϴ�
class Car{
	//�ʵ�
	String color;
	int speed;
	int gear;
	//�޼ҵ�
	
	void print() {
		System.out.print("Color="+color);
		System.out.print("Speed="+speed);
		System.out.print("Color="+color);
	}
	
	int setSpeed(int s) {
		speed = s;
		return speed;
	}
}
public class Project_1900503 {

	public static void main(String[] args) {
		//��ü�� ����
		//��ü���������� �ʿ�
		Car myCar;
		myCar = new Car();
		myCar.color = "����";
		myCar.print();
		
		//yourCar��� ��ü���������� ����� ���ο� ��ü�� �����Ͽ�
		//����� speed, gear���� �Է��Ͽ� �������
		Car yourCar;
		yourCar = new Car();
		yourCar.color="���";
		yourCar.gear=1;
		yourCar.speed=100;
		yourCar.setSpeed(200); // 200�� �μ� �޼��� ȣ���� �� �Է¹��� �������ִ� ���� �μ��� �ϰ� ���� �޼��忡�� �� �μ��� ���� ���� ��ȯ�ϴ� ���κ������ ��⸦ �Ѵ�
		yourCar.print();
		
		System.out.println("gear="+yourCar.gear);
		System.out.println("speed="+yourCar.gear);
		
	}

}

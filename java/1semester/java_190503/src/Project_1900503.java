import java.util.Scanner;

//Car 클래스를 정의합니다
class Car{
	//필드
	String color;
	int speed;
	int gear;
	//메소드
	
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
		//객체를 생성
		//객체참조변수가 필요
		Car myCar;
		myCar = new Car();
		myCar.color = "빨강";
		myCar.print();
		
		//yourCar라는 객체참조변수를 만들고 새로운 객체를 저장하여
		//색깔과 speed, gear수를 입력하여 출력하자
		Car yourCar;
		yourCar = new Car();
		yourCar.color="노랑";
		yourCar.gear=1;
		yourCar.speed=100;
		yourCar.setSpeed(200); // 200은 인수 메서드 호출할 ㄸ 입력밧을 전달해주는 것을 인수로 하고 실제 메서드에서 그 인수로 받은 값을 반환하는 메인변수라고 얘기를 한다
		yourCar.print();
		
		System.out.println("gear="+yourCar.gear);
		System.out.println("speed="+yourCar.gear);
		
	}

}

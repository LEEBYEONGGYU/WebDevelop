package p190614;

public class Triangle implements Shape {
	int x;
	int y;
	
	public Triangle() {
		x = 5;
		y = 5;
	}
	@Override
	public void draw() {
		
		System.out.println("�ﰢ���� �׸���");
	}

	@Override
	public double area() {
		
		return (0.5*x*y);
	}

}

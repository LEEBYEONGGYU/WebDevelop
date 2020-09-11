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
		
		System.out.println("삼각형의 그리기");
	}

	@Override
	public double area() {
		
		return (0.5*x*y);
	}

}

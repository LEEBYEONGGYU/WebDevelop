package p190614;

public class Circle implements Shape {
	int radius;
	public Circle() {
		radius = 5;
		
	}
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("원그리기");
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return (Math.PI*radius*radius);
	}

}

package p190614;

public class Rectangle implements Shape {
int width;
int height;
public Rectangle() {
	width = 5;
	height = 10;
}
	@Override
	public void draw() {
		System.out.println("�簢�� �׸���");

	}

	@Override
	public double area() {
		
		return (width*height);
	}

}

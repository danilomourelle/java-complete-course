import model.entities.AbstractShape;
import model.entities.Circle;
import model.entities.Rectangle;
import model.entities.Shape;
import model.entities.Square;
import model.enums.Color;

public class App {
	public static void main(String[] args) {
		AbstractShape s1 = new Circle(2.0, Color.BLACK);
		AbstractShape s2 = new Rectangle(3.0, 4.0, Color.BLUE);
		Shape s3 = new Square(2.0);

		System.out.println("Circle color: " + s1.getColor());
		System.out.println("Circle area: " + s1.area());

		System.out.println("Rectangle color: " + s2.getColor());
		System.out.println("Rectangle area: " + s2.area());

		System.out.println("Square area: " + s3.area());
	}
}

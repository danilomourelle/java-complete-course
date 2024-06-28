import java.util.ArrayList;
import java.util.List;

import model.entities.Circle;
import model.entities.Rectangle;
import model.entities.Shape;

public class App {
	public static void main(String[] args) {
		List<Shape> myShapes = new ArrayList<>();
		myShapes.add(new Rectangle(3.0, 2.0));
		myShapes.add(new Circle(2.0));
		System.out.println("Total area: " + totalArea(myShapes));

		List<Circle> myCircles = new ArrayList<>();
		myCircles.add(new Circle(2.0));
		myCircles.add(new Circle(3.0));
		System.out.println("Total area: " + totalArea(myCircles));

		List<Rectangle> myRectangles = new ArrayList<>();
		myRectangles.add(new Rectangle(3.0, 2.0));
		myRectangles.add(new Rectangle(2.0, 3.0));
		System.out.println("Total area: " + totalArea(myRectangles));
	}

	public static double totalArea(List<? extends Shape> list) {
		double total = 0;
		for (Shape s : list) {
			total += s.area();
		}
		return total;
	}
}

import java.util.ArrayList;
import java.util.List;

public class App {
	public static void main(String[] args) {
		List<String> strings = List.of("apple", "banana", "orange");
		List<Integer> integers = List.of(1, 2, 3, 4, 5);
		List<Double> doubles = List.of(1.1, 2.2, 3.3, 4.4, 5.5);	

		List<Object> objects = new ArrayList<>();

		copy(integers, objects);
		printList(objects);

		copy(doubles, objects);
		printList(objects);

		// copy(strings, objects); - error: String is not part of Number inheritance hierarchy
	}	

	public static void copy(List<? extends Number> source, List<? super Number> destination) {
		for (Number obj : source) {
			destination.add(obj);
		}

		Object number = destination.get(0); // Object is the only class that can be used to store any type of object
	}

	public static void printList(List<?> list) {
		for (Object obj : list) {
			System.out.println(obj);
		}
	}
}

import java.util.List;

public class App {
	public static void main(String[] args) {
		List<String> listStr = List.of("a", "b", "c", "d", "e");
		List<Integer> listInt = List.of(1, 2, 3, 4, 5);

		List<?> listJoker = listStr;
		printList(listJoker);

		listJoker = listInt;
		printList(listJoker);
	}

	public static void printList(List<?> list) {
		for (Object i : list) {
			System.out.println(i);
		}
	}
}

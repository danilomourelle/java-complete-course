import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class App {
	public static void main(String[] args) {
		String[] array = new String[] { "Tv", "Tablet", "Notebook" };
		Set<String> hashSet = new HashSet<>(Arrays.asList(array));
		Set<String> linkedHashSet = new LinkedHashSet<>(Arrays.asList(array));
		Set<String> treeSet = new TreeSet<>(Arrays.asList(array));

		// Prints out of order
		for (String s : hashSet) {
			System.out.println(s);
		}

		// Prints in order it was added
		for (String s : linkedHashSet) {
			System.out.println(s);
		}

		// Prints in Comparator order
		for (String s : treeSet) {
			System.out.println(s);
		}

		hashSet.add("Smartphone");
		hashSet.remove("Notebook");
		hashSet.removeIf(el -> el.startsWith("T"));

		System.out.println(hashSet);

		Set<Integer> a = new TreeSet<>(Arrays.asList(0, 2, 4, 5, 6, 8, 10));
		Set<Integer> b = new TreeSet<>(Arrays.asList(5, 6, 7, 8, 9, 10));
		
		// union
		Set<Integer> c = new TreeSet<>(a);
		c.addAll(b);
		System.out.println(c);
		
		// intersection
		Set<Integer> d = new TreeSet<>(a);
		d.retainAll(b);
		System.out.println(d);
		
		// difference
		Set<Integer> e = new TreeSet<>(a);
		e.removeAll(b);
		System.out.println(e);
	}
}

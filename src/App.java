import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class App {
  public static void main(String[] args) throws Exception {
    List<String> names = new ArrayList<>();

    // ADD
    names.add("Alice");
    names.add("Bob");
    names.add("David");
    names.add(2, "Charlie"); // Insert at index 2 and shift the rest

    // REMOVE
    names.remove("David");
    names.remove(0); // Remove the first element and shift the rest

    // REMOVEIF
    names.removeIf(name -> name.startsWith("A")); // Remove all names starting with 'A'

    names.size(); // length of the list
    names.indexOf("Bob"); // Get the index of 'Bob' or -1 if not found

    // STREAM
    // Unmodifiable list
    List<String> namesStartingWithA = names.stream()
        .filter(name -> name.startsWith("A"))
        .toList();

    namesStartingWithA.add("Eve"); // UnsupportedOperationException

    // Modifiable list
    List<String> namesStartingWithB = names.stream()
        .filter(name -> name.startsWith("B"))
        .collect(Collectors.toList());

    namesStartingWithB.add("Eve"); // OK

    String firstNameWithA = names.stream()
      .filter(name -> name.startsWith("A"))
      .findFirst()
      .orElse(null);
  }
}
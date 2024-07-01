import java.util.Map;
import java.util.TreeMap;

public class App {
	public static void main(String[] args) {
		Map<String, String> cookies = new TreeMap<>();

		cookies.put("username", "john");
		cookies.put("email", "john@email.com");
		cookies.put("phone", "1234567890");

		cookies.remove("email");
		cookies.put("phone", "0987654321");

		System.out.println("Contains 'phone' key: " + cookies.containsKey("phone"));
		System.out.println("Phone: " + cookies.get("phone"));
		System.out.println("Email: " + cookies.get("email"));
		System.out.println("Size: " + cookies.size());
		System.out.println(cookies);

		System.out.println();
		System.out.println("COOKIES:");
		for (String key : cookies.keySet()) {
			System.out.println(key + ": " + cookies.get(key));
		}
		
		System.out.println();
		cookies.clear();
		System.out.println("Size: " + cookies.size());
		System.out.println(cookies);
	}
}

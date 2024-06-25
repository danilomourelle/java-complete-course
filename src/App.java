import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class App {
	public static void main(String[] args) {
		String path = "C:\\temp\\out.txt";

		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {
			String[] content = new String[] { "Good morning", "Good afternoon", "Good night" };

			for (String line : content) {
				bufferedWriter.write(line);
				bufferedWriter.newLine();
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} 
	}
}

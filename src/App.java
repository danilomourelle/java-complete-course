import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Locale;

public class App {
	public static void main(String[] args) {
		String path = "C:\\temp\\in.csv";

		File inFile = new File(path);
		String parentPath = inFile.getParent();
		new File(parentPath + "\\out").mkdir();
		File outFile = new File(parentPath + "\\out\\summary.csv");

		try (
			BufferedReader br = new BufferedReader(new FileReader(inFile));
			BufferedWriter bw = new BufferedWriter(new FileWriter(outFile)) 
			) {
			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				String name = fields[0];
				double price = Double.parseDouble(fields[1]);
				int quantity = Integer.parseInt(fields[2]);

				bw.write(name + "," + String.format(Locale.US, "%.2f", price * quantity));
				bw.newLine();

				line = br.readLine();
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}

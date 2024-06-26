import java.io.File;

public class App {
	public static void main(String[] args) {
		String path = "C:\\temp\\out.txt";

		File dirPath = new File(path);

		File[] folders = dirPath.listFiles(File::isDirectory);
		System.out.println("Folders:");
		for (File folder : folders) {
			System.out.println(folder);
		}

		File[] files = dirPath.listFiles(File::isFile);
		System.out.println("Files:");
		for (File file : files) {
			System.out.println(file);
		}

		boolean success = new File(dirPath + "\\subdir").mkdir();
		System.out.println("Directory created successfully: " + success);
	}
}

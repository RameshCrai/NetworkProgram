package Lab;

import java.io.File;
import java.util.Scanner;

public class Exp15_DirectorySearch {
	public static void searchDirectory(File directory, String fileName) {
		File[] fileList = directory.listFiles();

		if (fileList != null) {
			for (File file : fileList) {
				if (file.getName().equalsIgnoreCase(fileName)) {
					System.out.println("Found: " + file.getAbsolutePath());
				}
				if (file.isDirectory()) {
					searchDirectory(file, fileName);
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the directory path: ");
		String directoryPath = scanner.nextLine();

		System.out.print("Enter the file or folder name to search: ");
		String fileName = scanner.nextLine();
		File directory = new File(directoryPath);
		if (directory.exists() && directory.isDirectory()) {
			searchDirectory(directory, fileName);
		} else {
			System.out.println("Invalid directory path.");
		}

		scanner.close();
	}
}

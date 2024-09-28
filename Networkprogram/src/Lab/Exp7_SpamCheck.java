package Lab;

import java.util.Scanner;

public class Exp7_SpamCheck {
	private static final String[] SPAM_KEYWORDS = { "cash", "lottery", "money", };

	public static boolean isSpam(String content) {
		content = content.toLowerCase();
		for (String keyword : SPAM_KEYWORDS) {
			if (content.contains(keyword)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the email content to check for spam:");
		String emailContent = scanner.nextLine();
		if (isSpam(emailContent)) {
			System.out.println("The email content is marked as spam.");
		} else {
			System.out.println("The email content is not spam.");
		}

		scanner.close();
	}
}

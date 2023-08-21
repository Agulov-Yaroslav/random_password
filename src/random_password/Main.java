package random_password;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static String message = "Введите желаемую длину пароля. Целое положительное число. ";

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static void main(String[] args) {

		System.out.println("Сколько паролей нужно сгенерировать? ");

		int numberPasswords = userNum();
		String alphabet = alphabet();

		for (int i = 0; i < numberPasswords; i++) {

			System.out.print(message);

			int userNum = userNum();

			System.out.println("Сгенерированный пароль: " + ANSI_PURPLE + passwort(userNum, alphabet) + ANSI_RESET);
		}
		
		scanner.close();

	}

	public static int userNum() {

		int userNum = 0;
		boolean loop = true;
		while (loop) {
			try {
				userNum = scanner.nextInt();
				if (userNum < 1) {
					System.out.print(message);
				} else
					loop = false;

			} catch (InputMismatchException e) {
				System.out.print(message);
				scanner.next();
			}
		}
		return userNum;
	}

	public static String passwort(int userNum, String alphabet) {

		String passwort = "";

		Random random = new Random();
		char c;
		for (int i = 0; i < userNum; i++) {
			c = alphabet.charAt(random.nextInt(alphabet.length()));
			passwort += c;
		}

		return passwort;
	}

	public static String alphabet() {
		boolean includeLowercase = false;
		boolean includeUppercase = false;
		boolean includeDigits = false;
		boolean includeSpecialChars = false;

		System.out.println("Выберите типы символов для включения:");
		System.out.println("1. Буквы в нижнем регистре");
		System.out.println("2. Буквы в верхнем регистре");
		System.out.println("3. Цифры");
		System.out.println("4. Специальные символы");
		System.out.println("Введите номер(ы) через пробел: ");

		
		String alphabet = "";
		boolean loop = true;
		while (loop) {
			String typesInput = scanner.nextLine();
			if (!typesInput.isEmpty()) {
				String[] selectedTypes = typesInput.split(" ");
				loop = false;
				for (String type : selectedTypes) {
					int typeNumber = Integer.parseInt(type);
					switch (typeNumber) {
					case 1:
						includeLowercase = true;
						break;
					case 2:
						includeUppercase = true;
						break;
					case 3:
						includeDigits = true;
						break;
					case 4:
						includeSpecialChars = true;
						break;
					}
				}
			}
		}

		if (includeLowercase) {
			alphabet += "abcdefghijklmnopqrstuvwxyz";
		}
		if (includeUppercase) {
			alphabet += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		}
		if (includeDigits) {
			alphabet += "0123456789";
		}
		if (includeSpecialChars) {
			alphabet += "!@#$%^&*()-_=+[]{}|;:,.<>?";
		}

		return alphabet;
	}

}

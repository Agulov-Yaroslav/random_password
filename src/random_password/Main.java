package random_password;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static String message = "Введите желаемую длину пароля. Целое положительное число. ";

	public static void main(String[] args) {

		System.out.print(message);

		int userNum = userNum();

		System.out.print("Сгенерированный пароль: " + passwort(userNum));

	}

	public static int userNum() {

		int userNum = 1;
		boolean loop = true;
		while (loop) {
			try {
				userNum = scanner.nextInt();
				if (userNum <= 0) {
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

	public static String passwort(int userNum) {
		String passwort = "";
		String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random r = new Random();
		char c;
		for (int i = 0; i < userNum; i++) {
			c = alphabet.charAt(r.nextInt(alphabet.length()));
			passwort += c;
		}

		return passwort;
	}
}

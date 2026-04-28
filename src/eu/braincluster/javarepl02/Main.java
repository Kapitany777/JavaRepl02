package eu.braincluster.javarepl02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Java Stack program");

		var scanner = new Scanner(System.in);

		while (true) {
			System.out.println("> ");
			String command = scanner.nextLine();

			if ("exit".equalsIgnoreCase(command)) {
				System.out.println("Kilépés");
				break;
			}
			else if ("help".equalsIgnoreCase(command)) {
				printHelp();
			}
			else {
				System.out.println("Hibás parancs! Írd be: help");
			}
		}

		scanner.close();
	}

	private static void printHelp() {
		System.out.println("Elérhető parancsok:");
		System.out.println("- help  : súgó megjelenítése");
		System.out.println("- exit  : kilépés a programból");
		
	}
}

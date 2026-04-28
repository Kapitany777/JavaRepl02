package eu.braincluster.javarepl02;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	private static Map<String, Runnable> commands = new HashMap<>();
	private static boolean running = true;
	
	public static void main(String[] args) {
		System.out.println("Java Stack program");
		
		initCommands();

		var scanner = new Scanner(System.in);

		while (running) {
			System.out.println("> ");
			String command = scanner.nextLine();

			handleCommand(command);
		}

		scanner.close();
	}
	
	private static void initCommands() {
		commands.put("help", () -> printHelp());
		
		commands.put("exit", () -> {
			System.out.println("Kilépés...");
			running = false;
		});
	}
	
	private static void handleCommand(String input) {
		var command = commands.get(input.toLowerCase());
		
		if (command != null) {
			command.run();
		}
		else {
			System.out.println("Hibás parancs!");
		}
	}

	private static void printHelp() {
		System.out.println("Elérhető parancsok:");
		System.out.println("- help  : súgó megjelenítése");
		System.out.println("- exit  : kilépés a programból");
		
	}
}

package eu.braincluster.javarepl02;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {

	private static Map<String, Consumer<String>> commands = new HashMap<>();
	private static boolean running = true;

	private static MyStack<String> stack = new MyStack<>();

	public static void main(String[] args) {
		System.out.println("Java Stack program");
		System.out.println("Készítők: Kapitány & ChatGPT");

		initCommands();

		var scanner = new Scanner(System.in);

		while (running) {
			System.out.println("> ");
			String input = scanner.nextLine().trim();

			if (input.isEmpty()) {
				continue;
			}

			handleCommand(input);
		}

		scanner.close();
	}

	private static void initCommands() {
		commands.put("help", args -> printHelp());

		Consumer<String> exitCommand = args -> {
			System.out.println("Kilépés...");
			running = false;
		};

		commands.put("exit", exitCommand);
		commands.put("quit", exitCommand);

		commands.put("pop", args -> {
			System.out.println(stack.pop());
		});

		commands.put("peek", args -> {
			System.out.println(stack.peek());
		});

		commands.put("size", args -> {
			System.out.println(stack.size());
		});

		commands.put("clear", args -> {
			stack.clear();
			System.out.println("Stack törölve.");
		});

		commands.put("print", args -> {
			System.out.println(stack);
		});

		commands.put("push", args -> {
			if (args == null || args.trim().isEmpty()) {
				System.out.println("Használat: push <érték>");
				return;
			}

			String value = args.trim();
			stack.push(value);
			System.out.println("Hozzáadva: " + value);
		});
	}

	private static void handleCommand(String input) {
		try {
			var parts = input.split(" ", 2);

			String commandName = parts[0].toLowerCase();
			String args = parts.length > 1 ? parts[1] : "";

			var command = commands.get(commandName);

			if (command != null) {
				command.accept(args);
			}
			else {
				System.out.println("Hibás parancs!");
			}
		}
		catch (IllegalStateException e) {
			System.out.println("⚠ " + e.getMessage());
		}
	}

	private static void printHelp() {
		System.out.println("Elérhető parancsok:");
		System.out.println("- help        : súgó megjelenítése");
		System.out.println("- exit, quit  : kilépés a programból");
		System.out.println("- pop         : felső elem kivétele");
		System.out.println("- peek        : felső elem megtekintése");
		System.out.println("- size        : stack mérete");
		System.out.println("- clear       : stack törlése");
		System.out.println("- print       : stack kiírása");
		System.out.println("- push <érték>: elem hozzáadása");
	}
}

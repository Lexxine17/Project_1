package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) {
        printText();

        ArrayList<String> tasks = new ArrayList<>();
       while (true) {
           chooseOption(tasks);
       }
//        listTasks(tasks);
//        removeTask(tasks);
//        listTasks(tasks);
    }

    public static void printText() {
        String firstMessage = "Please select an option:";
        String[] options = {"1. add", "2. remove", "3. list", "4. exit"};

        System.out.println(ConsoleColors.BLUE + firstMessage + ConsoleColors.RESET);

        for (String option : options) {
            System.out.println(option);
        }
    }

    public static List<String> downloadFromFile() throws IOException {
        Path path = Paths.get("tasks2.csv");
        if (!Files.exists(path)) {
            Files.createFile(path);
        }
        List<String> lines = Files.readAllLines(path);
        return lines;
    }

    public static void chooseOption(ArrayList<String> tasks) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select an option (type ether number or name of the option). Type 0 or 'back' to go back to the main menu:");
        String option = scanner.nextLine().toLowerCase();
        switch (option) {
            case "0": case "back":
                printText();
                break;
            case "1":
            case "add":
                addTask(tasks);
                break;
            case "2":
            case "remove":
                removeTask(tasks);
                break;
            case "3":
            case "list":
                listTasks(tasks);
                break;
            case "4":
            case "exit":
                exit(tasks);
                break;
            default:
                System.out.println("Invalid option selected.");
        }
    }

    public static ArrayList<String> addTask(ArrayList<String> tasks) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please add task description:");
            String task = scanner.nextLine();
            System.out.println("Please add task due date: (format: YYYY-MM-DD)");
            String dueDate = scanner.nextLine();
            System.out.println("Is your task important: true/false");
            String isImportant = scanner.nextLine();
            tasks.add(task + " " + dueDate + " " + isImportant);
            System.out.println("Do you want to add another task? (type yes/no)");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("no")) {
                break;
            }
        }
        return tasks;
    }

    public static void listTasks(ArrayList<String> tasks) {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + " : " + tasks.get(i));
        }
    }

    public static void removeTask(ArrayList<String> tasks) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select number to remove.");
        while (true) {
            try {
                int taskNumber = getNumber(scanner);
                if (taskNumber >= 1) {
                    tasks.remove(taskNumber - 1);
                    break;
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Incorect argument passed. Please give number grater than 0 and less or equal to " + tasks.size());
            }
        }
    }

    public static int getNumber(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println("Incorect input.Please type a number.");
        }
        return scanner.nextInt();
    }

    public static void exit(ArrayList<String> tasks) {
        Path path = Paths.get("tasks2.csv");
        try {
            Files.write(path, tasks);
        } catch (IOException e) {
            System.out.println("Error occured during data saving");
        }
        System.out.println(ConsoleColors.RED + "Bye, bye.");
        System.exit(0);
    }
}

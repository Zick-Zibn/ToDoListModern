package org.toDoListModern.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.toDoListModern.app.command.CommandHandler;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TaskApp {

    private final Map<Integer, CommandHandler> commandHandlers;

    @Autowired
    public TaskApp(List<CommandHandler> commandHandlers) {
        this.commandHandlers = commandHandlers.stream()
                .collect(
                        Collectors.toMap(
                                CommandHandler::getKey,
                                handler -> handler
                        )
                );
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать в TaskApp!");

        do {
            printMenu();
            int numMenuChoice = scanner.nextInt();
            if (numMenuChoice == 0) {
                System.out.println("Выход из приложения. До свидания!");
                return;
            }
            if (!commandHandlers.containsKey(numMenuChoice)) {
                System.out.println("Нет команды с таким кодом");
                continue;
            }
            commandHandlers.get(numMenuChoice).handle();
            System.out.println();
        } while (true);
    }

    private void printMenu() {
        System.out.println("Выберите действие:");
        commandHandlers.values()
                .forEach(handler ->
                        System.out.printf("%d - %s%n", handler.getKey(), handler.getDescription())
                );
        System.out.println("0 - Выйти");
    }
}

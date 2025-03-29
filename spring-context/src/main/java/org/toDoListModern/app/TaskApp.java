package org.toDoListModern.app;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

public class TaskApp {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private TaskPrinter taskPrinter;

    public void run() {

        Scanner scanner = new Scanner(System.in);
        int numMenuChoice = 0;

        System.out.println("Добро пожаловать в TaskApp!");

        do {
            this.printMenu();

            numMenuChoice = scanner.nextInt();
            switch (numMenuChoice) {
                case 1:
                    System.out.println("Ваш выбор: 1");
                    System.out.print("Введите описание задачи: ");
                    String taskName = scanner.next();
                    taskRepository.addTask(taskName);
                    System.out.printf("Задача добавлена с ID = %s \n", taskRepository.getIdTask());
                    this.printEmptyLine();
                    break;
                case 2:
                    System.out.println("Ваш выбор: 2");
                    System.out.println("Список задач:");
                    taskPrinter.printTasks(taskRepository.getTasksList());
                    this.printEmptyLine();
                    break;
                case 3:
                    System.out.print("Введите ID задачи для удаления: ");
                    int idTask = scanner.nextInt();
                    taskRepository.removeTask(idTask);
                    this.printEmptyLine();
                    break;
                case 0:
                    System.out.println("Выход из приложения. До свидания!");
                    break;
            }

        } while (numMenuChoice != 0);
    }

    private void printMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 - Добавить задачу");
        System.out.println("2 - Показать все задачи");
        System.out.println("3 - Удалить задачу");
        System.out.println("0 - Выйти");
    }
    private void printEmptyLine() {
        System.out.println();
    }
}

package org.toDoListModern.app.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.toDoListModern.app.TaskRepository;

import java.util.Scanner;

@Component
public class CreateTaskCommandHandler implements CommandHandler {

    public final Scanner scanner;
    public final TaskRepository taskRepository;

    @Autowired
    public CreateTaskCommandHandler(Scanner scanner, TaskRepository taskRepository) {
        this.scanner = scanner;
        this.taskRepository = taskRepository;
    }

    @Override
    public int getKey() {
        return 1;
    }

    @Override
    public String getDescription() {
        return "Создать команду";
    }

    @Override
    public void handle() {
        System.out.println("Ваш выбор: 1");
        System.out.print("Введите описание задачи: ");
        String taskName = scanner.next();
        taskRepository.addTask(taskName);
        System.out.printf("Задача добавлена с ID = %s \n", taskRepository.getIdTask());
    }
}

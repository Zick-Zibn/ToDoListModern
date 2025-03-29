package org.toDoListModern.app.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.toDoListModern.app.TaskRepository;

import java.util.Scanner;

@Component
public class RemoveTaskCommandHandler implements CommandHandler {

    public final Scanner scanner;
    public final TaskRepository taskRepository;

    @Autowired
    public RemoveTaskCommandHandler(Scanner scanner, TaskRepository taskRepository) {
        this.scanner = scanner;
        this.taskRepository = taskRepository;
    }

    @Override
    public int getKey() {
        return 2;
    }

    @Override
    public String getDescription() {
        return "Удалить команду";
    }

    @Override
    public void handle() {
        System.out.print("Введите ID задачи для удаления: ");
        int idTask = scanner.nextInt();
        taskRepository.removeTask(idTask);
    }
}

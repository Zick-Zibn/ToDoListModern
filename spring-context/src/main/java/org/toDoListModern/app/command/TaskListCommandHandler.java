package org.toDoListModern.app.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.toDoListModern.app.TaskPrinter;
import org.toDoListModern.app.TaskRepository;

@Component
public class TaskListCommandHandler implements CommandHandler {

    public final TaskRepository taskRepository;

    public final TaskPrinter taskPrinter;

    @Autowired
    public TaskListCommandHandler(TaskRepository taskRepository, TaskPrinter taskPrinter) {
        this.taskRepository = taskRepository;
        this.taskPrinter = taskPrinter;
    }

    @Override
    public int getKey() {
        return 3;
    }

    @Override
    public String getDescription() {
        return "Показать список команд";
    }

    @Override
    public void handle() {
        System.out.println("Ваш выбор: 2");
        System.out.println("Список задач:");
        taskPrinter.printTasks(taskRepository.getTasksList());
    }
}

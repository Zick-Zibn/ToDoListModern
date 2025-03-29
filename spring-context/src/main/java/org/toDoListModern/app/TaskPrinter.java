package org.toDoListModern.app;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskPrinter {

    public void printTasks(List<Task> taskList) {
        for (Task task : taskList) {
            System.out.printf("[%1s] %2s \n", task.getIdTask(), task.getNameTask());
        }
    }
}

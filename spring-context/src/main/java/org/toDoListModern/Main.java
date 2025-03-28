package org.toDoListModern;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.toDoListModern.app.TaskApp;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        TaskApp taskApp = context.getBean(TaskApp.class);
        taskApp.run();

        }
    }
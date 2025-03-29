package org.toDoListModern;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.toDoListModern.app.TaskApp;
import org.toDoListModern.app.command.CommandHandler;

import java.util.List;
import java.util.Scanner;

@ComponentScan(basePackages = "org.toDoListModern.app")
@Configuration
public class AppConfig {

    @Bean
    Scanner scanner() {
        return new Scanner(System.in);
    }

    @Bean
    TaskApp taskApp(List<CommandHandler> commandHandlers) {
        return new TaskApp(commandHandlers);
    }
}

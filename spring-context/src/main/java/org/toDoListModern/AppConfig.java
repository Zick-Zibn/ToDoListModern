package org.toDoListModern;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.toDoListModern.app.TaskApp;

@ComponentScan(basePackages = "org.toDoListModern.app")
@Configuration
public class AppConfig {

    @Bean
    TaskApp taskApp() {
        return new TaskApp();
    }
}

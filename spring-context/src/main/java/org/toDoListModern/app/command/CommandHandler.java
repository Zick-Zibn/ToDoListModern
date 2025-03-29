package org.toDoListModern.app.command;

public interface CommandHandler {

    int getKey();

    String getDescription();

    void handle();
}

package com.todo.todoApp.Exceptions;

//Purpose: Used when there is a conflict in the request (e.g., trying to create a resource that already exists).
//HTTP Status: 409 ConflictException
public class ConflictException extends RuntimeException {
    public ConflictException(String message) {
        super(message);
    }
}

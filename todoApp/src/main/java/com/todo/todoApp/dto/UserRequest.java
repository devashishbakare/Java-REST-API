package com.todo.todoApp.dto;

import java.util.*;
import com.todo.todoApp.Entity.Book;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public class UserRequest {
    @Size(min = 3, max = 30, message = "Length of the name should be within the range")
    private String userName;

    @NotBlank(message = "Email is required")
    @Email(message = "email must be valid")
    private String email;

    @NotEmpty(message = "Can't be empty")
    @Size(min = 1, message = "At least one element should be there")
    private List<Integer> selections;

    @NotNull(message = "Object should not be null")
    private @Valid Book book;

    public UserRequest(String userName, String email, List<Integer> selections, Book book) {
        this.userName = userName;
        this.email = email;
        this.selections = selections;
        this.book = book;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
    //if there is object we can check @NotNull(message : "can't be null"

}

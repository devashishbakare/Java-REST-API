package com.todo.todoApp.controller;
import java.util.*;
import com.todo.todoApp.Entity.Book;
import com.todo.todoApp.Exceptions.GenericException;
import com.todo.todoApp.Exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/book")
public class BookController {
    Map<Integer, Book> bookMapper = new HashMap<>();
    @PostMapping("/add")
    public ResponseEntity<Map<String, Object>> createBook(@RequestBody Book book){

        Map<String, Object> response = new HashMap<>();
        if(bookMapper.containsKey(book.getBookId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "bookId should be unique");
        }
        bookMapper.put(book.getBookId(), book);
        response.put("data", book);
        response.put("message", "Book has been added");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @GetMapping("/get/{bookId}")
    public ResponseEntity<Map<String, Object>> getBookByBookId(@PathVariable int bookId){

        Map<String, Object> response = new HashMap<>();
        if(bookMapper.containsKey(bookId) == false){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "bookId not found");
        }
        response.put("data", bookMapper.get(bookId));
        response.put("Message", "Here is you book");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @PatchMapping("/update")
    public ResponseEntity<Map<String, Object>> updateBookTitle(@RequestParam int bookId, @RequestParam String newTittle){

        Map<String, Object> response = new HashMap<>();
        if(bookMapper.containsKey(bookId) == false) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "bookId not found");
        }
        Book book = bookMapper.get(bookId);
        book.setTitle(newTittle);

        response.put("data", book);
        response.put("message", "book has been updated successfully");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/delete/{bookId}")
    public ResponseEntity<Map<String, Object>> deleteBook(@PathVariable  int bookId){
        Map<String, Object> response = new HashMap<>();
        if(bookMapper.containsKey(bookId) == false){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "bookId should be unique");
        }
        Book removeBook = bookMapper.remove(bookId);
        response.put("data", removeBook);
        response.put("mesage", "Book has been removed successfully");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}

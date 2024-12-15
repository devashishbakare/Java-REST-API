package com.todo.todoApp.controller;
import java.util.*;
import com.todo.todoApp.Entity.Todo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")
public class TodoController {
    private Map<Integer, Todo> todoMapper = new HashMap<>();
    @PostMapping("/add")
    public Todo addTodo(@RequestBody Todo todo){
        todoMapper.put(todo.getId(), todo);
        return todo;
    }

    @GetMapping("/getAll")
    public List<Todo> getTodo(){
        return new ArrayList<>(todoMapper.values());
    }

    @GetMapping("/fetch/{id}")
    public Todo getTodoById(@PathVariable("id") int id){
        if(todoMapper.containsKey(id) == false) return null;
        System.out.println(id);
        return todoMapper.get(id);
    }

    @GetMapping("checkTodo")
    public Todo getTrueTodo(@RequestParam int id, @RequestParam boolean status){
        Todo todo = todoMapper.get(id);
        if(todo.isStatus() == status){
            return todo;
        }

        return null;
    }

    @DeleteMapping("/delete/{id}")
    public Todo deleteTodo(@PathVariable("id") int id){
        return todoMapper.remove(id);
    }
}

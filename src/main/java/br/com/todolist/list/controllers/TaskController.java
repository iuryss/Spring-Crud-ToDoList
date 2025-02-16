package br.com.todolist.list.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.todolist.list.DTOs.NewTaskDTO;
import br.com.todolist.list.model.Task;
import br.com.todolist.list.service.TaskService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    @Autowired
    private final TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(){
        return ResponseEntity.status(201).body(taskService.getAllTasks());
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<Task> getTaskById(@PathVariable String taskId){
        return ResponseEntity.status(201).body(taskService.getTaskById(taskId));  
    }


    @PostMapping("/new")
    public ResponseEntity<Task> createTask(@RequestBody NewTaskDTO newTaskDTO){
        Task task = taskService.createTask(newTaskDTO); // Captura a tarefa criada
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }
    
    @PutMapping("/update/{taskId}")
    public ResponseEntity<Task> updateTask(@RequestBody NewTaskDTO newTaskDTO, @PathVariable String taskId){
        return ResponseEntity.status(201).body(taskService.updateTask(taskId, newTaskDTO));
    }

    @DeleteMapping("/delete/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable String taskId){
        taskService.deleteTask(taskId);
        return ResponseEntity.noContent().build();
    }
}

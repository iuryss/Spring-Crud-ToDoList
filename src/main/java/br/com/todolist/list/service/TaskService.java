package br.com.todolist.list.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.todolist.list.DTOs.NewTaskDTO;
import br.com.todolist.list.model.Task;
import br.com.todolist.list.repository.TaskRepository;
import java.util.List;

@Service
public class TaskService{

    @Autowired
    private TaskRepository taskRepository;

   public Task createTask(NewTaskDTO newTaskDTO){
        Task task = new Task(newTaskDTO);
        saveTask(task);

        return task;
   }

   private void saveTask(Task task){
        taskRepository.save(task);
   }

   public List<Task> getAllTasks(){
        return taskRepository.findAll();
   }

   public Task getTaskById(String taskId){
        return taskRepository.findById(taskId)
            .orElseThrow(() -> new RuntimeException("Task não encontrada"));
   }


   public Task updateTask(String taskId, NewTaskDTO newTaskDTO){
        Task task = taskRepository.findById(taskId)
                    .orElseThrow(() -> new RuntimeException("Task não encontrada"));
        
        task.setTitle(newTaskDTO.title());
        task.setDescription(newTaskDTO.description());
        task.setLimitDate(newTaskDTO.limitDate());

        return taskRepository.save(task);

    }

    public void deleteTask(String taskId){
        Task task = taskRepository.findById(taskId)
                    .orElseThrow(() -> new RuntimeException("Task não encontrada"));

        taskRepository.delete(task);
    }
}
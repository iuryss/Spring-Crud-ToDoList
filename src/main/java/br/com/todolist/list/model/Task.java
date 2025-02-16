package br.com.todolist.list.model;

import java.time.LocalDateTime;

import br.com.todolist.list.DTOs.NewTaskDTO;
import br.com.todolist.list.model.Enum.TaskStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Table(name = "tasks")
@Getter
@Setter
public class Task {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id_task;

    private String title;

    private String description;

    private LocalDateTime limitDate;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    public Task(NewTaskDTO newTaskDTO){
        this.title = newTaskDTO.title();
        this.description = newTaskDTO.description();
        this.limitDate = newTaskDTO.limitDate();
        this.status = TaskStatus.PENDING;
    }
}

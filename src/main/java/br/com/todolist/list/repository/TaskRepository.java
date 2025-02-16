package br.com.todolist.list.repository;

import br.com.todolist.list.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, String>{
    
}

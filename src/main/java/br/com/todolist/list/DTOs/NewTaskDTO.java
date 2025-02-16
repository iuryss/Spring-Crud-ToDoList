package br.com.todolist.list.DTOs;

import java.time.LocalDateTime;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record NewTaskDTO(
    @NotBlank String title,
    @NotBlank String description,
    @NotNull LocalDateTime limitDate
) {} 
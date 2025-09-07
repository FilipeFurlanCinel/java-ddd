package com.example.tasks.presentation.mapper;

import com.example.tasks.domain.model.Author;
import com.example.tasks.domain.model.Task;
import com.example.tasks.presentation.contracts.AuthorResponse;
import com.example.tasks.presentation.contracts.TaskResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContractMapper {
    default AuthorResponse toAuthorResponse(Author author) {
        return new AuthorResponse(author.getId(), author.getName());
    }

    default TaskResponse toTaskResponse(Task task) {
        return new TaskResponse(task.getId(), task.getName(), task.getDueDate(), toAuthorResponse(task.getAuthor()));
    }
} 
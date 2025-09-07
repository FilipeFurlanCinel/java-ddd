package com.example.tasks.infrastructure.persistence.repository;

import com.example.tasks.infrastructure.persistence.entity.TaskJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
 
public interface TaskJpaRepository extends JpaRepository<TaskJpaEntity, Long> {
} 
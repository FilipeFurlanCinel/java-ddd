package com.example.tasks.infrastructure.persistence.repository;

import com.example.tasks.infrastructure.persistence.entity.AuthorJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
 
public interface AuthorJpaRepository extends JpaRepository<AuthorJpaEntity, Long> {
} 
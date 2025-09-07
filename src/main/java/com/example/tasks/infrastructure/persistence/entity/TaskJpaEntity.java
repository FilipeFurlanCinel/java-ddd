package com.example.tasks.infrastructure.persistence.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tasks")
public class TaskJpaEntity extends AuditableJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "due_date", nullable = false)
    private LocalDate dueDate;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private AuthorJpaEntity author;

    public TaskJpaEntity() {
    }

    public TaskJpaEntity(Long id, String name, LocalDate dueDate, AuthorJpaEntity author) {
        this.id = id;
        this.name = name;
        this.dueDate = dueDate;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public AuthorJpaEntity getAuthor() {
        return author;
    }

    public void setAuthor(AuthorJpaEntity author) {
        this.author = author;
    }
} 
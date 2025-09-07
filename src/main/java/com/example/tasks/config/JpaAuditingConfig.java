package com.example.tasks.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Global configuration enabling JPA auditing (createdAt / updatedAt timestamps).
 * Placed in the dedicated config package to keep infrastructure concerns
 * separated from the domain and application layers in a DDD project.
 */
@Configuration
@EnableJpaAuditing
public class JpaAuditingConfig {
} 
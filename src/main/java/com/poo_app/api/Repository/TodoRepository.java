package com.poo_app.api.Repository;

import com.poo_app.api.Models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Task, Long> {
}

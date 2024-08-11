package com.sirma.TaskManager.repositories;

import com.sirma.TaskManager.models.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> { }

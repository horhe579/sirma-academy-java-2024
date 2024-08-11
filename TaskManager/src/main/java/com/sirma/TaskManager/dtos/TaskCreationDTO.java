package com.sirma.TaskManager.dtos;


import com.sirma.TaskManager.enums.Status;
import jakarta.persistence.*;

import java.time.LocalDate;

public class TaskCreationDTO{

    private String title;
    private String description;
    private boolean status;
    private LocalDate dueDate;

    private TaskCreationDTO() {}

    public TaskCreationDTO(String title, String description, boolean status, LocalDate dueDate) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.dueDate = dueDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}

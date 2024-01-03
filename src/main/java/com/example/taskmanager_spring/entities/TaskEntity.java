package com.example.taskmanager_spring.entities;


import lombok.*;

import java.util.Date;
import java.util.List;


@Data
public class TaskEntity {

    private int id;
    private String title;
    private String description;
    private Date deadLine;
    private boolean Completed;

}

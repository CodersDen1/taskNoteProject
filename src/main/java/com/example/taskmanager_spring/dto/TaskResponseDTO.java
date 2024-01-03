package com.example.taskmanager_spring.dto;

import com.example.taskmanager_spring.entities.NoteEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class TaskResponseDTO {
    private int id;
    private String title;
    private String description;
    private Date deadLine;
    private boolean Completed;
    private List<NoteEntity> notes;
}

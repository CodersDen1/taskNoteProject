package com.example.taskmanager_spring.controllers;

import com.example.taskmanager_spring.dto.CreateNoteDTO;
import com.example.taskmanager_spring.dto.CreateNoteResponseDTO;
import com.example.taskmanager_spring.entities.NoteEntity;
import com.example.taskmanager_spring.services.NoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks/{taskId}/notes")
public class NoteController {

    private NoteService notesService;

    public NoteController(NoteService notesService){
        this.notesService=notesService;
    }

    @GetMapping("")
    public ResponseEntity<List<NoteEntity>> getNotes(@PathVariable("taskId") Integer taskId){
        var notes= notesService.getNotesForTask(taskId);
        return ResponseEntity.ok(notes);
    }
    @PostMapping("")
    public ResponseEntity<CreateNoteResponseDTO> addNote(@PathVariable("taskId") Integer taskId,
                                                         @RequestBody CreateNoteDTO body
    ){
        var note = notesService.addNoteForTask(taskId,body.getTitle(), body.getBody());

        return ResponseEntity.ok(new CreateNoteResponseDTO(taskId, note));
    }

}

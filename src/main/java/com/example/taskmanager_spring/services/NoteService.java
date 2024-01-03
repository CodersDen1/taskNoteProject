package com.example.taskmanager_spring.services;

import com.example.taskmanager_spring.entities.NoteEntity;
import com.example.taskmanager_spring.entities.TaskEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class NoteService {
    private TaskService taskService;
    private HashMap<Integer , TaskNotesHolder> taskNoteHolder = new HashMap<>();

    public  NoteService(TaskService taskService){
        this.taskService=taskService;
    }
    class TaskNotesHolder{
       protected int noteId=1;
       protected ArrayList<NoteEntity> notes = new ArrayList<>();
    }
    public List<NoteEntity> getNotesForTask(int taskId){
        TaskEntity task = taskService.getTaskById(taskId);

        if(task==null){
            return null;
        }
        if(taskNoteHolder.get(taskId)==null){
            taskNoteHolder.put(taskId , new TaskNotesHolder());
        }
        return  taskNoteHolder.get(taskId).notes;
    }

    public NoteEntity addNoteForTask(int taskId , String title , String body){
        TaskEntity task = taskService.getTaskById(taskId);
        if(task==null){
            return null;
        }
        if(taskNoteHolder.get(taskId)==null){
            taskNoteHolder.put(taskId, new TaskNotesHolder());
        }
        TaskNotesHolder taskNotesHolder = taskNoteHolder.get(taskId);
        NoteEntity note = new NoteEntity();
        note.setId(taskNotesHolder.noteId);
        note.setTitle(title);
        note.setBody(body);
        taskNotesHolder.notes.add(note);
        taskNotesHolder.noteId++;
        return  note;
    }


}

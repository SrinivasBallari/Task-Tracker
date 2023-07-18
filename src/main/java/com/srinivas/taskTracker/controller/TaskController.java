package com.srinivas.taskTracker.controller;

import com.srinivas.taskTracker.payload.TaskDTO;
import com.srinivas.taskTracker.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;

@RestController
@RequestMapping("/api")
public class TaskController {
    @Autowired
    private TaskService taskService;

    // save the given task for a user
    @PostMapping("/{userID}/tasks")
    public ResponseEntity<TaskDTO> saveTask(@PathVariable(name="userID") int userID, @RequestBody TaskDTO taskDTO){
        return new ResponseEntity<>(taskService.saveTask(userID,taskDTO), HttpStatus.CREATED);
    }

    // delete a given task for a user

    // fetch all tasks of a user

    // fetch a particular task of a user
}

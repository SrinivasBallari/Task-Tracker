package com.srinivas.taskTracker.controller;

import com.srinivas.taskTracker.payload.TaskDTO;
import com.srinivas.taskTracker.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.List;

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
    @GetMapping("/{userID}/tasks")
    public ResponseEntity<List<TaskDTO>> fetchAllTasksOfUser(@PathVariable(name = "userID")int userID){
        return new ResponseEntity<>(taskService.fetchAllTasksOfUser(userID),HttpStatus.FOUND);
    }

    // fetch a particular task of a user
    @GetMapping("/{userId}/tasks/{taskId}")
    public ResponseEntity<TaskDTO> fetchParticularTaskOfUserByTaskId(
            @PathVariable(name = "userId") int userId,
            @PathVariable(name = "taskId") int taskId){

        return new ResponseEntity<>(taskService.fetchParticularTaskOfUser(userId,taskId),HttpStatus.FOUND);
    }

    @DeleteMapping("/{userId}/tasks/{taskId}")
    public ResponseEntity<String> deleteParticularTaskOfUser(
            @PathVariable(name = "userId") int userId,
            @PathVariable(name = "taskId") int taskId){

        taskService.deleteParticularTaskOfUser(userId,taskId);
        return new ResponseEntity<>("Task with id: "+taskId+" for the userId: "+userId+" deleted successfully.",
                HttpStatus.OK);
    }

}

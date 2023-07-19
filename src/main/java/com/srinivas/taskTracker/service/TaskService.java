package com.srinivas.taskTracker.service;

import com.srinivas.taskTracker.payload.TaskDTO;

import java.util.List;

public interface TaskService {
    public TaskDTO saveTask(int userId, TaskDTO taskDTO);

    public List<TaskDTO> fetchAllTasksOfUser(int userId);

    public TaskDTO fetchParticularTaskOfUser(int userId, int taskId);

    public void deleteParticularTaskOfUser(int userId,int taskId);
}

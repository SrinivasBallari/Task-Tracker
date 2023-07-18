package com.srinivas.taskTracker.service;

import com.srinivas.taskTracker.payload.TaskDTO;

import java.util.List;

public interface TaskService {
    public TaskDTO saveTask(int userId, TaskDTO taskDTO);

    public List<TaskDTO> fetchAllTasks(Integer userId);
}

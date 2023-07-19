package com.srinivas.taskTracker.serviceImplementation;

import com.srinivas.taskTracker.entity.Tasks;
import com.srinivas.taskTracker.entity.Users;
import com.srinivas.taskTracker.exceptions.InvalidApiCall;
import com.srinivas.taskTracker.exceptions.TaskNotFound;
import com.srinivas.taskTracker.exceptions.UserNotFound;
import com.srinivas.taskTracker.payload.TaskDTO;
import com.srinivas.taskTracker.repos.TaskRepo;
import com.srinivas.taskTracker.repos.UserRepo;
import com.srinivas.taskTracker.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImplementation implements TaskService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TaskRepo taskRepo;

    @Override
    public TaskDTO saveTask(int userId, TaskDTO taskDTO) {
            Users user = userRepo.findById(userId).orElseThrow(
                    () -> new UserNotFound(String.format("User with id: %d not found" ,userId))
            );
            Tasks task = modelMapper.map(taskDTO,Tasks.class);
            //set user_id for a particular task in the task table by saving the user to that particular task.
            task.setUsers(user);
            // save the task in the DB.
            Tasks savedTask = taskRepo.save(task);
            return modelMapper.map(savedTask,TaskDTO.class);
    }

    @Override
    public List<TaskDTO> fetchAllTasksOfUser(int userId) {
        userRepo.findById(userId).orElseThrow(
                () -> new UserNotFound(String.format("User with id: %d not found" ,userId))
        );

        List<Tasks>tasksListOfUser = taskRepo.findAllByUsersId(userId);

        return tasksListOfUser.stream().map(
                tasks -> modelMapper.map(tasks,TaskDTO.class)
        ).collect(Collectors.toList());

    }

    @Override
    public TaskDTO fetchParticularTaskOfUser(int userId, int taskId) {
        Users user = userRepo.findById(userId).orElseThrow(
                () -> new UserNotFound(String.format("User with id: %d not found" ,userId))
        );

        Tasks task = taskRepo.findById(taskId).orElseThrow(
                () -> new TaskNotFound(String.format("Task with id: %d not found" ,taskId))
        );

        if(user.getId() != task.getUsers().getId()){
            throw new InvalidApiCall("Task with taskId : "+ taskId + " does not belong to the userId : "+ userId);
        }
        return modelMapper.map(task,TaskDTO.class);
    }

    @Override
    public void deleteParticularTaskOfUser(int userId, int taskId) {
        Users user = userRepo.findById(userId).orElseThrow(
                () -> new UserNotFound(String.format("User with id: %d not found" ,userId))
        );

        Tasks task = taskRepo.findById(taskId).orElseThrow(
                () -> new TaskNotFound(String.format("Task with id: %d not found" ,taskId))
        );

        if(user.getId() != task.getUsers().getId()){
            throw new InvalidApiCall("Task with taskId : "+ taskId + " does not belong to the userId : "+ userId);
        }

        taskRepo.deleteById(taskId);
    }
}

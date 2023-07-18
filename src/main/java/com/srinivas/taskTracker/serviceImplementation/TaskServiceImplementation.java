package com.srinivas.taskTracker.serviceImplementation;

import com.srinivas.taskTracker.entity.Tasks;
import com.srinivas.taskTracker.entity.Users;
import com.srinivas.taskTracker.payload.TaskDTO;
import com.srinivas.taskTracker.repos.TaskRepo;
import com.srinivas.taskTracker.repos.UserRepo;
import com.srinivas.taskTracker.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        try{
            Users user = userRepo.findById(userId).get();
            Tasks task = modelMapper.map(taskDTO,Tasks.class);
            //set user_id for a particular task in the task table by saving the user to that particular task.
            task.setUsers(user);
            // save the task in the DB.
            Tasks savedTask = taskRepo.save(task);
            return modelMapper.map(savedTask,TaskDTO.class);
        }catch (Exception e){
            System.out.println("Error in implementation");
            System.out.println(e);
        }

        return taskDTO;
    }

    @Override
    public List<TaskDTO> fetchAllTasks(Integer userId) {
        return null;
    }
}

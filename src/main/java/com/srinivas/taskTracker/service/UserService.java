package com.srinivas.taskTracker.service;

import com.srinivas.taskTracker.payload.UserDTO;
import org.apache.catalina.User;

public interface UserService{
    public UserDTO createUser(UserDTO userdto);
}

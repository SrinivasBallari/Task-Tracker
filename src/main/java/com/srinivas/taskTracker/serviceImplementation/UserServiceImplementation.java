package com.srinivas.taskTracker.serviceImplementation;

import com.srinivas.taskTracker.entity.Users;
import com.srinivas.taskTracker.payload.UserDTO;
import com.srinivas.taskTracker.repos.UserRepo;
import com.srinivas.taskTracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.annotation.Retention;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    UserRepo userRepo;
    @Override
    public UserDTO createUser(UserDTO userdto) {
        //before saving ,typecast the userdto object to Users entity object.
        Users userObj = convertUserDTOToUsers(userdto);
        Users savedUser = userRepo.save(userObj);
        return convertUsersToUserDTO(savedUser);
    }

    private Users convertUserDTOToUsers(UserDTO userDTO){
        Users users = new Users();
        users.setEmail(userDTO.getEmail());
        users.setName(userDTO.getName());
        users.setPassword(userDTO.getPassword());

        return users;
    }

    private UserDTO convertUsersToUserDTO(Users savedUser){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(savedUser.getId());
        userDTO.setEmail(savedUser.getEmail());
        userDTO.setName(savedUser.getName());
        userDTO.setPassword(savedUser.getPassword());

        return userDTO;
    }
}

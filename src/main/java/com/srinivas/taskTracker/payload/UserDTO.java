package com.srinivas.taskTracker.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserDTO {
    private int id;
    private String name;
    private String email;
    private String password;

}

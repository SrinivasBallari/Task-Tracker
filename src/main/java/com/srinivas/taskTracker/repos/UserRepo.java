package com.srinivas.taskTracker.repos;

import com.srinivas.taskTracker.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users,Integer> {
}

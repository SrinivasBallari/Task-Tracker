package com.srinivas.taskTracker.repos;

import com.srinivas.taskTracker.entity.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepo extends JpaRepository<Tasks,Integer> {
    List<Tasks> findAllByUsersId(int userId);
}

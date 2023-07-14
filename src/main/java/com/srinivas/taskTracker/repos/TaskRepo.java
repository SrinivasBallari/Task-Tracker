package com.srinivas.taskTracker.repos;

import com.srinivas.taskTracker.entity.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Tasks,Integer> {
}

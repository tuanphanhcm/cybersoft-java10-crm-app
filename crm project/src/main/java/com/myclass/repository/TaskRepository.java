package com.myclass.repository;

import java.util.List;

import com.myclass.entity.Task;

public interface TaskRepository {
	
	List<Task> findAll();
	void deleteByProjectId(int projectId);
}

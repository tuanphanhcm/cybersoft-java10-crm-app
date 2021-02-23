package com.myclass.service;

import java.util.List;

import com.myclass.dto.TaskDTO;

public interface TaskService {
	
	List<TaskDTO> findAll();
	
}

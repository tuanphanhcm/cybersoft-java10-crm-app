package com.myclass.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.myclass.dto.TaskDTO;
import com.myclass.entity.Task;
import com.myclass.repository.ProjectRepository;
import com.myclass.repository.StatusRepository;
import com.myclass.repository.TaskRepository;
import com.myclass.repository.UserRepository;
import com.myclass.repository.impl.ProjectRepositoryImpl;
import com.myclass.repository.impl.StatusRepositoryImpl;
import com.myclass.repository.impl.TaskRepositoryImpl;
import com.myclass.repository.impl.UserRepositoryImpl;
import com.myclass.service.TaskService;
import com.myclass.util.Mapper;

public class TaskServiceImpl implements TaskService {
	
	private TaskRepository repository;
	private UserRepository userRepository;
	private ProjectRepository projectRepository;
	private StatusRepository statusRepository;
	
	public TaskServiceImpl() {
		repository = new TaskRepositoryImpl();
		userRepository = new UserRepositoryImpl();
		projectRepository = new ProjectRepositoryImpl();
		statusRepository = new StatusRepositoryImpl();
	}
	
	@Override
	public List<TaskDTO> findAll() {
		List<TaskDTO> tasks = new ArrayList<>();
		for(Task entity : repository.findAll()) {
			TaskDTO task = Mapper.convertToDTO(entity, TaskDTO.class);
			task.setCreateUser(userRepository.findById(task.getCreateUserId()).getFullName());
			task.setProjectName(projectRepository.findById(task.getProjectId()).getName());
			task.setImplUser(userRepository.findById(task.getUserId()).getFullName());
			task.setStatusName(statusRepository.findById(task.getStatusId()).getName());
			tasks.add(task);
		}
		return tasks;
	}

}

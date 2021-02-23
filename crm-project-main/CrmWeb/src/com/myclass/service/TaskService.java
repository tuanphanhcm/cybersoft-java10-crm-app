package com.myclass.service;

import java.util.ArrayList;
import java.util.List;

import com.myclass.dto.TaskDto;
import com.myclass.entity.Task;
import com.myclass.repository.TaskRepository;

public class TaskService {

	private TaskRepository taskRepository;

	public TaskService() {
		taskRepository = new TaskRepository();
	}

	public List<TaskDto> getAll() {
		List<TaskDto> dtos = taskRepository.findAll();
		return dtos;
	}

	public int delete(int idDel) {
		// TODO Auto-generated method stub
		return taskRepository.remove(idDel);
	}

	public int add(TaskDto dto) {
		// TODO Auto-generated method stub
		Task entity = new Task();
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setStartDate(dto.getStartDate());
		entity.setEndDate(dto.getEndDate());
		entity.setProjectId(dto.getProjectId());
		entity.setUserId(dto.getUserId());
		entity.setStatusId(dto.getStatusId());
		entity.setCreateUserId(dto.getCreateUserId());
		entity.setCategoryId(dto.getCategoryId());
		return taskRepository.save(entity);
	}

}
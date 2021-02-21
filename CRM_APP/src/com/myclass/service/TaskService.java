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
	
	public List<TaskDto> findAll(){
		List<TaskDto> taskDtos = new ArrayList<TaskDto>();
		List<Task> tasks = taskRepository.findAll();
		for (Task task : tasks) {
			TaskDto taskDto = new TaskDto();
			taskDto.setId(task.getId());
			taskDto.setName(task.getName());
			taskDto.setDescription(task.getDescription());
			taskDto.setStartDate(task.getStartDate());
			taskDto.setEndDate(task.getEndDate());
			taskDto.setStatusId(task.getStatusId());
			taskDto.setUserId(task.getUserId());
			taskDto.setProjectId(task.getProjectId());
			taskDtos.add(taskDto);
		}
		return taskDtos;
	}
	
	public boolean addTaskDto(TaskDto taskDto) {
//		if(!checkExist(taskDto)) {
//			return false;
//		}
		Task task = new Task();
		convertToTask(task, taskDto);
		return taskRepository.addTask(task);

	}
	public TaskDto getTaskDtoById(int id) {
		TaskDto taskDto = taskRepository.getTaskDtoById(id);
//		Task task = taskRepository.getTaskById(id);
//		if(task != null) {
//			taskDto = new TaskDto();
//			taskDto.setId(task.getId());
//			taskDto.setName(task.getName());
//			taskDto.setDescription(task.getDescription());
//		}
		return taskDto;
	}
	public boolean updateTaskDto(int id, TaskDto taskDto) {
		Task task = taskRepository.getTaskById(id);
		if(task != null) {
//			if(!checkExist(taskDto)) {
//				return false;
//			}
			convertToTask(task, taskDto);
			return taskRepository.updateTask(id, task);
		}
		return false;
	}
	
	private void convertToTask(Task task, TaskDto taskDto) {
		task.setName(taskDto.getName());
		task.setDescription(taskDto.getDescription());
		task.setDescription(taskDto.getDescription());
		task.setStartDate(taskDto.getStartDate());
		task.setEndDate(taskDto.getEndDate());
		task.setStatusId(taskDto.getStatusId());
		task.setUserId(taskDto.getUserId());
		task.setProjectId(taskDto.getProjectId());
	}
	
	private boolean checkExist(TaskDto taskDto) {
		if(taskDto.getName().equalsIgnoreCase("")) {
			return false;
		}
		List<Task> tasks = taskRepository.findAll();
		for (Task taskCheck : tasks) {
			if((taskCheck.getName().equalsIgnoreCase(taskDto.getName())) && (taskCheck.getId() != taskDto.getId())) {
				return false;
			}
		}
		return true;
	}
	
	public boolean deleteTaskDto(int id) {
		return taskRepository.deleteTask(id);
	}
	
	public List<TaskDto> findAllUseJoinTable(){
		return taskRepository.findAllUseJoinTable();
	}
}

package com.myclass.service;

import java.util.ArrayList;
import java.util.List;

import com.myclass.dto.RoleDto;
import com.myclass.dto.StatusDto;
import com.myclass.entity.Role;
import com.myclass.entity.Status;
import com.myclass.repository.StatusRepository;

public class StatusService {
	private StatusRepository statusRepository;

	public StatusService() {
		statusRepository = new StatusRepository();
	}

	public List<StatusDto> findAll() {
		List<StatusDto> listStatusDto = new ArrayList<StatusDto>();
		List<Status> listStatus = statusRepository.findAll();
		for (Status entity : listStatus) {
			StatusDto statusDto = new StatusDto();
			statusDto.setId(entity.getId());
			statusDto.setName(entity.getName());
			listStatusDto.add(statusDto);
		}
		return listStatusDto;
	}
}

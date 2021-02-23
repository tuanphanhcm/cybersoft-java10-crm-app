package com.myclass.service;

import java.util.List;

import com.myclass.dto.RoleDTO;

public interface RoleService {
	
	List<RoleDTO> findAll();
	int insert(RoleDTO roleDTO);
	RoleDTO findById(int id);
	int update(RoleDTO roleDTO);
	void delete(int id);
	
}

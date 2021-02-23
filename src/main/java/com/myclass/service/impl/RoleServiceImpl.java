package com.myclass.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.myclass.dto.RoleDTO;
import com.myclass.entity.Role;
import com.myclass.repository.RoleRepository;
import com.myclass.repository.impl.RoleRepositoryImpl;
import com.myclass.service.RoleService;
import com.myclass.util.Mapper;

public class RoleServiceImpl implements RoleService {
	
	private RoleRepository repository;
	
	public RoleServiceImpl() {
		repository = new RoleRepositoryImpl();
	}
	
	@Override
	public List<RoleDTO> findAll() {
		List<RoleDTO> list = new ArrayList<>();
		for(Role entity : repository.findAll()) {
			list.add(Mapper.convertToDTO(entity, RoleDTO.class));
		}
		return list;
	}

	@Override
	public int insert(RoleDTO roleDTO) {
		Role entity = Mapper.convertToDTO(roleDTO, Role.class);
		return repository.insert(entity);
	}

	@Override
	public RoleDTO findById(int id) {
		Role entity = repository.findById(id);
		if(entity == null) {
			return null;
		}else {
			return Mapper.convertToDTO(entity, RoleDTO.class);
		}
	}

	@Override
	public int update(RoleDTO roleDTO) {
		Role entity = Mapper.convertToDTO(roleDTO, Role.class);
		return repository.update(entity);
	}

	@Override
	public void delete(int id) {
		repository.delete(id);
	}

}

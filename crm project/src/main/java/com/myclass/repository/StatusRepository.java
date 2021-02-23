package com.myclass.repository;

import com.myclass.entity.Status;

public interface StatusRepository {
	
	Status findById(int id);
	
}

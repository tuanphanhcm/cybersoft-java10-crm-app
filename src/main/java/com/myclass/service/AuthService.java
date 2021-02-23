package com.myclass.service;

import com.myclass.dto.UserDTO;

public interface AuthService {
	
	UserDTO login(String email, String password);
}

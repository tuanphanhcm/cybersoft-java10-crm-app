package com.myclass.util;

import org.modelmapper.ModelMapper;

public class Mapper {
	
	public static <T> T convertToDTO(Object entity, Class<T> dto){
		ModelMapper mapper = new ModelMapper();
		return mapper.map(entity, dto);
	}
	
}

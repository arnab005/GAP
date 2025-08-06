package com.arnab.ecom_dashboard.utils;

import java.util.List;

public abstract class BaseMapper<D,E> implements GenericMapper<D, E> {

	@Override
	public List<D> toDTO(List<E> entityList) {
		
		return entityList.stream().map(this::toDTO).toList();
	}
	
	@Override
	public List<E> toEntity(List<D> dtoList) {
		
		return dtoList.stream().map(this::toEntity).toList();
	}
}

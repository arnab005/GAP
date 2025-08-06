package com.arnab.ecom_order.utils;

import java.util.List;

public interface GenericMapper<D, E> {

	D toDTO(E entity);
	
	E toEntity(D dto);
	
	List<D> toDTO(List<E> entityList);
	
	List<E> toEntity(List<D> dtoList);
}

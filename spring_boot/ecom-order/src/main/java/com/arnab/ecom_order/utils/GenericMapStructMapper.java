package com.arnab.ecom_order.utils;

import java.util.List;

public interface GenericMapStructMapper<D, E> {

	D toDto(E entity);
	
	E toEntity(D dto);
	
	List<D> toDto(List<E> entityList);
	
	List<E> toEntity(List<D> dtoList);
}

package com.egen.service;

import java.util.List;

import com.egen.entity.Order;
//import com.egen.exceptions.RepositoryException;
import com.egen.vo.OrderRequest;
import com.egen.vo.OrderResponse;

public interface OrderService {
	
	OrderResponse findById(int id);
	
	Order orderInsert(OrderRequest o);
	
	void insertAll(List<OrderRequest> o);
	
	boolean delete(int id);
	
	boolean update(OrderRequest o, int id);
	
	boolean updateAll(List<OrderRequest> o, int id);
}

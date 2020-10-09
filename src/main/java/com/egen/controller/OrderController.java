package com.egen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.egen.entity.Order;
import com.egen.exceptions.ErrorResponse;
import com.egen.exceptions.RepositoryException;
import com.egen.service.OrderService;
import com.egen.vo.OrderRequest;
import com.egen.vo.OrderResponse;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	
	@PostMapping("/create")
	public ResponseEntity<Order> placeOrder(@RequestBody OrderRequest req){
		Order order = orderService.orderInsert(req);
		return new ResponseEntity<Order>(order,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrderResponse> getOrder(@PathVariable int id){
		OrderResponse result = orderService.findById(id);
		return new ResponseEntity<OrderResponse>(result,HttpStatus.OK);
	}
	
	@DeleteMapping("/cancel/{id}")
    public ResponseEntity<Void> cancelOrder(@PathVariable int id){
		if (id != 0) {
			if(orderService.delete(id)) {
                return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
            }
		}	
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/create/bulk")
    public ResponseEntity<Void> addBulkOrder(@RequestBody List<OrderRequest> order){
        if(order != null && !order.isEmpty()) {
            orderService.insertAll(order);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
        	return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
    }
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Void> updateOrder(@RequestBody OrderRequest order, @PathVariable int id){
		if (order != null){
			orderService.update(order, id);
			 return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
        	return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
	}
	
	@PutMapping("/update/bulk/{id}")
	public ResponseEntity<Void> bulkUpdateOrder(@RequestBody List<OrderRequest> order, @PathVariable int id){
		if (order != null){
			orderService.updateAll(order, id);
			 return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
        	return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
	}
	
	@ExceptionHandler(RepositoryException.class)
	public ResponseEntity<ErrorResponse> repositoryExceptionHandler(Exception ex) {
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode("xx-xxx");
		error.setMessage(ex.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

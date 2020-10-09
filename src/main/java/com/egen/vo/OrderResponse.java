package com.egen.vo;

import java.util.List;

public class OrderResponse {
	
	private int orderId;
	private String orderStatus;
	private int customerId;
	private List<String> itemName;
	private List<Integer> itemQuantity;
	private int total;
	
	public OrderResponse() {
		
	}
	
	public OrderResponse(int orderId, String orderStatus, int customerId, List<String> itemName, List<Integer> itemQuantity,
			int total) {
		super();
		this.orderId = orderId;
		this.orderStatus = orderStatus;
		this.customerId = customerId;
		this.itemName = itemName;
		this.itemQuantity = itemQuantity;
		this.total = total;
	}
	/**
	 * @return the orderId
	 */
	public int getOrderId() {
		return orderId;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	/**
	 * @return the orderStatus
	 */
	public String getOrderStatus() {
		return orderStatus;
	}
	/**
	 * @param orderStatus the orderStatus to set
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	/**
	 * @return the customerId
	 */
	public int getCustomerId() {
		return customerId;
	}
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	/**
	 * @return the itemName
	 */
	public List<String> getItemName() {
		return itemName;
	}
	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(List<String> itemName) {
		this.itemName = itemName;
	}
	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}
	/**
	 * @return the itemQuantity
	 */
	public List<Integer> getItemQuantity() {
		return itemQuantity;
	}
	/**
	 * @param itemQuantity the itemQuantity to set
	 */
	public void setItemQuantity(List<Integer> itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	
	@Override
	public String toString() {
		return "OrderResponse [orderId=" + orderId + ", orderStatus=" + orderStatus + ", customerId=" + customerId
				+ ", itemName=" + itemName + ", itemQuantity=" + itemQuantity + ", total=" + total + "]";
	}
}

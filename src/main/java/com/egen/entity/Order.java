package com.egen.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_DETAILS")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
	private int id;

	@Column(name = "order_status")
	private String status;
	
	@Column(name = "subtotal")
	private int subtotal;
	
	@Column(name = "tax")
	private int tax;
	
	@Column(name = "total")
	private int total;
	
	@Column(name = "order_date")
	private LocalDateTime created;
	
	@Column(name = "shipping_charge")
	private int shippingCharge;
	
	@Column(name = "customer_id")
	private int customerId;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id", referencedColumnName = "id")
	private List<OrderItem> orderItem;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id", referencedColumnName = "bill_id")
	private Billing billing;
	
	protected Order() {
	}

	public Order(String status, int subtotal, int tax, int total, int shippingCharge,
			int customerId2, List<OrderItem> orderItem, Billing billing) {
		super();
		this.status = status;
		this.subtotal = subtotal;
		this.tax = tax;
		this.total = total;
		this.shippingCharge = shippingCharge;
		this.customerId = customerId2;
		this.orderItem = orderItem;
		this.billing = billing;
	}
	
	@PrePersist
    void onCreate() {
	   this.setCreated(LocalDateTime.now());
    }
	
	public int getId() {
		return id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}

	public int getTax() {
		return tax;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public int getShippingCharge() {
		return shippingCharge;
	}

	public void setShippingCharge(int shippingCharge) {
		this.shippingCharge = shippingCharge;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public List<OrderItem> getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(List<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}

	public Billing getBilling() {
		return billing;
	}

	public void setBilling(Billing billing) {
		this.billing = billing;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", status=" + status + ", subtotal=" + subtotal + ", tax=" + tax + ", total=" + total
				+ ", created=" + created + ", shippingCharge=" + shippingCharge + ", customerId=" + customerId
				+ ", orderItem=" + orderItem + "]";
	}
	
}

package com.business.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Orders
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int oId;
	private String oName;
	private double oPrice;
	private int oQuantity;
	private Date orderDate;
	private double totalAmmout;
	
	@ManyToOne
	@JoinColumn(name="user_u_id")
	private User user;

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	

	public int getoId() {
		return oId;
	}

	public void setoId(int oId) {
		this.oId = oId;
	}

	public String getoName() {
		return oName;
	}

	public void setoName(String oName) {
		this.oName = oName;
	}

	public double getoPrice() {
		return oPrice;
	}

	public void setoPrice(double oPrice) {
		this.oPrice = oPrice;
	}

	public int getoQuantity() {
		return oQuantity;
	}

	public void setoQuantity(int oQuantity) {
		this.oQuantity = oQuantity;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

	public double getTotalAmmout() {
		return totalAmmout;
	}

	public void setTotalAmmout(double totalAmmout) {
		this.totalAmmout = totalAmmout;
	}

	@Override
	public String toString() {
		return "Orders [oId=" + oId + ", oName=" + oName + ", oPrice=" + oPrice + ", oQuantity=" + oQuantity
				+ ", orderDate=" + orderDate + ", totalAmmout=" + totalAmmout + ", user=" + user + "]";
	}


}

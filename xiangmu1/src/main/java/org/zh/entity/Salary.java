package org.zh.entity;

import java.util.Date;

public class Salary {
	private int payment_id;
	private int user_id;
	private Date payment_time;
	private double payment_money;
	private String Mcha;
	public int getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	public double getPayment_money() {
		return payment_money;
	}
	public void setPayment_money(double payment_money) {
		this.payment_money = payment_money;
	}
	public Date getPayment_time() {
		return payment_time;
	}
	public void setPayment_time(Date payment_time) {
		this.payment_time = payment_time;
	}
	public String getMcha() {
		return Mcha;
	}
	public void setMcha(String mcha) {
		Mcha = mcha;
	}
}

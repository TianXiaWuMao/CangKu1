package com.zh.entity;

public class Salary_payment {
	private int payment_id;
	private int user_id;
	private String payment_time;
	private double payment_money;
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
	public String getPayment_time() {
		return payment_time;
	}
	public void setPayment_time(String payment_time) {
		this.payment_time = payment_time;
	}
	public double getPayment_money() {
		return payment_money;
	}
	public void setPayment_money(double payment_money) {
		this.payment_money = payment_money;
	}
}

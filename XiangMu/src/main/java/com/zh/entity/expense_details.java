package com.zh.entity;

public class expense_details {
	private int expense_details_id;
	private int expense_id;
	private int cost_id;
	private double expense_details_amount;
	public int getExpense_details_id() {
		return expense_details_id;
	}
	public void setExpense_details_id(int expense_details_id) {
		this.expense_details_id = expense_details_id;
	}
	public int getExpense_id() {
		return expense_id;
	}
	public void setExpense_id(int expense_id) {
		this.expense_id = expense_id;
	}
	public int getCost_id() {
		return cost_id;
	}
	public void setCost_id(int cost_id) {
		this.cost_id = cost_id;
	}
	public double getExpense_details_amount() {
		return expense_details_amount;
	}
	public void setExpense_details_amount(double expense_details_amount) {
		this.expense_details_amount = expense_details_amount;
	}
}

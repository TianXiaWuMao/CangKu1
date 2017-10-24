package org.zh.entity;

import java.util.Date;

import org.zh.unit.BaseBean;

public class Expense_account extends BaseBean {
	private int expense_id;
	private int user_id;
	private String expense_name;
	private String expense_desc;
	private Date expense_time;
	private String expense_state;
	private double expense_total;
	private String Mcha;
	public int getExpense_id() {
		return expense_id;
	}
	public void setExpense_id(int expense_id) {
		this.expense_id = expense_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getExpense_desc() {
		return expense_desc;
	}
	public void setExpense_desc(String expense_desc) {
		this.expense_desc = expense_desc;
	}
	public String getExpense_state() {
		return expense_state;
	}
	public void setExpense_state(String expense_state) {
		this.expense_state = expense_state;
	}
	public double getExpense_total() {
		return expense_total;
	}
	public void setExpense_total(double expense_total) {
		this.expense_total = expense_total;
	}
	public Date getExpense_time() {
		return expense_time;
	}
	public void setExpense_time(Date expense_time) {
		this.expense_time = expense_time;
	}
	public String getExpense_name() {
		return expense_name;
	}
	public void setExpense_name(String expense_name) {
		this.expense_name = expense_name;
	}
	public String getMcha() {
		return Mcha;
	}
	public void setMcha(String mcha) {
		this.Mcha = mcha;
	}
}

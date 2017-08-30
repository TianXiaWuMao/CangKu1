package com.zh.entity;

public class Audit_history {
	private int audit_id;
	private int expense_id;
	private int user_id;
	private String audit_time;
	private String audit_state;
	private String audit_dese;
	public int getAudit_id() {
		return audit_id;
	}
	public void setAudit_id(int audit_id) {
		this.audit_id = audit_id;
	}
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
	public String getAudit_time() {
		return audit_time;
	}
	public void setAudit_time(String audit_time) {
		this.audit_time = audit_time;
	}
	public String getAudit_state() {
		return audit_state;
	}
	public void setAudit_state(String audit_state) {
		this.audit_state = audit_state;
	}
	public String getAudit_dese() {
		return audit_dese;
	}
	public void setAudit_dese(String audit_dese) {
		this.audit_dese = audit_dese;
	}
}

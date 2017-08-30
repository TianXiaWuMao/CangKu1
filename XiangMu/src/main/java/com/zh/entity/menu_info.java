package com.zh.entity;

public class menu_info {
	private int menu_id;
	private int prent_menu_id;
	private String menu_name;
	private String menu_url;
	public int getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}
	public int getPrent_menu_id() {
		return prent_menu_id;
	}
	public void setPrent_menu_id(int prent_menu_id) {
		this.prent_menu_id = prent_menu_id;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public String getMenu_url() {
		return menu_url;
	}
	public void setMenu_url(String menu_url) {
		this.menu_url = menu_url;
	}
}

package org.zh.dao;

import java.util.List;

import org.zh.entity.Audit_history;
import org.zh.entity.Cost_info;
import org.zh.entity.Expense_account;
import org.zh.entity.Expense_details;

public interface Expense_accountDao {
	public List list(Expense_account ec);
	public Expense_account findExp(Expense_account expense_id);
	public List listAll(Expense_account expense_id);
	public List listHistory(int id);
	public List listCos();
	public int insertexp(Expense_account expense_id);
	public int insertdet(Expense_details eds);
	public List listmyshow(String name);
	
	public List JSHlist();//审核全部
	public Expense_account JShenHe(Expense_account ea);
	public List JSHMX(int id);//经理审核明细
	//审核状态    描述
	public int SHupdate (Expense_account eat);
	public int SHinsert(Audit_history ah);
	//修改报销单基本信息
	public int update(Expense_account eat);
	//修改报销明细
	public int updateMx(Expense_details eds);
	//分页的总数
	public int count();
	
}

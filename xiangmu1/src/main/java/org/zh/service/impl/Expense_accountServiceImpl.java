package org.zh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zh.dao.Expense_accountDao;
import org.zh.entity.Audit_history;
import org.zh.entity.Cost_info;
import org.zh.entity.Expense_account;
import org.zh.entity.Expense_details;
import org.zh.service.Expense_accountService;

@Service
@Transactional

public class Expense_accountServiceImpl implements Expense_accountService {
	@Autowired
	private Expense_accountDao ead;

	@Override
	public List list(Expense_account ec) {
		
		return ead.list(ec);
	}

	
	public List listAll(Expense_account expense_id) {
		
		return ead.listAll(expense_id);
	}


	
	public List listHistory(int id) {
		
		return ead.listHistory(id);
	}


	public Expense_account findExp(Expense_account expense_id) {
		
		return ead.findExp(expense_id);
	}



	public List listCos() {
	
		return ead.listCos();
	}


	
	public int insertexp(Expense_account expense_id) {
		
		return ead.insertexp(expense_id);
	}


	
	public int insertdet(Expense_details eds) {
		// TODO Auto-generated method stub
		return ead.insertdet(eds);
	}


	
	public List listmyshow(String name) {
		// TODO Auto-generated method stub
		return ead.listmyshow(name);
	}

	public List JSHlist() {
		
		return ead.JSHlist();
	}


	
	public List JSHMX(int id) {
		
		return ead.JSHMX(id);
	}


	
	public int SHupdate(Expense_account eat) {
		
		return ead.SHupdate(eat);
	}


	
	public int SHinsert(Audit_history ah) {
		// TODO Auto-generated method stub
		return ead.SHinsert(ah);
	}


	public Expense_account JShenHe(Expense_account ea) {
		
		return ead.JShenHe(ea);
	}
	//修改报销单基本信息
	public int update(Expense_account eat) {
		return ead.update(eat);
	}
	public int updateMx(Expense_details eds) {
		return ead.updateMx(eds);
	}

	public int count() {
		return ead.count();
	}


	
	

	
	

	
	
}

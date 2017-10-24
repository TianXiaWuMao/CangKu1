package org.zh.service.impl;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zh.dao.SalaryDao;
import org.zh.entity.Salary;
import org.zh.entity.User;
import org.zh.service.SalaryService;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

@Service
@Transactional

public class SalaryServiceImpl implements SalaryService {

	@Autowired
	private SalaryDao sd;
	public List listAll() {
		
		return sd.listAll();
	}

	
	public int insert(Salary sa) {
		
		return sd.insert(sa);
	}
	
	public int add(Salary sa) {
		
		return sd.add(sa);
	}
	
	public List findName() {
		return sd.findName();
	}

	public List like(Salary sa) {
		return sd.like(sa);
	}


	
	public List listBao() {
		
		return sd.listBao();
	}
	
	public void addExcel(InputStream is) throws Exception {
		// TODO Auto-generated method stub
		//先创建读取excel的类
		Workbook book=Workbook.getWorkbook(is);
		//获取表的页数
		Sheet sheet=book.getSheet(0);
		
		for(int i=1;i<sheet.getRows();i++){
			Salary sa=new Salary();
			//获取id
			Cell id=sheet.getCell(0,i);
			int user_id=Integer.parseInt(id.getContents());
			sa.setUser_id(user_id);
			
			//获取时间
			Cell time=sheet.getCell(1,i);
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date salarytime=sdf.parse(time.getContents());
			sa.setPayment_time(salarytime);
			
			//获取钱
			Cell money=sheet.getCell(2,i);
			int salary_money=Integer.parseInt(money.getContents());
			sa.setPayment_money(salary_money);
			sd.add(sa);
		}
	}

}

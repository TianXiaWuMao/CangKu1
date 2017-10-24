package org.zh.service;

import java.io.InputStream;
import java.util.List;

import org.zh.entity.Salary;
import org.zh.entity.User;


public interface SalaryService {
	public List listAll();
	public int insert(Salary sa);
	//薪资添加查询
	public List findName();
	//薪资添加
	public int add(Salary sa);
	//模糊查询
	public List like(Salary sa);
	//报表查询
	public List listBao();
	//导入excel
	public void addExcel(InputStream is) throws Exception;
}

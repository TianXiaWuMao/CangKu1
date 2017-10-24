package org.zh.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.zh.entity.Cost_info;
import org.zh.entity.Salary;
import org.zh.entity.User;
import org.zh.service.SalaryService;

@Controller
@RequestMapping("/salary/")
public class SalaryController {
	@Autowired
	private SalaryService sse;
	@RequestMapping("list")
	public String listAll(HttpServletRequest request){
		List list=sse.listAll();
		if(list!=null){
			request.setAttribute("list",list);
			return "salary/salary_list";
		}else{
			return "error";
		}	
	}
	//报表加载
	@RequestMapping("highchair")
	public String highchair(HttpServletRequest request){
		List list=sse.listAll();
		if(list!=null){
			request.setAttribute("list",list);
			return "salary/highchair";
		}
		return null;
		
	}
	@RequestMapping("findName")
	public String findById(HttpServletRequest request) {
		List list=sse.findName();
		if(list!=null){
			request.setAttribute("list",list);
			return "salary/salary_add";
		}else{
			return "error";
		}	
	}
	@RequestMapping("add")
	public String add(HttpServletRequest request,Salary sa){
		int i=sse.add(sa);
		if(i!=0){
			return findById(request);
		}else{	
			return "error";
		}
	}	
	@RequestMapping("like")
	public String like(HttpServletRequest request,Salary sa){
			String name=request.getParameter("name");
			if(name!=null){
				sa.setMcha("%"+name+"%");
			}else{
				sa.setMcha("%%");
			}
		List list=sse.like(sa);
		if(list!=null){
			request.setAttribute("list",list);
			return "salary/salary_list";
		}
		return null;	
	}
	@RequestMapping("loadExcel")
	public String loadExcel(){
		return "salary/addExcel";
		
	}
	//导入Excel
	@RequestMapping("addExcel")
	public String addex(@RequestParam(value="file",required=false)MultipartFile file,HttpServletRequest request){
		try {
			this.sse.addExcel(file.getInputStream());
		} catch (Exception e) {

			e.printStackTrace();
		}
		return  listAll(request);
	}
	//时间转换
		@InitBinder
		public void initBinder(ServletRequestDataBinder bin) {
			bin.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
		}
}

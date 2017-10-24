package org.zh.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zh.entity.Cost_info;
import org.zh.service.CostService;

@Controller
@RequestMapping("/cost/")
public class CostController {
	@Autowired
	private CostService cs;
	@RequestMapping("list")
	public String listAll(HttpServletRequest request){
		List list=cs.listAll();
		if(list!=null){
			request.setAttribute("list",list);
			return "cost/cost_list";
		}else{
			return "error";
		}	
	}
	
	@RequestMapping("loadAdd")
	public String loadAdd(){
		
		return "cost/cost_add";
		
	}
	@RequestMapping("add")
	public String add(Cost_info co,HttpServletRequest request){
		int i=cs.insert(co);
		if(i!=0){
			return listAll(request);
		}
		return null;
	}
	@RequestMapping("loadupdate")
	public String findById(HttpServletRequest request){
		String[] ids=request.getParameterValues("ids");
		Cost_info co=cs.findById(Integer.parseInt(ids[0]));
		if(co!=null){
			request.setAttribute("cost",co);
			return "cost/cost_update";
		}
		return null;		
	}
	@RequestMapping("update")
	public String update(Cost_info co,HttpServletRequest request){
		int i=0;
			 i=cs.update(co);
		if(i!=0){
			return listAll(request);
		}
		return null;	
	}
	@RequestMapping("delete")
	public String delete(HttpServletRequest request){
		String[] ids=request.getParameterValues("ids");
		int j=0;
		for(int i=0;i<ids.length;i++){
			j=cs.delete(Integer.parseInt(ids[i]));
		}
		if(j!=0){
			return listAll(request);
		}
		return null;
	}
	@RequestMapping("like")
	public String like(HttpServletRequest request,Cost_info co){
		String name;
		if(co.getCost_name()!=null){
			name="%"+co.getCost_name()+"%";
		}else{
			name="%";
		}
		List list=cs.like(name);
		if(list!=null){
			request.setAttribute("list",list);
			return "cost/cost_list";
		}
		return null;	
	}
}

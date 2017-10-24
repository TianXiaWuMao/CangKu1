package org.zh.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zh.entity.Role_info;
import org.zh.service.Role_infoService;

@Controller
@RequestMapping("/role/")
public class roleController {
	@Autowired
	private Role_infoService ris;
	@RequestMapping("listAll")
	public String listAll(HttpServletRequest request){
		List list=ris.findAll();
		if(list!=null){
			request.setAttribute("list", list);
			return "role/role_list";
		}else{
			return null;
		}
	}
	@RequestMapping("like")
	public String like(String role_name,HttpServletRequest request){
		if(role_name!=null){
			role_name="%"+role_name+"%";
		}else{
			role_name="%";
		}
		List list=ris.like(role_name);
		if(list!=null){
			request.setAttribute("list",list);
			return "role/role_list";
		}else{
			return "error";
		}
	}
	@RequestMapping("loadadd")
	public String loadadd(){
		return "role/role_add";
		
	}
	@RequestMapping("insert")
	public String insert(Role_info ri,HttpServletRequest request){
	//	System.out.println(ri.getRole_name()+ri.getRole_desc()+"值去哪了");
		int i=ris.insert(ri);
		if(i!=0){
			return listAll(request);
		}else{
			return "error";
		}
	}
	@RequestMapping("findById")
	public String findById(int role_id,HttpServletRequest request){
		Role_info ri=ris.findById(role_id);
		if(ri!=null){
			request.setAttribute("role", ri);
			return "role/role_update";
		}else{
			return null;
		}
		
	}
	@RequestMapping("update")
	public String update(Role_info ri,HttpServletRequest request){
		int i=ris.update(ri);
		if(i!=0){
			return listAll(request);
		}else{
			return "error";
		}
	}
	@RequestMapping("delete")
	public String delete(int role_id,HttpServletRequest request){
		int i=ris.delete(role_id);
		if(i!=0){
			return listAll(request);
		}else{
			return "error";
		}
	}
	@RequestMapping("jiashan")
	public String jiashan(Role_info ri,HttpServletRequest request){
		int i=ris.jiashan(ri);
		if(i!=0){
			return listAll(request);
		}else{
			return "error";
		}
		
	}
}

package org.zh.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zh.entity.Role_info;
import org.zh.entity.Role_menu_info;
import org.zh.entity.User;
import org.zh.service.AnthorityService;
import org.zh.service.Role_infoService;

@Controller
@RequestMapping("/anthority/")
public class AnthorityController {
	@Autowired
	private AnthorityService as;
	@RequestMapping("list")
	public String list(HttpServletRequest request){
		List list=as.listAll();
		if(list!=null){
			request.setAttribute("list", list);
			return "anthority/anthority_list";
		}else{
			return "error";
		}
	}
	@RequestMapping("like")
	public String like(String role_name,HttpServletRequest request){
		if(role_name!=null){
			role_name="%"+role_name+"%";
		}else{
			role_name="%";
		}
		List list=as.like(role_name);
		if(list!=null){
			request.setAttribute("list",list);
			return "anthority/anthority_list";
		}else{
			return "error";
		}
	}
	@RequestMapping("change")
	public String change(int id,HttpServletRequest request){	
		List listM=as.findAll();
		List listRM=as.findById(id);
		Role_info role=as.touXX(id);
		request.setAttribute("role",role);
		request.setAttribute("listM",listM);
		request.setAttribute("listM1",listM);
		request.setAttribute("listRM",listRM);
		request.setAttribute("rid",id);
		return "anthority/anthority_change";
	}
	@RequestMapping("update")
	public String update(HttpServletRequest request){
		String [] ids=request.getParameterValues("ids");
		int rid=Integer.parseInt(request.getParameter("rid"));
		if(ids.length!=0&&rid!=0){	
			as.delete(rid);	
			for(int i=0;i<ids.length;i++){
				Role_menu_info rmi =new Role_menu_info();
				rmi.setMenu_id(Integer.parseInt(ids[i]));
				rmi.setRole_id(rid);
				as.update(rmi);
			}
		}
		return list(request);
	}
}

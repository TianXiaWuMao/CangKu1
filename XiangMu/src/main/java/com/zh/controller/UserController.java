package com.zh.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;

import com.zh.entity.User;
import com.zh.service.UserService;

@RequestMapping("/user")
public class UserController {
	private UserService uService;
	
	public void setuService(UserService uService) {
		this.uService = uService;
	}

	@RequestMapping("login")
	public String login(User us,HttpServletRequest request){
		User user=uService.login(us);
		if(user!=null){
			return listAll(request);
		}else{
			return null;
		}	
	}
	@RequestMapping("listAll")
	public String listAll(HttpServletRequest request){
		List list=uService.listAll();
		if(list!=null){
			request.setAttribute("list",list);
			return "user_list.jsp";
		}else{	
			return "";
		}
	}
	@RequestMapping("listLike")
	public String listLike(HttpServletRequest request,String userName){
		if(userName!=null){
			userName="%"+userName+"%";
		}else{
			userName="%%";
		}
		List list=uService.listLike(userName);
		if(list!=null){
			request.setAttribute("list",list);
			return "user_list.jsp";
		}else{
			return "";
		}
	}
	@RequestMapping("chakan")
	public String chakan(HttpServletRequest request,int user_id){
		List list=uService.chakan(user_id);
		if(list!=null){
			request.setAttribute("list",list);
			return "user_show.jsp";
		}else{
			return "";
		}
	}
	@RequestMapping("insert")
	public String insert(HttpServletRequest request,User us){
		int i=uService.insert(us);
		if(i!=0){
			return listAll(request);
		}else{
			return null;
		}
	}
	@RequestMapping("findById")
	public String findById(HttpServletRequest request,int user_id){
		User user=uService.findById(user_id);
		if(user!=null){
			request.setAttribute("user",user);
			return "user_update.jsp";
		}else{
			return null;
		}		
	}
	
	@RequestMapping("update")
	public String update(HttpServletRequest request,User us){
		int i=uService.update(us);
		if(i!=0){
			return listAll(request);
		}else{
			return null;
		}
	}
	@RequestMapping("delete")
	public String delete(HttpServletRequest request,int user_id){
		int i=uService.delete(user_id);
		if(i!=0){
			return listAll(request);
		}else{
			return null;
		}
		
	}
}

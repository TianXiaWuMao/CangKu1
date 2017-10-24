package org.zh.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zh.entity.User;
import org.zh.service.AnthorityService;
import org.zh.service.UserService;
import org.zh.unit.Page;

@Controller
@RequestMapping("/user/")
public class controller extends Page{
	@Autowired
	private UserService uService;
	@Autowired
	private AnthorityService aservice;
	private String msg;
	
	@RequestMapping("index")
	public String uindex(){
		
		return "main/index";
		
	}
	
	//登录
	@RequestMapping("login")
	public String login(User user,HttpServletRequest request) {
		HttpSession session=request.getSession();
			User use=(User) session.getAttribute("user");
		//	if(use==null){
				User us = uService.login(user);
		        session.setAttribute("user",us);
		        int role_id=-10;
		        if(us!=null){
		        	 role_id=us.getRole_id();
		        }
		        List list=null;
		        		if(role_id!=-10){
		        			list=aservice.findById(role_id);
		        		} 
				if (list != null) {
					request.setAttribute("list",list);
					request.setAttribute("list1",list);
					return "main/index";
				}else {
					msg="账号或密码错误";
					request.setAttribute("msg",msg);
					return "../../login";
				}
			}
//			else{
//				msg="该账户已登录";
//				request.setAttribute("msg",msg);
//				return "../../login";
//			}
	//	}
	@RequestMapping("bootm")
	public String bootm() {
		return "main/bootm";
	}
	@RequestMapping("listAll")
	public String listAll(HttpServletRequest request,User us){
		if(us==null){
			us=new User();
		}
		this.initPage(request);
		us.setCurrentPage(this.getCurrentPage());
		us.setLineSize(this.getLineSize());
		List list=uService.listAll(us);
		if(list!=null){
			request.setAttribute("list",list);
			request.setAttribute("total",this.uService.count());
			return "user/user_list";
		}else{	
			msg="查询失败了";
			request.setAttribute("msg",msg);
			return "error";
		}
	}
	@RequestMapping("listLike")
	public String listLike(HttpServletRequest request,User us){
		String name=us.getUser_name();
		if(us.getUser_name()!=null){
			us.setUser_name("%"+us.getUser_name()+"%");
		}else{
//			us.setUser_name("%%");
			return listAll(request,null);
		}
		this.initPage(request);
/*		us.setCurrentPage(this.getCurrentPage());
		us.setLineSize(this.getLineSize());*/
		us.setCurrentPage(0);
		us.setLineSize(5);
		List list=uService.listLike(us);
		if(list!=null){
			request.setAttribute("list",list);
			request.setAttribute("total",this.uService.countCX(name));
			return "user/user_list";
		}else{
			msg="没有该用户";
			return "error";
		}
	}
	//我的资料
	@RequestMapping("myZiLiao")
	public String myzL(HttpServletRequest request){
		HttpSession session =request.getSession();
		User us=(User) session.getAttribute("user");
		return chakan(request,us.getUser_id());
	}
	@RequestMapping("chakan")
	public String chakan(HttpServletRequest request,int user_id){
		List list=uService.chakan(user_id);
		if(list!=null){
			request.setAttribute("list",list);
			return "user/user_show";
		}else{
			return "";
		}
	}
	@RequestMapping("userinsert")
	public String userinsert(HttpServletRequest request){
		List list=uService.findByName();
		if(list!=null){
			request.setAttribute("list", list);
			return "user/user_add";
		}
		return null;
		
	}
	@RequestMapping("insert")
	public String insert(HttpServletRequest request,User us){
		int i=uService.insert(us);
		if(i!=0){
			return listAll(request,null);
		}else{
			msg="添加失败了";
			request.setAttribute("msg",msg);
			return "error";
		}
	}
	@RequestMapping("findById")
	public String findById(HttpServletRequest request){
		String id[] =request.getParameterValues("user_id");
		int i=0;
		for(int j=0;j<id.length;j++){
			i=Integer.parseInt(id [j]);
		}
		User user=uService.findById(i);
		if(user!=null){
			request.setAttribute("user",user);
			return "user/user_update";
		}else{
			return null;
		}		
	}
	
	@RequestMapping("update")
	public String update(HttpServletRequest request,User us){
		int i=uService.update(us);
		if(i!=0){
			return listAll(request,null);
		}else{
			msg="更新失败了";
			request.setAttribute("msg",msg);
			return "error";
		}
	}
	@RequestMapping("delete")
	public String delete(HttpServletRequest request,int user_id){
		
		int i=uService.delete(user_id);
		if(i!=0){
			return listAll(request,null);
		}else{
			msg="删除失败了";
			request.setAttribute("msg",msg);
			return "error";
		}
	}
	@RequestMapping("jiashan")
	public String jiashan(HttpServletRequest request){
		String id[] =request.getParameterValues("user_id");
		System.out.println(id.length+"hhhhh11131");
		int i=0;
		for(int j=0;j<id.length;j++){
			int ids=Integer.parseInt(id [j]);
			i=uService.jiashan(ids);
		}
		if(i!=0){
			return listAll(request,null);
		}else{
			msg="删除失败了";
			request.setAttribute("msg",msg);
			return "error";
		}
	}
	@RequestMapping("exit")
	public String exits(HttpServletRequest request){
		HttpSession session=request.getSession();
		session.removeAttribute("user");
		return "../../login";
		
	}
}

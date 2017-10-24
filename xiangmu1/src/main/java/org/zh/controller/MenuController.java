package org.zh.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zh.entity.Menu_info;
import org.zh.service.MenuService;

@Controller
@RequestMapping("/menu/")
public class MenuController {
	@Autowired
	private MenuService ms;
	
	@RequestMapping("mindex")
	public String mindex(){
		return "menu/menu_index";
	}
	
	@RequestMapping("list")
	public String list(HttpServletRequest request){
		List list=ms.list();
		if(list!=null){
			request.setAttribute("list", list);
			return "menu/menu_left";
		}else{	
			return "error";
		}	
	}
	@RequestMapping("menutop")
	public String menutop(){
		return "menu/menu_top";
		
	}
	@RequestMapping("menumain")
	public String MenuMainLoad(){
		return "menu/menu_main";
	}
	/**
	 * 添加界面的查询
	 */
	@RequestMapping("loadadd")
	public String loadAdd(HttpServletRequest request){
		List list=ms.findName();
		if(list!=null){
			request.setAttribute("list",list);
			return "menu/menu_add";
		}else{
			return "error";
		}	
	}
	@RequestMapping("add")
	public String Add(HttpServletRequest request,Menu_info mo){
		int i=ms.insert(mo);
		if(i!=0){
			return "menu/menu_zj";
		}else{
			return "error";
		}
	}
	@RequestMapping("mmd")
	public String mmd(int menu_id,HttpServletRequest request){
		Menu_info mo=ms.findByIdU(menu_id);
		Menu_info mo1=ms.findByIdU(mo.getPrent_menu_id());
		if(mo!=null){
			request.setAttribute("mo",mo);
			request.setAttribute("mo1",mo1);
			return MenuMainLoad();
		}
		return null;
	}
	/**
	 * 添加界面的查询
	 */
	@RequestMapping("loadupdate")
	public String findByIdU(int menu_id,HttpServletRequest request){
		Menu_info mo=ms.findByIdU(menu_id);
		Menu_info mo1=ms.findByIdU(mo.getPrent_menu_id());
		if(mo!=null){
			request.setAttribute("mo",mo);
			request.setAttribute("mo1",mo1);
			return findNameU(request);
		}else{
			return "error";
		}
		
	}
	@RequestMapping("findNameU")
	public String findNameU(HttpServletRequest request){
		List list=ms.findName();
		if(list!=null){
			request.setAttribute("list",list);
			return "menu/menu_update";
		}else{
			return "error";
		}
	}
	@RequestMapping("update")
	public String update(Menu_info mo){
		//System.out.println("+++++++++++"+mo.getMenu_name()+"~~~~"+mo.getPrent_menu_id());
		int i=ms.update(mo);
		//System.out.println("/////////////");
		if(i!=0){
			return "menu/menu_zj";
		}else{
			return "error";
		}	
	}
	@RequestMapping("delete")
	public String delete(int menu_id){
		int i=ms.delete(menu_id);
		if(i!=0){
			return "menu/menu_zj";
		}else{
			return "error";
		}	
	}
}

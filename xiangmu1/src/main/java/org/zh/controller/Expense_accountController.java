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
import org.zh.entity.Audit_history;
import org.zh.entity.Expense_account;
import org.zh.entity.Expense_details;
import org.zh.entity.User;
import org.zh.service.Expense_accountService;
import org.zh.unit.Page;

@Controller
@RequestMapping("/expense/")
public class Expense_accountController extends Page {
	@Autowired
	private Expense_accountService eas;
	/**
	 * 报销的查全和模糊查询
	 **/
	@RequestMapping("list")
	public String list(HttpServletRequest request,Expense_account ec){
		String name=request.getParameter("name");
		if(name!=null){
			name="%"+name+"%";
		}else{
			name="%";
		}
		ec.setMcha(name);
		List list=eas.list(ec);
		if(list!=null){
			request.setAttribute("list",list);
			return "expense/expense_list";
		}else{
			return "error";
		}
	}
	/**
	 * 经理模糊查询
	 * */
	@RequestMapping("likeJL")
	public String likeJL(HttpServletRequest request,Expense_account ec){
		String name=request.getParameter("name");
		if(name!=null){
			name="%"+name+"%";
		}else{
			name="%";
		}
		System.out.println("++++++++++"+name);
		ec.setMcha(name);
		List list=eas.list(ec);
		if(list!=null){
			request.setAttribute("list",list);
			System.out.println("!!!!!!!!!!!!!!!");
			System.out.println(list+"^^^^^^^^^");
			return "expense/expense_audit_manager";
		}else{
			return "error";
		}
	}
	/**
	 * 经理模糊查询
	 * */
	@RequestMapping("likeCW")
	public String likeCW(HttpServletRequest request,Expense_account ec){
		String name=request.getParameter("name");
		if(name!=null){
			name="%"+name+"%";
		}else{
			name="%";
		}
		System.out.println("++++++++++"+name);
		ec.setMcha(name);
		List list=eas.list(ec);
		if(list!=null){
			request.setAttribute("list",list);
			System.out.println("!!!!!!!!!!!!!!!");
			System.out.println(list+"^^^^^^^^^");
			return "expense/expense_audit_finance";
		}else{
			return "error";
		}
	}
	//
	@RequestMapping("show")
	public String listAll(HttpServletRequest request,int id){
		Expense_account eid =new Expense_account();
		eid.setExpense_id(id);
		Expense_account ec=eas.findExp(eid);
		List list=eas.listAll(eid);
		List listHis=eas.listHistory(id);
		if(list!=null&listHis!=null&ec!=null){
			request.setAttribute("listexp",ec);
			request.setAttribute("listh",listHis);
			request.setAttribute("list",list);
			return "expense/expense_show";
		}else{
			return "error";
		}
	}
	//报销单添加
	@RequestMapping("listCos")
	public String listCos(HttpServletRequest request){
		List list=eas.listCos();
		if(list!=null){
			request.setAttribute("list",list);
			return "expense/expense_add";
		}
		return "error";	
	}
	//添加报销单
	@RequestMapping("insert")
	public String insert(HttpServletRequest request,Expense_account ea,Expense_details eds){
		HttpSession session =request.getSession();
		User us=(User) session.getAttribute("user");
		int id=us.getUser_id();//当前用户 的id
		ea.setUser_id(id);
		int i=eas.insertexp(ea);
		eds.setExpense_id(ea.getExpense_id());
		int j=0;
		String[]ids=request.getParameterValues("ids");
		String[] eda=request.getParameterValues("eda");
		for(int k=0;k<ids.length;k++){
			eds.setCost_id(Integer.parseInt(ids[k]));
			eds.setExpense_details_amount(Double.parseDouble(eda[k]));
			 j=eas.insertdet(eds);
		}
		if(i!=0&j!=0){
			return listCos(request);
		}else{
			return "error";
		}
		
	}
	//我的报销单查询
	@RequestMapping("mylist")
	public String listmyshow(HttpServletRequest request){
		HttpSession session =request.getSession();
		User us=(User) session.getAttribute("user");
		String name=us.getUser_name();
		List list=eas.listmyshow(name);
		if(list!=null){
			request.setAttribute("list",list);
			return "expense/expense_mylist";
		}
		return null;
		
	}
	//经理审核查全
	@RequestMapping("JSHlist")
	public String JSHlist(HttpServletRequest request){
		List list=eas.JSHlist();
		if(list!=null){
			request.setAttribute("list",list);
			return "expense/expense_audit_manager";
		}else{
			return "error";
		}	
	}
	//经理审核单查
	@RequestMapping("JShenHe")
	public String ShenHe(HttpServletRequest request,Expense_account ea){
		Expense_account ec=eas.JShenHe(ea);
		int id=ea.getExpense_id();
		List listmx=eas.JSHMX(id);
		if(ec!=null&listmx!=null){
			request.setAttribute("list",ec);
			request.setAttribute("listmx",listmx);
			return "expense/expense_manager";
		}else{
			return "error";
		}	
	}
	//财务审核查全
	@RequestMapping("CSHlist")
	public String CSHlist(HttpServletRequest request){
		List list=eas.JSHlist();
		if(list!=null){
			request.setAttribute("list",list);
			return "expense/expense_audit_finance";
		}else{
			return "error";
		}	
	}
	//财务审核单查
	@RequestMapping("CShenHe")
	public String CShenHe(HttpServletRequest request,Expense_account ea){
		Expense_account ec=eas.JShenHe(ea);
		int id=ea.getExpense_id();
		List listmx=eas.JSHMX(id);
		if(ec!=null&listmx!=null){
			request.setAttribute("list",ec);
			request.setAttribute("listmx",listmx);
			return "expense/expense_finance";
		}else{
			return "error";
		}	
	}
	//审核描述
	@RequestMapping("JSHinsert")
	public String JSHinsert(HttpServletRequest request,Expense_account eat,Audit_history ah){
		int i=eas.SHupdate(eat);//报销表的更新
		ah.setExpense_id(eat.getExpense_id());
		HttpSession session=request.getSession();
		User us=(User) session.getAttribute("user");
		ah.setUser_id(us.getUser_id());//取出当前账户的Id 为 历史表中的user_id
		ah.setAudit_state(eat.getExpense_state());//历史表的添加
		int j=eas.SHinsert(ah);
		if(i!=0 &j!=0){
			return JSHlist(request);
		}else{	
			return "error";
		}
	}
	//报销单的修改单查
	@RequestMapping("updatelist")
	public String updatelist(int id,HttpServletRequest request){
		Expense_account ea=new Expense_account();
		ea.setExpense_id(id);
		this.initPage(request);
		request.setAttribute("costList",eas.listCos());//费用信息
		request.setAttribute("account",eas.JShenHe(ea));; //报销基本信息
		List listmx=eas.JSHMX(id);
		request.setAttribute("list",listmx);//报销明细
		return "expense/expense_update";
	}
	
	//我的报销单详细
	@RequestMapping("myshow")
	public String listAllMS(HttpServletRequest request,int id){
		Expense_account eid =new Expense_account();
		eid.setExpense_id(id);
		Expense_account ec=eas.findExp(eid);
		List list=eas.listAll(eid);
		List listHis=eas.listHistory(id);
		if(list!=null&listHis!=null&ec!=null){
			request.setAttribute("listexp",ec);
			request.setAttribute("listh",listHis);
			request.setAttribute("list",list);
			return "expense/expense_myshow";
		}else{
			return "error";
		}
	}
	//报销单修改
//	@RequestMapping("update")
//	public String update(HttpServletRequest request,Expense_account eat,Expense_details eds){
//		int i=eas.update(eat);
//		String [] money=request.getParameterValues("amount");
//		String [] id=request.getParameterValues("idss");
//		String [] detaid=request.getParameterValues("detaid");
//		int j=0;
//		for(int k=0;k<id.length;k++){
//			eds.setCost_id(Integer.parseInt(id[k]));
//			eds.setExpense_details_amount(Double.parseDouble(money[k]));
//			eds.setExpense_details_id(Integer.parseInt(detaid[k]));
//			j=eas.updateMx(eds);	
//		}
//		if(i!=0&j!=0){
//			return listmyshow(request);
//		}else{	
//			return "error";
//		}	
//	}
//	//报销单修改
		@RequestMapping("update")
		public String update(HttpServletRequest request,Expense_account eat,Expense_details eds,int id){
			int i=eas.update(eat);
			String [] money=request.getParameterValues("amount");
			int in=0;
			for (int k=0;k<money.length;k++){
				eds.setExpense_id(id);
				int j=eas.updateMx(eds);//先删除掉details表中的expense_id的数据
			}
			for(int a=0;a<money.length;a++){
				eds.setExpense_details_amount(Double.parseDouble(money[a]));
				eds.setExpense_id(id);
				in=eas.insertdet(eds);//向details表中添加expense_id的数据
			}
				return listmyshow(request);
		}
	//时间转换
	@InitBinder
	public void initBinder(ServletRequestDataBinder bin) {
		bin.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
}

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,org.zh.entity.Menu_info"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<link href="res/dtree/dtree.css" rel="stylesheet"/>
<script type="text/javascript" src="res/dtree/dtree.js"></script>
</head>
<body>
<div>
	<script type="text/javascript">
		var d = new dTree('d');
		/* d.add(0,-1,"跟节点","menu/menumain.do","","rightframe"); */
		<% List<Menu_info> list = (List<Menu_info>)request.getAttribute("list");
		if(list!=null && list.size()>0){
		for(Menu_info menu:list){
		%>
		d.add(<%=menu.getMenu_id()%>,<%=menu.getPrent_menu_id()%>,"<%=menu.getMenu_name()%>","menu/mmd.do?menu_id=<%=menu.getMenu_id()%>","","rightframe");
		<%}}%>
		document.write(d);
	</script>

</div>
</body>
</html>
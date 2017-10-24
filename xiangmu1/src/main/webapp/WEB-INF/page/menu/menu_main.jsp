<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<link rel="stylesheet" href="res/css/bootstrap.css">
<script type="text/javascript" src="res/js/jquery.min.js"></script>
<script type="text/javascript" src="res/js/bootstrap.min.js"></script>
<!-- <script type="text/javascript">
	$(function() {
		$("#delete").click(function() {
			var ids = $("input[id=ids]:checked");
			if (ids.length != 1) {
				//提交表单
				var f1 = $("#f1");
				f1.attr("action", "menu/delete.do");
				f1.submit();

			}else {
				alert("只能选择一个进行删除");
			}
		}); 
		});
	})
</script> -->
</head>
<body>
	<a href="menu/loadadd.do?menu_id=${mo.menu_id}" class="btn btn-info">添加下级菜单</a>
	<a href="menu/loadupdate.do?menu_id=${mo.menu_id}" class="btn btn-primary">修改菜单</a>
	<a href="menu/delete.do?menu_id=${mo.menu_id}" class="btn btn-danger">删除菜单</a>
	<!-- <input type="button" id="delete" class="btn btn-danger">删除菜单</a> -->
	<h5 class="page-header alert-info"
		style="margin: 0px; padding: 10px; margin-bottom: 10px">菜单详细信息</h5>
	<div class="row">
		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-sm-3 control-label">菜单名称</label>
				<div class="col-sm-9">
					<p class="form-control-static">系统管理</p>
				</div>
			</div>
		</div>
		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-sm-3 control-label">上级菜单</label>
				<div class="col-sm-5">
					<p class="form-control-static">${mo1.menu_name}</p>
				</div>
			</div>
		</div>
		<div class="col-sm-12">
			<div class="form-group">
				<label class="col-sm-3 control-label">菜单地址</label>
				<div class="col-sm-5">
					<p class="form-control-static">${mo.menu_url}</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
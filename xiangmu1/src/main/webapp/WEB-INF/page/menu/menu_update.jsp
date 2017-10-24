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

</head>
<body>
	<form action="menu/update.do" method="post" class="form-horizontal">
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px">菜单基本信息</h5>
		<div class="row">
			<div class="col-sm-6">
				<div class="form-group">
					<label class="col-sm-3 control-label">菜单名称</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" name="menu_name"
							placeholder="${mo.menu_name}" />
					</div>
				</div>
			</div>
			<input type="hidden" value="${mo.menu_id}" name="menu_id">
			<div class="col-sm-6">
				<div class="form-group">
					<label class="col-sm-3 control-label">父级菜单</label>
					<div class="col-sm-5">
						<select name="prent_menu_id" class="form-control">
						 <option selected="selected" value="${mo1.menu_id}">${mo1.menu_name}</option>
							<c:forEach var="me" items="${list}">
							<option value="${me.menu_id}">${me.menu_name}</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<div class="col-sm-12">
				<div class="form-group">
					<label class="col-sm-3 control-label">菜单地址</label>
					<div class="col-sm-7">
						<input type="text" class="form-control" name="menu_url"
							placeholder="${mo.menu_url}" />
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-10" align="center">
				<input type="submit" value="修改菜单" class="btn btn-success" />
			</div>
		</div>
	</form>
</body>
</html>
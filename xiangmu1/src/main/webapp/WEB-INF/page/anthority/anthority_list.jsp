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
<title>角色查询</title>
<link rel="stylesheet" href="res/css/bootstrap.css">
<script type="text/javascript" src="res/js/jquery.min.js"></script>
<script type="text/javascript" src="res/js/bootstrap.min.js"></script>


</head>
<body>
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px; padding-left: 20px;">
			<li>系统管理</li>
			<li>权限管理</li>
			<li>查询角色</li>
		</ul>
	</div>
	<form action="anthority/like.do" method="post" id="f1" class="form-inline">
		<div class="row alert alert-info" style="margin: 0px; padding: 5px;">
			<div class="form-group">
				<label>角色名称</label> <input type="text" class="form-control"
					name="role_name" placeholder="请输入角色名称" />
			</div>
			<input type="submit" value="查询角色" class="btn btn-success" /> 
		</div>

		<div class="row" style="padding: 15px;">
			<table class="table ">
				<tr>
					<th><input type="checkbox" onclick="checkboxfun(this)" /></th>
					<th>角色编号</th>
					<th>角色名称</th>
					<th>角色描述</th>
					<th>权限变更</th>
				</tr>
				<c:forEach var="ro" items="${list}">
				<c:if test="${ro.role_mark=='1'}">
				<tr>
					<td><input type="checkbox" id="roleids" value="${ro.role_id}" /></td>
					<td>${ro.role_id}</td>
					<td>${ro.role_name}</td>
					<td>${ro.role_desc}</td>
					<td><a href="anthority/change.do?id=${ro.role_id}">权限变更</a></td>
				</tr>
				</c:if>
				</c:forEach>
			</table>

		</div>
	</form>
</body>
</html>
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
<title>报销单审核</title>
<link rel="stylesheet" href="res/css/bootstrap.css">
<script type="text/javascript" src="res/js/jquery.min.js"></script>
<script type="text/javascript" src="res/js/bootstrap.min.js"></script>
 <script type="text/javascript"
	src="<%=basePath%>res/My97DatePicker/WdatePicker.js">
</script>
</head>
<body>
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px; padding-left: 20px;">
			<li>报销管理</li>
			<li>审核管理</li>
			<li>财务审核</li>
		</ul>
	</div>
	<form action="expense/likeCW.do" method="post" id="f1" class="form-inline">
		<div class="row alert alert-info" style="margin: 0px; padding: 5px;">
			<div class="form-group">
				<label>报销人</label> <input type="text" class="form-control"
					name="name" placeholder="请输入报销人" />
					<label>报销时间</label> <input type="text" class="form-control"
					name="expense_time" placeholder="请输入报销时间"  autocomplete="off" onclick="WdatePicker()"/>	
			</div>
			<input type="submit" value="查询报销单" class="btn btn-success" />
		</div>

		<div class="row" style="padding: 15px;">
			<table class="table ">
				<tr>
					
					<th>报销编号</th>
					<th>报销原因</th>
					<th>报销人</th>
					<th>报销时间</th>
					<th>报销总金额</th>
					<th>审核</th>
				</tr>
				<c:forEach var="list" items="${list}">
				<c:if test="${list.expense_state=='1'}">
				<tr>
					<td>${list.expense_id }</td>
					<td>${list.expense_name}</td>
					<td>${list.user_name }</td>
					<td>${list.expense_time}</td>
					<td>${list.expense_total}</td>
					<th><a href="expense/CShenHe.do?expense_id=${list.expense_id }">审核</a></th>
				</tr>
				</c:if>
				</c:forEach>
			</table>

		</div>
	</form>
</body>
</html>
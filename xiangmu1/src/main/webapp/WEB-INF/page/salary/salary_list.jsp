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
<title>薪资发放查询</title>
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
			<li>薪资管理</li>
			<li>薪资发放查询</li>
		</ul>
	</div>
	<form action="salary/like.do" method="post" id="f1" class="form-inline">
		<div class="row alert alert-info" style="margin: 0px; padding: 5px;">
			<div class="form-group">
				<label>领取人</label> <input type="text" class="form-control" name="name"
					placeholder="请输入领取人" /> <label>发放时间</label> <input type="text"
					class="form-control" name="payment_time" placeholder="请输入发放时间"  
					autocomplete="off" onclick="WdatePicker()" />
			</div>
			<input type="submit" value="查询" class="btn btn-success" />
			<!-- <input type="button" value="导入Excel" class="btn btn-success" /> -->
			<a href="salary/loadExcel.do" class="btn btn-success">导入Excel</a>
		</div>

		<div class="row" style="padding: 15px;">
			<table class="table ">
				<tr>

					<th>编号</th>
					<th>领取人</th>
					<th>发放时间</th>
					<th>发放金额</th>
			
				</tr>
				<c:forEach var="sa" items="${list}">
				<tr>
					<td>${sa.payment_id}</td>
					<td>${sa.user_name}</td>
					<td>${sa.payment_time}</td>
					<td>${sa.payment_money}</td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</form>
</body>
</html>
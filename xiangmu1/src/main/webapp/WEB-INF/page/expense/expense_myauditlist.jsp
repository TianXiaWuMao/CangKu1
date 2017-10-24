<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>我的报销单</title>
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
			<li>我的审核</li>
		</ul>
	</div>
	<form action="" method="post" id="f1" class="form-inline">
		<div class="row alert alert-info" style="margin: 0px; padding: 5px;">
			<div class="form-group">
						<label>报销人</label> <input type="text" class="form-control"
					name="roleName" placeholder="请输入报销人" /> 
				<label>报销时间</label> <input type="text" class="form-control"
					name="roleName" placeholder="请输入报销时间"  autocomplete="off" onclick="WdatePicker()"  />
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
					<th>查看明细</th>
				</tr>
				<tr>
					<td>1001</td>
					<td>服务器维护</td>
					<td>张三</td>
					<td>2016-12-12</td>
					<td>￥5000.0</td>
					<th><a href="expense/show.do">查看明细</a></th>
				</tr>
				<tr>
					<td>1001</td>
					<td>服务器维护</td>
					<td>张三</td>
					<td>2016-12-12</td>
					<td>￥5000.0</td>
					<th><a href="expense/show.do">查看明细</a></th>
				</tr>
				<tr>
					<td>1001</td>
					<td>服务器维护</td>
					<td>张三</td>
					<td>2016-12-12</td>
					<td>￥5000.0</td>
					<th><a href="expense/show.do">查看明细</a></th>
				</tr>
			</table>

		</div>
	</form>
</body>
</html>
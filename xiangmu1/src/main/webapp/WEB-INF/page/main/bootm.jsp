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
<title>Insert title here</title>
<link rel="stylesheet" href="res/css/bootstrap.css">
</head>
<body>

	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="padding: 0px; padding-left: 20px;">
			<li>首页</li>
			<li>工作台</li>
		</ul>
	</div>

	<div class="row " style="padding: 1px; margin: 0px;">
		<div class="col-sm-8">
			<div class="panel panel-default">
				<div class="panel-heading" style="padding: 3px; height: 30px;">
					<span class="glyphicon glyphicon-refresh"></span>报销报表
				</div>
				<div class="panel-body">
					<img src="res/img/03.png" width="100%" />
				</div>
			</div>
		</div>
		<div class="col-sm-4">
			<div class="panel panel-default">
				<div class="panel-heading" style="padding: 3px; height: 30px;">
					<span class="glyphicon glyphicon-refresh"></span>关键试图
				</div>
				<table class="table table-bordered">
					<tr>
						<th>月份</th>
						<th>报销</th>
						<th>人数</th>
					</tr>

					<tr>
						<td>2016-10-10</td>
						<td>张三</td>
						<td>1</td>
					
					</tr>
							<tr>
						<td>2016-10-10</td>
						<td>张三</td>
						<td>1</td>
					
					</tr>		<tr>
						<td>2016-10-10</td>
						<td>张三</td>
						<td>1</td>
					
					</tr>
				</table>
			</div>
		</div>

<div class="col-sm-8">
			<div class="panel panel-default">
				<div class="panel-heading" style="padding: 3px; height: 30px;">
					<span class="glyphicon glyphicon-refresh"></span>报销报表
				</div>
				<div class="panel-body">
					<img src="res/img/03.png" width="100%" />
				</div>
			</div>
		</div>
		<div class="col-sm-4">
			<div class="panel panel-default">
				<div class="panel-heading" style="padding: 3px; height: 30px;">
					<span class="glyphicon glyphicon-refresh"></span>关键试图
				</div>
				<table class="table table-bordered">
					<tr>
						<th>月份</th>
						<th>报销</th>
						<th>人数</th>
					</tr>

					<tr>
						<td>2016-10-10</td>
						<td>张三</td>
						<td>1</td>
					
					</tr>
							<tr>
						<td>2016-10-10</td>
						<td>张三</td>
						<td>1</td>
					
					</tr>		<tr>
						<td>2016-10-10</td>
						<td>张三</td>
						<td>1</td>
					
					</tr>
				</table>
			</div>
		</div>
	</div>



</body>
</html>
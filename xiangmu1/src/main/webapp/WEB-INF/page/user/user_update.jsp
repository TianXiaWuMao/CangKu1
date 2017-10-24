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
<title>用户修改</title>
<link rel="stylesheet" href="res/css/bootstrap.css">
<script type="text/javascript" src="res/js/jquery.min.js"></script>
<script type="text/javascript" src="res/js/bootstrap.min.js"></script>
</head>
<body>
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px; padding-left: 20px;">
			<li>系统管理</li>
			<li>用户管理</li>
			<li>修改用户</li>
		</ul>
	</div>
	<form action="user/update.do" method="post" class="form-horizontal">
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px">用户基本信息</h5>
			<input type="hidden" value=${user.user_id} name="user_id">
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">用户姓名</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" name="user_name"
							 value=${user.user_name} />
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">用户性别</label>
					<div class="col-sm-5">
						<select name="user_sex" class="form-control">
							<option>保密</option>
							<option selected="selected">${user.user_sex}</option>
							<option>女</option>
							<option>男</option>
						</select>
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">用户年龄</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" name="user_age"
							value= ${user.user_age}>
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">薪资</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" name="user_salary"
							 value=${user.user_salary}>
					</div>
				</div>
			</div>
		</div>
			<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px">账号信息</h5>
			<div class="row">
					<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">用户账号</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" name="user_account"
							 value=${user.user_account}>
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">用户密码</label>
					<div class="col-sm-9">
						<input type="password" class="form-control" name="user_password"
							 value=${user.user_password}>
					</div>
				</div>
			</div>
			
			</div>
		<div class="row">
			<div class="col-sm-10" align="center">
				<input type="submit" value="修改用户" class="btn btn-success" /> <a
					href="user/listAll.do" class="btn btn-danger">返回上一级</a>
			</div>
		</div>
	</form>

</body>
</html>
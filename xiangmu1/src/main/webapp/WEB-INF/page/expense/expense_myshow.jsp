<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
			<li>报销查询</li>
		</ul>
	</div>
	<form action="" method="post" class="form-horizontal">
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px">报销单基本信息</h5>
		<div class="row">
			<div class="col-sm-7">
				<div class="form-group">
					<label class="col-sm-3 control-label">报销原因</label>
					<div class="col-sm-9">
						<p class="form-control-static">${listexp.expense_name}</p>
					</div>
				</div>
			</div>
			<div class="col-sm-7">
				<div class="form-group">
					<label class="col-sm-3 control-label">报销时间</label>
					<div class="col-sm-9">
						<p class="form-control-static"><fmt:formatDate value="${listexp.expense_time }"/> </p>
					</div>
				</div>
			</div>
			<div class="col-sm-7">
				<div class="form-group">
					<label class="col-sm-3 control-label">报销总金额</label>
					<div class="col-sm-9">
						<p class="form-control-static">${listexp.expense_total}</p>
					</div>
				</div>
			</div>
			<div class="col-sm-7">
				<div class="form-group">
					<label class="col-sm-3 control-label">报销详情</label>
					<div class="col-sm-9">
						<p class="form-control-static">${listexp.expense_desc}</p>
					</div>
				</div>
			</div>
		</div>
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px">报销单明细</h5>
		<table class="table" id="tab1">
			<tr>
				<th>费用名称</th>
				<th>费用说明</th>
				<th>具体金额</th>
			</tr>
		<c:forEach var="list" items="${list}" >
			<tr>
				<td>${list.cost_name}</td>
				<td>${list.cost_desc }</td>
				<td>${list.expense_details_amount}</td>
			</tr>
			</c:forEach>
		</table>
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px">审核历史记录信息</h5>
		<table class="table">
			<tr>
				<th>审核编号</th>
				<th>审核人</th>
				<th>审核状态</th>
				<th>审核时间</th>
				<th>审核描述</th>
			</tr>
			<c:forEach var="listh" items="${listh}">
			<tr>
				<td>${listh.expense_id}</td>
				<td>${listh.user_name }</td>
				<td>
					<c:if test="${listh.expense_state=='del' }"><p class="btn btn-info btn-xs">作废</p></c:if>
					<c:if test="${listh.expense_state=='0' }"><p class="btn btn-success btn-xs">等待经理审核</p></c:if>
					<c:if test="${listh.expense_state=='-1' }"><p class="btn btn-info btn-xs">经理未通过</p></c:if>
					<c:if test="${listh.expense_state=='1' }"><p class="btn btn-success btn-xs">等待财务审核</p></c:if>
					<c:if test="${listh.expense_state=='-2' }"><p class="btn btn-info btn-xs">财务未通过</p></c:if>
					<c:if test="${listh.expense_state=='2' }"><p class="btn btn-success btn-xs">通过</p></c:if>
				</td>
				<td>${listh.audit_time}</td>
				<td>${listh.audit_desc}</td>
			</tr>
			</c:forEach>
		</table>
		<div class="row">
			<div class="col-sm-7" align="center">
				<a href="expense/mylist.do" class="btn btn-info">返回上一级</a>
			</div>
		</div>
	</form>
</body>
</html>
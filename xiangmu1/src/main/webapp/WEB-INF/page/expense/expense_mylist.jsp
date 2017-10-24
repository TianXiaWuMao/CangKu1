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
			<li>我的报销单</li>
		</ul>
	</div>
		<form action="expense/list.do" method="post" id="f1" class="form-inline">
		<div class="row alert alert-info" style="margin: 0px; padding: 5px;">
			<div class="form-group">
				<label>报销时间</label> <input type="text" class="form-control"
					name="expense_time" placeholder="请输入报销时间"  autocomplete="off" onclick="WdatePicker()" />
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
					<th>审核状态</th>
					<th>操作</th>
				</tr>
				<c:forEach var="list" items="${list}">
				<tr>
					<td>${list.expense_id }</td>
					<td>${list.expense_desc }</td>
					<td>${list.user_name }</td>
					<td>${list.expense_time }</td>
					<td>${list.expense_total }</td>
					<td>
						<c:if test="${list.expense_state=='del' }"><p class="btn btn-info btn-xs">作废</p></c:if>
						<c:if test="${list.expense_state=='0' }"><p class="btn btn-success btn-xs">等待经理审核</p></c:if>
						<c:if test="${list.expense_state=='-1' }"><p class="btn btn-info btn-xs">经理未通过</p></c:if>
						<c:if test="${list.expense_state=='1' }"><p class="btn btn-success btn-xs">等待财务审核</p></c:if>
						<c:if test="${list.expense_state=='-2' }"><p class="btn btn-info btn-xs">财务未通过</p></c:if>
						<c:if test="${list.expense_state=='2' }"><p class="btn btn-success btn-xs">通过</p></c:if>
					</td>
					<th>
					<c:if test="${list.expense_state=='del' }"><a href="expense/myshow.do?id=${list.expense_id }"></a></c:if>
					<c:if test="${list.expense_state=='0' }"><a href="expense/updatelist.do?id=${list.expense_id }">修改</a></c:if>
					<c:if test="${list.expense_state=='-1' }"><a href="expense/updatelist.do?id=${list.expense_id }">修改</a></c:if>
					<c:if test="${list.expense_state=='1' }"><a href="expense/myshow.do?id=${list.expense_id }">查看明细</a></c:if>
					<c:if test="${list.expense_state=='2' }"><a href="expense/myshow.do?id=${list.expense_id }">查看明细</a></c:if>
					<c:if test="${list.expense_state=='-2' }"><a href="expense/updatelist.do?id=${list.expense_id }">修改</a></c:if>
					</th>
				</tr>
				</c:forEach>

			</table>

		</div>
	</form>
</body>
</html>
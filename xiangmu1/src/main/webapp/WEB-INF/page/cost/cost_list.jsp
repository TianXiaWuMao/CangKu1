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
<title>费用查询</title>
<link rel="stylesheet" href="res/css/bootstrap.css">
<script type="text/javascript" src="res/js/jquery.min.js"></script>
<script type="text/javascript" src="res/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function() {

		//给修改按钮绑定事件
		$("#update").click(function() {
			var costids = $("input[id=costids]:checked");
			if (costids.length == 1) {
				//提交表单
				var f1 = $("#f1");
				f1.attr("action", "cost/loadupdate.do");
				f1.submit();

			} else {
				alert("必须选自一个（只能有一个）进行修改");
			}
		});

		//给删除按钮绑定事件
		$("#delete").click(function() {
			if (confirm("您确定要删除费用吗")) {
				//提交表单
				var f1 = $("#f1");
				f1.attr("action", "cost/delete.do");
				f1.submit();
			}
		});

	});

	//checkboxfun 实现全选货全不选
	function checkboxfun(v) {
		//alert(v.checked);
		var costids = $("input[id=costids]");
		//遍历所有的checkbox
		costids.each(function(i) {
			//设置checked的值
			this.checked = v.checked;

			//	$(this).attr("checked",v.checked);
		});
	}
</script>

</head>
<body>
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px; padding-left: 20px;">
			<li>系统管理</li>
			<li>费用管理</li>
			<li>查询费用</li>
		</ul>
	</div>
	<form action="cost/like.do" method="post" id="f1" class="form-inline">
		<div class="row alert alert-info" style="margin: 0px; padding: 5px;">
			<div class="form-group">
				<label>费用名称</label> <input type="text" class="form-control"
					name="cost_name" placeholder="请输入费用名称" />
			</div>
			<input type="submit" value="查询费用" class="btn btn-success" /> <a
				href="cost/loadAdd.do" class="btn btn-info">添加费用</a> <input
				type="button" id="update" value="修改费用" class="btn btn-primary" /> <input
				type="button" id="delete" value="删除费用" class="btn btn-danger" />
		</div>

		<div class="row" style="padding: 15px;">
			<table class="table ">
				<tr>
					<th><input type="checkbox" onclick="checkboxfun(this)" /></th>
					<th>费用编号</th>
					<th>费用名称</th>
					<th>费用描述</th>

				</tr>
				<c:forEach var="list" items="${list }">
				<c:if test="${list.cost_mark=='1' }">
				<tr>
					<td><input type="checkbox" id="costids" name="ids" value="${list.cost_id }"/></td>
					<td>${list.cost_id }</td>
					<td>${list.cost_name }</td>
					<td>${list.cost_desc }</td>
				</tr>
				</c:if>
				</c:forEach>
			</table>

		</div>
	</form>
</body>
</html>
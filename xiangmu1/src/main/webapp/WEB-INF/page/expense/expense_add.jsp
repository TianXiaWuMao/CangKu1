<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>报销单</title>
<link rel="stylesheet" href="res/css/bootstrap.css">
<script type="text/javascript" src="res/js/jquery.min.js"></script>
<script type="text/javascript" src="res/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>res/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	$(function() {
		$("#selected")
				.click(
						function() {

							//获取table
							var tab1 = $("#tab1");

							var ids = $("input[id=ids]:checked");

							ids
									.each(function() {
										var costId = $(this).val();

										var td = $(this).parent().parent()
												.find("td");

										tab1
												.append("<tr><td>"
														+ td[2].innerHTML
														+ "</td><td>"
														+ td[3].innerHTML
														+ "<input type='hidden' name='ids' value='"+costId+"'>"
														+ "</td><td><input type='text' id='memony' onblur='total()' name='eda'></td></tr>");

									});
							//隐藏模态框
							$("#myModal").modal('hide');

						});

	});

	//计算报销总金额
	function total() {
		var sum = 0;

		$("input[id=memony]").each(function() {

			sum = sum + parseFloat($(this).val());
		});

		$("input[name=expense_total]").val(sum);
	}
</script>
</head>
<body>
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px; padding-left: 20px;">
			<li>报销管理</li>
			<li>报销单</li>

		</ul>
	</div>

	<div class="alert alert-warning alert-dismissible"
		style="display: ${errorinfo==null?'none':'block' };" role="alert">
		<button type="button" class="close" data-dismiss="alert"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
		<div align="center" style="color: red;">${errorinfo }</div>
	</div>
	<form action="expense/insert.do" method="post" class="form-horizontal">
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px">报销单基本信息</h5>
		<div class="row">
			<div class="col-sm-7">
				<div class="form-group">
					<label class="col-sm-3 control-label">报销原因</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" name="expense_name"
							placeholder="请输入报销原因" />
					</div>
				</div>
			</div>
			<div class="col-sm-7">
				<div class="form-group">
					<label class="col-sm-3 control-label">报销时间</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" name="expense_time"
							placeholder="请输入报销报销时间" onclick="WdatePicker()" />
					</div>
				</div>
			</div>
			<div class="col-sm-7">
				<div class="form-group">
					<label class="col-sm-3 control-label">报销总金额</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" name="expense_total"
							placeholder="请输入报销总金额" readOnly="readonly" />
					</div>
				</div>
			</div>
			<div class="col-sm-7">
				<div class="form-group">
					<label class="col-sm-3 control-label">报销详情</label>
					<div class="col-sm-9">
						<textarea rows="" cols="" class="form-control"
							placeholder="请输入报销详情" name="expense_desc"></textarea>
					</div>
				</div>
			</div>
		</div>
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px">
			报销单明细 <input type="button" class="btn btn-primary btn-xs"
				value="选择费用明细" data-toggle="modal" data-target="#myModal" />
		</h5>
		<table class="table" id="tab1">
			<tr>
				<th>费用名称</th>
				<th>费用说明</th>
				<th>具体金额</th>
			</tr>

		</table>

		<div class="row">
			<div class="col-sm-7" align="center">
				<input type="submit" value="提交报销单" class="btn btn-success" />

			</div>
		</div>
	</form>
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">费用明细</h4>
				</div>
				<div class="modal-body">
					<table class="table " id="tab2">
						<tr>
							<th></th>
							<th>费用编号</th>
							<th>费用名称</th>
							<th>费用描述</th>

						</tr>

						<c:forEach var="list" items="${list}">
						<tr>
							<td><input type="checkbox" id="ids" value="${list.cost_id }" name="ids" /></td>
							<td>${list.cost_id}</td>
							<td>${list.cost_name }</td>
							<td>${list.cost_desc }</td>
						</tr>
						</c:forEach>

					</table>
				</div>
				<div class="modal-footer">
					<button type="button" id="selected" class="btn btn-primary">选择</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>

				</div>
			</div>
		</div>
	</div>




</body>
</html>
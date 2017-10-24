<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>权限变更</title>
<link rel="stylesheet" href="res/css/bootstrap.css">
<script type="text/javascript" src="res/js/jquery.min.js"></script>
<script type="text/javascript" src="res/js/bootstrap.min.js"></script>
<!-- <script type="text/javascript">
//checkboxfun 实现全选或全不选
function checkboxfun(v) {
	//alert(v.checked);
	var ids = $("input[id=ids]");
	//遍历所有的checkbox
	ids.each(function(i) {
		//设置checked的值
		this.checked = v.checked;
	});
}
</script> -->

</head>
<body>
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px; padding-left: 20px;">
			<li>系统管理</li>
			<li>权限管理</li>
			<li>权限变更</li>
		</ul>
	</div>
	<form action="anthority/update.do" method="post" id="f1"
		class="form-inline">
		<div class="row alert alert-info" style="margin: 0px; padding: 10px;">
			
			<h4 align="center">${role.role_name }</h4>
		</div>

		<div class="row" style="padding: 15px;">
			<table class="table ">
				<tr>

					<th>第一级菜单</th>
					<th>第二级菜单</th>

				</tr>
				
				<c:forEach var="listM" items="${listM}">
			
					<c:if test="${listM.prent_menu_id==0}">
						<tr>
							<td>
							<input type="hidden" value="${rid}" name="rid"/>
							<input type="checkbox" value="${listM.menu_id }" name="ids"
							<c:forEach var="listRM" items="${listRM}" >
								<c:if test="${listRM.menu_id==listM.menu_id}">
									checked
								</c:if>
							</c:forEach>
						 />${listM.menu_name}
							</td>
							<td><c:forEach var="listM1" items="${listM1 }">
									<c:if test="${listM1.prent_menu_id==listM.menu_id }">
										<input type="checkbox" value="${listM1.menu_id}" name="ids" id="ids" onclick="checkboxfun(this)"
											<c:forEach var="listRM" items="${listRM }">
										<c:if test="${listRM.menu_id==listM1.menu_id}">
											checked
										</c:if>
									</c:forEach> 
									/> ${listM1.menu_name}
								</c:if>
								</c:forEach>
								</td>
						</tr>
					</c:if>
				</c:forEach>

			</table>
		</div>
		<input type="submit" value="修改权限" class="btn btn-primary">
	</form>
</body>
</html>
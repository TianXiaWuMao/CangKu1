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
<title>Insert title here</title>
<script src="res/js/jquery.min.js" type="text/javascript"></script>
<script src="res/js/highcharts.js" type="text/javascript"></script>
<script src="res/js/jquery.highchartTable.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function() {
  $('table.highchart').highchartTable();
});
</script>

</head>
<body>
<table class="highchart" data-graph-container-before="1" data-graph-type="line" style="display:none" >
  <thead>
      <tr>
          <th>月份</th>
          <th>工资</th>
      </tr>
   </thead>
   <tbody >
   <c:forEach var="list" items="${list}">
   		<tr>
          <td>${list.payment_time}</td>
          <td>${list.payment_money}</td>     
      </tr>
   </c:forEach>
  </tbody>
</table>
</body>
</html>
</html>
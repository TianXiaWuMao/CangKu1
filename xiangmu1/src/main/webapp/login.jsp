<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<head>
<base href="<%=basePath%>">
<title>用户登录</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="res/login/css/style.css" rel='stylesheet' type='text/css' />
<script src="res/yz/libs/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="res/yz/js/index.js" type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="res/yz/css/index.css">
<script>

</script>
<script type="text/javascript">
	$(function(){
		//验证码
//		 验证码刷新
		function code(){
			var str="qwertyuiopasdfghjklzxcvbnm123456789QWERTYUIOPLKJHGFDSAZXCVBNM";
			var str1=0;
			for(var i=0; i<4;i++){
				str1+=str.charAt(Math.floor(Math.random()*62)) 
			}
			str1=str1.substring(1)
			$("#code").text(str1);
		}
		code();
		$("#code").click(code);	
//		验证码验证
		$('#yz').blur(function(){
			if($(this).val().length==0){
				$(this).next().next("div").text("");
				$(this).next().next("div").css("color",'#0e7646');
			}else if($(this).val().toUpperCase()!=$("#code").text().toUpperCase()){
				$(this).next().next("div").text("验证码不正确");
				$(this).next().next("div").css("color",'red');
			}else{
				$(this).next().next("div").text("");
			}		
		});
	</script>
</head>
<body>
<form action="user/login.do" method="post">
 <h1>智达教育费用系统</h1>
<div class="login-form">
		<div class="head-info">
			<label class="lbl-1"> </label>
			<label class="lbl-2"> </label>
			<label class="lbl-3"> </label>
		</div>
			<div class="clear"> </div>
	<div class="avtar" style="text-align: center">
		<img src="res/login/images/avtar.png" />
		<c:if test="${msg!=null}">
			<div style="color:red" id="tsxx">${msg}</div>
		</c:if>
	</div>
					<div class="key">
					<input type="text" class="text" id="zh" placeholder="请输入账号" name="user_account" >
					<span class="tips"></span>
					<input type="password" placeholder="请输入密码" name="user_password">
					<span class="tips"></span>
					<input id="yz" maxlength="20" type="text" placeholder="请输入验证码" autocomplete="off">
					<span id="code"></span>
					<div class="tips" id="fhxx">
					</div>
	<div class="signin">
		<input type="submit" id="submit_btn" value="Login" >
	</div>
		</div>
</div>
</form>
</body>
</html>
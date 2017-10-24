$(function(){
	var stuList = getStuList();//设置传送信息：学生的集合
	 
	//聚焦失焦input
	$('input').click(function(){
		$("#tsxx").text("");
	})

	$('input').eq(2).focus(function(){	
		if($(this).val().length==0){
			$(this).next().next("div").text("看不清？点击图片更换验证码");
			$(this).next().next("div").css("color",'red');
		}
	})
	//input各种判断
	//用户名：
	$('input').eq(0).blur(function(){
		if($(this).val().length==0){
			$(this).next("span").text("账号不为空");
			$(this).next("span").css("color",'red');
		}else{
			$(this).next("span").text("");
		}		
	})
	//密码
	$('input').eq(1).blur(function(){
		if($(this).val().length==0){
			$(this).next("span").text("密码不为空");
			$(this).next("span").css("color",'red');
		}else{
			$(this).next("span").text("");
		}		
	})
// 	验证码
//	 验证码刷新
	function code(){
		var str="qwertyuiopasdfghjklzxcvbnm1234567890QWERTYUIOPLKJHGFDSAZXCVBNM";
		var str1=0;
		for(var i=0; i<4;i++){
			str1+=str.charAt(Math.floor(Math.random()*62)) 
		}
		str1=str1.substring(1)
		$("#code").text(str1);
	}
	code();
	$("#code").click(code);	
//	验证码验证
	$('input').eq(2).blur(function(){
		if($(this).val().length==0){
			$(this).next().next("div").text("验证码不为空");
			$(this).next().next("div").css("color",'red');
		}else if($(this).val().toUpperCase()!=$("#code").text().toUpperCase()){
			$(this).next().next("div").text("验证码不正确");
			$(this).next().next("div").css("color",'red');
		}else{
			$(this).next().next("div").text("");
		}		
	})
//	提交按钮
	$("#submit_btn").click(function(e){		
		for(var j=0 ;j<3;j++){
			if($('input').eq(j).val().length==0){				
				$('input').eq(j).focus();				
				if(j==0){
					$('input').eq(j).next().next("span").text("此处不能为空");
					$('input').eq(j).next().next("span").css("color",'red');
					e.preventDefault();
					return;
				}
				$('input').eq(j).next().next(".tips").text("请输入验证码");
				$('input').eq(j).next().next(".tips").css("color",'red');	
				e.preventDefault();
				return;
			}			
		}
		if($('input').eq(2).val().toUpperCase()!=$("#code").text().toUpperCase()){
			e.preventDefault();
		}
	})	
//	获取之前所有已经注册的用户集合
	function getStuList(){
	    var list = localStorage.getItem('stuList');
	    if(list != null){
	        return JSON.parse(list);
	    }else{
	        return new Array();
	    }
	}
})

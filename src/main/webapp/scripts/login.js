
//验证账号和密码的js
$(function(){
	$("#count").focus().blur(checkName);
	$("#password").blur(checkPassword);
	$("#login").click(login);
	$("#regist_button").click(regist);
})

function checkName(){
	console.log("checkName");
	var name=$("#count").val();
	console.log(name);
	if(!name.trim()){
		$("#count_msg").empty().html("不能是空的");
		return false;
	}
	var reg=/^\w{3,10}$/;
	if(!reg.test(name)){
		$("#count_msg").empty().html("必须是3位到10位");
		return false;
	}
	$("#count_msg").empty();
	return true;
}
function checkPassword(){
	console.log("checkPassword");
	var password=$("#password").val();
	if(!password){
		$("#password_msg").empty().html("不能是空");
		return false;
	}
	var reg=/^\w{3,10}$/;
	if(!reg.test(password.trim())){
		$("#password_msg").empty().html("必须是3~10位");
		return false;
	}
	$("#passwrod_msg").empty();
	return true;
}
function login(){
	console.log("login");
	if(!checkName()+checkPassword()==2){
		return;
	}
	var name=$("#count").val();
	var password=$("#password").val();
	var url="user/login.do";
	var param={"name":name,"password":password};
	$.post(url,param,function(result){
		if(result.state==0){
			console.log("成功");
			var user=result.data;
			var userId=user.id;
			setCookie("userId",userId);
			console.log(result.data.id);
			location.href="edit.html";
			return ;
		}
		if(result.state==2){
			$("#count_msg").empty().html(result.msg);
			return ;
		}
		if(result.state==3){
			$("#password_msg").empty().html(result.msg);
			return;
		}
		alert(result.msg);
	})
}

function regist(){
	console.log("regist");
	var name=$("#regist_username").val();
	var password=$("#regist_password").val();
	var nick=$("#nickname").val();
	var confirm=$("#final_password").val();
	var url="user/regist.do";
	var param={"name":name,"password":password,"nick":nick,"confirm":confirm};
	$.post(url,param,function(result){
		if(result.state==0){
			console.log("成功");
			$("#back").click();
			var user = result.data;
			$("#count").val(user.name);
			$("#count_msg").empty();
			$("#password").focus();
		}
		else if(result.state==2){
			//用户名问题
			$("#warning_1").html(result.msg);
			$("#warning_1").show();
		}
		else if(result.state==3){
			//密码问题
			$("#warning_2").html(result.msg);
			$("#warning_2").show();
		}else{
			alert(result.msg);
		}
	})
}








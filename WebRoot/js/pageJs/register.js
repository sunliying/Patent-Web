$(function(){
	var password = $(".password")[0];
	var identify_password = $(".identify_password")[0];
	var form = $(".form1")[0];

	form.onsubmit = function(){
		if (password.value!=identify_password.value) {
			$(".pwdiff").text("两次密码不一样,请重新输入!!!");
			return false;
		}else{
			document.getElementById("form1").action="ParentsSearcher?service=register";
		}
	};
});
$(document).ready(function(){
	$("#btn-cancle").click(function(){
		if(confirm("取消并回到首页")){
	        document.location.href=("/Exam7/customer/index.do");
	    }
	});
});

function check(form) {
	if ($("#input-first-name").val() == "") {
		alert("First Name不能为空");
		$("#input-first-name").focus();
		return false;
	} else if ($("#input-last-name").val() == "") {
		alert("Last Name不能为空");
		$("#input-last-name").focus();
		return false;
	}
}
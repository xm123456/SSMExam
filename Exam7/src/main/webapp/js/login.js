$(document).ready(function () {
    $('#loginmodal').modal('show');
    $('#myModal').on('shown.bs.modal', function() {
		$('#myInput').focus()
	})
});
function check(form) {
	if (document.forms.loginForm.name.value == "") {
		alert("用户名不能为空");
		document.forms.loginForm.name.focus();
		return false;
	}
	if (document.forms.loginForm.password.value == "") {
		alert("密码不能为空");
		document.forms.loginForm.name.focus();
		return false;
	}
};

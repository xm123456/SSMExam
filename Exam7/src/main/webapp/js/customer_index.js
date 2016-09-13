var customerCount;
var pageNum;
var pageCount;

$(document).ready(
		function() {
			gotoPage(1);
			$("#newCustomer").click(function() {
				getCustomerCount();
			});
			$("#btn-goto").click(
					function() {
						var gotostr = $("#page-num").val();
						var pattern = /[1-9]\d*/;
						if (pattern.test(gotostr) && checkPageNum(gotostr)
								&& gotostr <= pageCount) {
							gotoPage(gotostr * 1);
						} else {
							alert("页码格式不正确");
						}
					});
			$("#btn-go-pre").click(function() {
				gotoPage(pageNum - 1);
			});
			$("#btn-go-next").click(function() {
				gotoPage(pageNum + 1);
			});
		});

function getAndBindCustomers(page) {
	var url = "/Exam7/customer/ajaxGetCustomerInPage";
	var args = {
		"pageNum" : "" + page
	};
	$.post(url, args, function(data) {
		var customers = eval('('+data+')');
		$("#datas").empty();
		for (var i = 0; i < customers.length; i++) {
			$("#datas").append(
					'<tr><td><a href="#" onclick="do_edit(' + customers[i].ID
							+ ')">编辑</a>|<a href="#" onclick="do_del('
							+ customers[i].ID + ')">删除</a></td><td>'
							+ customers[i].first_name + '</td><td>'
							+ customers[i].last_name + "</td><td>"
							+ customers[i].address + "</td><td>"
							+ customers[i].email + "</td><td>"
							+ customers[i].ID + "</td><td>"
							+ customers[i].last_update + "</td></tr>");
		}
	});
}

function getCustomerCount() {
	var posturl = "/Exam7/customer/ajaxGetCustomerCount";
	$.ajax({
		type : "post",
		url : posturl,
		async : false,
		success : function(data) {
			customerCount = data * 1;
			// alert(customerCount+"");
		}
	});

}

function makePage() {
	getCustomerCount();
	pageCount = parseInt(customerCount / 10);
	if (customerCount % 10 != 0) {
		pageCount++;
	}
	if (pageNum == 1) {
		$("#btn-go-pre").addClass("disabled");
	} else {
		$("#btn-go-pre").removeClass("disabled");
	}
	if (pageNum == pageCount) {
		$("#btn-go-next").addClass("disabled");
	} else {
		$("#btn-go-next").removeClass("disabled");
	}
	$("#page-num").val(pageNum);
	$("#pageCountShow").text("共计" + pageCount + '页');

}

function gotoPage(page) {
	getAndBindCustomers(page);
	pageNum = page;
	makePage();
}

function checkPageNum(pageNumStr) {
	if (pageNumStr.length <= 0) {
		return false;
	}
	var reg = /[0-9]\d*/;
	for ( var i in pageNumStr) {
		if (!reg.test(pageNumStr[i])) {
			return false;
		}
	}
	return true;
}

function do_del(cid) {
	if (confirm("删除后无法找回，是否继续？")) {
		var url = '/Exam7/customer/ajaxDeleteCustomer';
		$.ajax({
			type : "post",
			url : url,
			async : false,
			data : {
				"cid" : cid
			},
			success : function(data) {
				if (data == 'OK') {
					alert("删除成功");
					gotoPage(pageNum);
				} else {
					alert("外键约束，删除失败");
				}
			} 
		});// end ajax
	}// end confirm
}

function do_edit(cid) {
	var url = '/Exam7/customer/ajaxGetCustomer';
	var c;
	$.ajax({
		type : "post",
		url : url,
		async : false,
		data : {
			"cid" : cid
		},
		success : function(data) {
			c=eval('('+data+')');
		} 
	});// end ajax
	$("#id-edit").val(c.ID);
	$("#first-name-edit").val(c.first_name);
	$("#last-name-edit").val(c.last_name);
	$("#email-edit").val(c.email);
	$("#address-id-edit").children().attr("selected","");
	$("#address-id-edit").children("[value='"+c.address_id+"']").attr("selected","selected");
	$('#editmodal').modal('show');
}

function edit_check(){
	if ($("#first-name-edit").val() == "") {
		alert("First Name不能为空");
		$("#first-name-edit").focus();
		return;
	} else if ($("#last-name-edit").val() == "") {
		alert("Last Name不能为空");
		$("#last-name-edit").focus();
		return;
	}
	var url='/Exam7/customer/ajaxEditCustomer';
	$.ajax({
		type : "post",
		url : url,
		async : false,
		data : $('#form-edit').serialize(),
		success : function(data) {
			if(data=='OK'){
				alert("修改成功");
				gotoPage(pageNum);
				$('#editmodal').modal('hide')
			}else{
				alert("修改失败，请联系管理员")
				$('#editmodal').modal('hide')
			}
		} 
	});// end ajax
}
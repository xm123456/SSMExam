<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.sakila.Entity.Address"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../css/customer_index.css">
<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/customer_index.js"></script>
<title>客户管理</title>
<%!List<Address> al;%>
<%
    al = (List<Address>) request.getAttribute("address_list");
%>
</head>
<body>
	<div id="Title">
		<h1>客户管理</h1>
	</div>
	<div id="body" class="container">
		<div class="panel panel-default" style="margin-top: 8px;">
			<div id="this-panal-head" class="panel-heading">
				<h3 class="panel-title" style="display: inline;">客户列表</h3>
				<span class="pad"></span> <a href="/Exam7/customer/addCustomer"
					class="btn btn-info" id="newCustomer">新建</a>
			</div>
			<div class="panel-body">
				<div id="table-container" class="col-md-12">
					<table
						class="table table-striped table-bordered table-condensed table-hover ">
						<thead>
							<tr>
								<th>操作</th>
								<th>First Name</th>
								<th>Last Name</th>
								<th>Address</th>
								<th>Email</th>
								<th>Customer ID</th>
								<th>Last Update</th>
							</tr>
						</thead>
						<tbody id="datas">
						</tbody>
					</table>
				</div>
				<div id="pages" class="col-md-12">
					<ul class="pagination" style="margin-left:40%;">
						<li><a id="btn-go-pre" href="#btn-go-pre"
							aria-label="Previous" class="btn"> <span aria-hidden="true">&laquo;</span>
						</a></li>
						<li><input id="page-num"
							style="height: 34px; width: 72px; text-align: center;"
							type="text" value="" /></li>
						<li><a href="#nav-page" class="btn btn-default" role="button"
							id="btn-goto">前往</a></li>
						<li><a id="btn-go-next" href="#btn-go-next" aria-label="Next"
							class="btn"> <span aria-hidden="true">&raquo;</span>
						</a></li>
						<li style="padding-top: 6px;"><small id="pageCountShow">
						</small></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="editmodal" style="position: absolute; top: 25%;" data-backdrop="false">
        <div class="modal-dialog modal-lg" style="width: 50%;">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">修改用户信息</h4>
                </div>
                <div class="modal-body"  style="width: 70%;margin:0 auto;">
                   <form id="form-edit" action="/Exam7/customer/addCustomer" method="post"
                    name="customer-edit">
                    <input id="id-edit" type="hidden" value="" name="customer_id" />
                        <table class="table table-condensed table-hover ">
                            <tr>
                                <td><span>First Name<span class="red-word">*</span></span></td>
                                <td><input id="first-name-edit" type="text" class="form-control" id="input-first-name"
                                    name="first_name" /></td>
                            </tr>
                            <tr>
                                <td><span>Last Name<span class="red-word">*</span></span></td>
                                <td><input id="last-name-edit" type="text" class="form-control" id="input-last-name"
                                    name="last_name" /></td>
                            </tr>
                            <tr>
                                <td><span>Email</span></td>
                                <td><input id="email-edit" type="text" class="form-control" name="email" /></td>
                            </tr>
                            <tr>
                                <td><span>Address<span class="red-word">*</span></span></td>
                                <td>
                                    <p style="text-align: center;">
                                        <select id="address-id-edit" name="address_id" class="form-control">
                                            <%
                                                for (int i = 0; i < al.size(); i++) {
                                            %>
                                            <option value="<%=al.get(i).getID()%>"><%=al.get(i).getAddress()%></option>
                                            <%
                                                }
                                            %>
                                        </select>
                                    </p>
                                </td>
                            </tr>
                        </table>
                        <div style="padding: 5px; text-align: center; margin-top: 5px;">
                            <a class="btn btn-info" onclick="edit_check();" >提交</a>
                        </div>
                </form>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>
    <!-- /.modal -->
</body>
</html>